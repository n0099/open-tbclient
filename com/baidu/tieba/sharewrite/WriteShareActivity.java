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
import b.a.q0.t.c.m0;
import b.a.r0.e3.a;
import b.a.r0.e3.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
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
    public a.c mFailYesDialogClickListener;
    public final View.OnFocusChangeListener mFocusChangeListener;
    public b.a.r0.e3.b mGetForumPrefixModel;
    public InputMethodManager mInputManager;
    public boolean mIsGotoVcode;
    public boolean mIsShareSuccess;
    public a.c mNoDialogClickListener;
    public View.OnClickListener mNvBackClickListener;
    public final NewWriteModel.e mOnImageUploadCallback;
    public final NewWriteModel.f mOnPostWriteCallback;
    public View.OnClickListener mPostClickListener;
    public View.OnClickListener mPostContentClickListener;
    public PostPrefixData mPrefixData;
    public String mShareContent;
    public b.a.r0.e3.a mShareFailDialog;
    public String mShareImageUrl;
    public byte[] mShareLocalImageData;
    public b.a.r0.e3.a mShareSuccessDialog;
    public String mShareTargetBaName;
    public String mShareTitle;
    public String mShareUrl;
    public a.c mSuccessYesDialogClickListener;
    public b.a.r0.e3.c mView;
    public NewWriteModel mWriteModel;
    public String packageName;
    public PackageInfo packageinfo;
    public PackageManager pm;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53950e;

        public a(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53950e = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                WriteShareActivity writeShareActivity = this.f53950e;
                writeShareActivity.HidenSoftKeyPad(writeShareActivity.mInputManager, this.f53950e.mView.q());
                WriteShareActivity writeShareActivity2 = this.f53950e;
                writeShareActivity2.HidenSoftKeyPad(writeShareActivity2.mInputManager, this.f53950e.mView.p());
                this.f53950e.PostNewMessage();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53951e;

        public b(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53951e = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53951e.mView.p().requestFocus();
                WriteShareActivity writeShareActivity = this.f53951e;
                writeShareActivity.ShowSoftKeyPad(writeShareActivity.mInputManager, this.f53951e.mView.p());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53952e;

        public c(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53952e = writeShareActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || this.f53952e.mView == null) {
                return;
            }
            if (view == this.f53952e.mView.q() || view == this.f53952e.mView.n() || view == this.f53952e.mView.o()) {
                if (!z) {
                    if (view == this.f53952e.mView.q() && this.f53952e.mView.r() != null) {
                        this.f53952e.mView.r().setVisibility(0);
                    }
                } else {
                    WriteShareActivity writeShareActivity = this.f53952e;
                    writeShareActivity.ShowSoftKeyPad(writeShareActivity.mInputManager, this.f53952e.mView.q());
                }
            }
            if (view == this.f53952e.mView.p()) {
                if (z) {
                    this.f53952e.mView.p().setHint((CharSequence) null);
                } else {
                    this.f53952e.mView.p().setHint(R.string.content);
                }
                WriteShareActivity writeShareActivity2 = this.f53952e;
                writeShareActivity2.ShowSoftKeyPad(writeShareActivity2.mInputManager, this.f53952e.mView.q());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53953a;

        public d(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53953a = writeShareActivity;
        }

        @Override // b.a.r0.e3.a.c
        public void a(b.a.r0.e3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f53953a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f53953a.getPageContext().getPageActivity()).createBackSpecialCfg(this.f53953a.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
                aVar.d();
                this.f53953a.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53954a;

        public e(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53954a = writeShareActivity;
        }

        @Override // b.a.r0.e3.a.c
        public void a(b.a.r0.e3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                WriteShareActivity writeShareActivity = this.f53954a;
                writeShareActivity.HidenSoftKeyPad(writeShareActivity.mInputManager, this.f53954a.mView.q());
                WriteShareActivity writeShareActivity2 = this.f53954a;
                writeShareActivity2.HidenSoftKeyPad(writeShareActivity2.mInputManager, this.f53954a.mView.p());
                this.f53954a.PostNewMessage();
                aVar.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53955a;

        public f(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53955a = writeShareActivity;
        }

        @Override // b.a.r0.e3.a.c
        public void a(b.a.r0.e3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.d();
                if (!this.f53955a.mIsShareSuccess) {
                    this.f53955a.setResult(0);
                }
                b.a.q0.s.b0.b.g(this.f53955a.getPageContext().getPageActivity(), 200, false);
                this.f53955a.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53956a;

        public g(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53956a = writeShareActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            ImageUploadResult.picInfo picinfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, imageUploadResult, z) == null) {
                if (imageUploadResult == null || (picinfo = imageUploadResult.picInfo) == null || picinfo.originPic == null) {
                    this.f53956a.mData.setShareSummaryImg("");
                    this.f53956a.mData.setShareSummaryImgHeight(0);
                    this.f53956a.mData.setShareSummaryImgWidth(0);
                    return;
                }
                this.f53956a.mData.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
                this.f53956a.mData.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
                this.f53956a.mData.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements NewWriteModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53957a;

        public h(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53957a = writeShareActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.f
        public void a(boolean z, String str, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, m0Var, writeData, antiData}) == null) {
                this.f53957a.closeLoadingDialog();
                if (z) {
                    this.f53957a.createShareSuccessDialog();
                    if (this.f53957a.mShareSuccessDialog != null) {
                        this.f53957a.mIsShareSuccess = true;
                        this.f53957a.setResult(-1);
                        this.f53957a.mShareSuccessDialog.o();
                    }
                } else if (m0Var == null || writeData == null || m0Var.c() == null) {
                    this.f53957a.createShareFailDialog();
                    if (this.f53957a.mShareFailDialog != null) {
                        this.f53957a.mIsShareSuccess = false;
                        this.f53957a.mShareFailDialog.o();
                    }
                } else {
                    writeData.setVcodeMD5(m0Var.b());
                    writeData.setVcodeUrl(m0Var.c());
                    writeData.setVcodeExtra(m0Var.a());
                    this.f53957a.mIsGotoVcode = true;
                    if (b.a.q0.e1.a.b(m0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f53957a.getPageContext().getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, false, m0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f53957a.getPageContext().getPageActivity(), writeData, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53958e;

        public i(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53958e = writeShareActivity;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                if (i2 == 4) {
                    if (this.f53958e.mView != null && this.f53958e.mView.s() != null && this.f53958e.mView.s().isShowing()) {
                        b.a.e.e.m.g.d(this.f53958e.mView.s(), this.f53958e.getPageContext().getPageActivity());
                        return true;
                    }
                    this.f53958e.stopTask();
                    if (this.f53958e.mIsShareSuccess) {
                        this.f53958e.setResult(-1);
                    } else {
                        this.f53958e.setResult(0);
                    }
                    b.a.q0.s.b0.b.g(this.f53958e.getPageContext().getPageActivity(), 200, false);
                    this.f53958e.finish();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class j implements b.InterfaceC0832b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53959a;

        public j(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53959a = writeShareActivity;
        }

        @Override // b.a.r0.e3.b.InterfaceC0832b
        public void a(boolean z, PostPrefixData postPrefixData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, postPrefixData) == null) {
                if (z) {
                    this.f53959a.mPrefixData = postPrefixData;
                    if (this.f53959a.mPrefixData == null || this.f53959a.mPrefixData.getPrefixs().size() <= 0) {
                        return;
                    }
                    this.f53959a.mPrefixData.getPrefixs().add(this.f53959a.getPageContext().getString(R.string.write_no_prefix));
                    if (this.f53959a.mView != null) {
                        this.f53959a.mView.F(this.f53959a.mPrefixData);
                        return;
                    }
                    return;
                }
                this.f53959a.mPrefixData = null;
                this.f53959a.mView.F(null);
            }
        }

        @Override // b.a.r0.e3.b.InterfaceC0832b
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f53959a.mPrefixData = null;
                this.f53959a.mView.F(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53960e;

        public k(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53960e = writeShareActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f53960e.destroyWaitingDialog();
                this.f53960e.stopTask();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53961e;

        public l(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53961e = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53961e.stopTask();
                if (this.f53961e.mIsShareSuccess) {
                    this.f53961e.setResult(-1);
                }
                b.a.q0.s.b0.b.g(this.f53961e.getPageContext().getPageActivity(), 200, false);
                this.f53961e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Activity f53962e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f53963f;

        public m(WriteShareActivity writeShareActivity, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53963f = writeShareActivity;
            this.f53962e = null;
            this.f53962e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53962e == null) {
                return;
            }
            this.f53963f.setResult(0);
            b.a.q0.s.b0.b.g(this.f53962e, 200, false);
            this.f53962e.finish();
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
            this.mWriteModel.X().setVoice(null);
            this.mWriteModel.X().setVoiceDuringTime(-1);
            if (this.mWriteModel.l0()) {
                showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createShareFailDialog() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && this.mShareFailDialog == null) {
            b.a.r0.e3.a aVar = new b.a.r0.e3.a(getActivity());
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && this.mShareSuccessDialog == null) {
            b.a.r0.e3.a aVar = new b.a.r0.e3.a(getActivity());
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
            newWriteModel.g0(this.mOnPostWriteCallback);
            this.mWriteModel.e0(this.mOnImageUploadCallback);
            this.mGetForumPrefixModel = new b.a.r0.e3.b(this, new j(this));
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
                    this.mWriteModel.f0(this.mShareLocalImageData, this.mShareImageUrl);
                    this.mData.setShareLocalImageUri(this.mShareImageUrl);
                    this.mData.setShareLocalImageData(this.mShareLocalImageData);
                    this.mWriteModel.k0();
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
            setContentView(R.layout.write_share_activity);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            b.a.r0.e3.c cVar = new b.a.r0.e3.c(this);
            this.mView = cVar;
            cVar.C(this.mNvBackClickListener);
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
        b.a.r0.e3.c cVar;
        ShareSDKImageView t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (cVar = this.mView) == null || (t = cVar.t()) == null) {
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
                    b.a.r0.e3.a aVar = this.mShareSuccessDialog;
                    if (aVar != null) {
                        this.mIsShareSuccess = true;
                        aVar.o();
                    }
                    setResult(-1);
                    return;
                }
                createShareFailDialog();
                b.a.r0.e3.a aVar2 = this.mShareFailDialog;
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
            b.a.r0.e3.c cVar = this.mView;
            if (cVar != null) {
                cVar.z(i2);
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
                b.a.r0.e3.c cVar = this.mView;
                if (cVar != null && cVar.s() != null && this.mView.s().isShowing()) {
                    b.a.e.e.m.g.d(this.mView.s(), getPageContext().getPageActivity());
                    return true;
                }
                stopTask();
                if (this.mIsShareSuccess) {
                    setResult(-1);
                } else {
                    setResult(0);
                }
                b.a.q0.s.b0.b.g(getPageContext().getPageActivity(), 200, false);
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
            b.a.r0.e3.c cVar = this.mView;
            if (cVar == null || cVar.p() == null || (obj = this.mView.p().getEditableText().toString()) == null) {
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
            b.a.e.e.p.l.I(getPageContext().getContext(), i2);
            new Handler().postDelayed(new m(this, getPageContext().getPageActivity()), 3500L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, onCancelListener) == null) {
            super.showLoadingDialog(str, onCancelListener);
            b.a.q0.s.g0.a aVar = this.mWaitingDialog;
            if (aVar != null) {
                aVar.g(false);
            }
        }
    }

    public void stopLoadImageTask() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (newWriteModel = this.mWriteModel) == null) {
            return;
        }
        newWriteModel.T();
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
