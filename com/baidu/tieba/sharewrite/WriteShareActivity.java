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
import c.a.p0.t.c.k0;
import c.a.q0.c3.a;
import c.a.q0.c3.b;
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
/* loaded from: classes7.dex */
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
    public c.a.q0.c3.b mGetForumPrefixModel;
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
    public c.a.q0.c3.a mShareFailDialog;
    public String mShareImageUrl;
    public byte[] mShareLocalImageData;
    public c.a.q0.c3.a mShareSuccessDialog;
    public String mShareTargetBaName;
    public String mShareTitle;
    public String mShareUrl;
    public a.c mSuccessYesDialogClickListener;
    public c.a.q0.c3.c mView;
    public NewWriteModel mWriteModel;
    public String packageName;
    public PackageInfo packageinfo;
    public PackageManager pm;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56645e;

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
            this.f56645e = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                WriteShareActivity writeShareActivity = this.f56645e;
                writeShareActivity.HidenSoftKeyPad(writeShareActivity.mInputManager, this.f56645e.mView.q());
                WriteShareActivity writeShareActivity2 = this.f56645e;
                writeShareActivity2.HidenSoftKeyPad(writeShareActivity2.mInputManager, this.f56645e.mView.p());
                this.f56645e.PostNewMessage();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56646e;

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
            this.f56646e = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56646e.mView.p().requestFocus();
                WriteShareActivity writeShareActivity = this.f56646e;
                writeShareActivity.ShowSoftKeyPad(writeShareActivity.mInputManager, this.f56646e.mView.p());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56647e;

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
            this.f56647e = writeShareActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || this.f56647e.mView == null) {
                return;
            }
            if (view == this.f56647e.mView.q() || view == this.f56647e.mView.n() || view == this.f56647e.mView.o()) {
                if (!z) {
                    if (view == this.f56647e.mView.q() && this.f56647e.mView.r() != null) {
                        this.f56647e.mView.r().setVisibility(0);
                    }
                } else {
                    WriteShareActivity writeShareActivity = this.f56647e;
                    writeShareActivity.ShowSoftKeyPad(writeShareActivity.mInputManager, this.f56647e.mView.q());
                }
            }
            if (view == this.f56647e.mView.p()) {
                if (z) {
                    this.f56647e.mView.p().setHint((CharSequence) null);
                } else {
                    this.f56647e.mView.p().setHint(R.string.content);
                }
                WriteShareActivity writeShareActivity2 = this.f56647e;
                writeShareActivity2.ShowSoftKeyPad(writeShareActivity2.mInputManager, this.f56647e.mView.q());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56648a;

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
            this.f56648a = writeShareActivity;
        }

        @Override // c.a.q0.c3.a.c
        public void a(c.a.q0.c3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f56648a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f56648a.getPageContext().getPageActivity()).createBackSpecialCfg(this.f56648a.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
                aVar.d();
                this.f56648a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56649a;

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
            this.f56649a = writeShareActivity;
        }

        @Override // c.a.q0.c3.a.c
        public void a(c.a.q0.c3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                WriteShareActivity writeShareActivity = this.f56649a;
                writeShareActivity.HidenSoftKeyPad(writeShareActivity.mInputManager, this.f56649a.mView.q());
                WriteShareActivity writeShareActivity2 = this.f56649a;
                writeShareActivity2.HidenSoftKeyPad(writeShareActivity2.mInputManager, this.f56649a.mView.p());
                this.f56649a.PostNewMessage();
                aVar.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56650a;

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
            this.f56650a = writeShareActivity;
        }

        @Override // c.a.q0.c3.a.c
        public void a(c.a.q0.c3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.d();
                if (!this.f56650a.mIsShareSuccess) {
                    this.f56650a.setResult(0);
                }
                c.a.p0.s.a0.b.g(this.f56650a.getPageContext().getPageActivity(), 200, false);
                this.f56650a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56651a;

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
            this.f56651a = writeShareActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            ImageUploadResult.picInfo picinfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, imageUploadResult, z) == null) {
                if (imageUploadResult == null || (picinfo = imageUploadResult.picInfo) == null || picinfo.originPic == null) {
                    this.f56651a.mData.setShareSummaryImg("");
                    this.f56651a.mData.setShareSummaryImgHeight(0);
                    this.f56651a.mData.setShareSummaryImgWidth(0);
                    return;
                }
                this.f56651a.mData.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
                this.f56651a.mData.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
                this.f56651a.mData.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements NewWriteModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56652a;

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
            this.f56652a = writeShareActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.f
        public void a(boolean z, String str, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, k0Var, writeData, antiData}) == null) {
                this.f56652a.closeLoadingDialog();
                if (z) {
                    this.f56652a.createShareSuccessDialog();
                    if (this.f56652a.mShareSuccessDialog != null) {
                        this.f56652a.mIsShareSuccess = true;
                        this.f56652a.setResult(-1);
                        this.f56652a.mShareSuccessDialog.o();
                    }
                } else if (k0Var == null || writeData == null || k0Var.c() == null) {
                    this.f56652a.createShareFailDialog();
                    if (this.f56652a.mShareFailDialog != null) {
                        this.f56652a.mIsShareSuccess = false;
                        this.f56652a.mShareFailDialog.o();
                    }
                } else {
                    writeData.setVcodeMD5(k0Var.b());
                    writeData.setVcodeUrl(k0Var.c());
                    writeData.setVcodeExtra(k0Var.a());
                    this.f56652a.mIsGotoVcode = true;
                    if (c.a.p0.c1.a.b(k0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f56652a.getPageContext().getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, false, k0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f56652a.getPageContext().getPageActivity(), writeData, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56653e;

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
            this.f56653e = writeShareActivity;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                if (i2 == 4) {
                    if (this.f56653e.mView != null && this.f56653e.mView.s() != null && this.f56653e.mView.s().isShowing()) {
                        c.a.e.e.m.g.d(this.f56653e.mView.s(), this.f56653e.getPageContext().getPageActivity());
                        return true;
                    }
                    this.f56653e.stopTask();
                    if (this.f56653e.mIsShareSuccess) {
                        this.f56653e.setResult(-1);
                    } else {
                        this.f56653e.setResult(0);
                    }
                    c.a.p0.s.a0.b.g(this.f56653e.getPageContext().getPageActivity(), 200, false);
                    this.f56653e.finish();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements b.InterfaceC0797b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56654a;

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
            this.f56654a = writeShareActivity;
        }

        @Override // c.a.q0.c3.b.InterfaceC0797b
        public void a(boolean z, PostPrefixData postPrefixData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, postPrefixData) == null) {
                if (z) {
                    this.f56654a.mPrefixData = postPrefixData;
                    if (this.f56654a.mPrefixData == null || this.f56654a.mPrefixData.getPrefixs().size() <= 0) {
                        return;
                    }
                    this.f56654a.mPrefixData.getPrefixs().add(this.f56654a.getPageContext().getString(R.string.write_no_prefix));
                    if (this.f56654a.mView != null) {
                        this.f56654a.mView.F(this.f56654a.mPrefixData);
                        return;
                    }
                    return;
                }
                this.f56654a.mPrefixData = null;
                this.f56654a.mView.F(null);
            }
        }

        @Override // c.a.q0.c3.b.InterfaceC0797b
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f56654a.mPrefixData = null;
                this.f56654a.mView.F(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56655e;

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
            this.f56655e = writeShareActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f56655e.destroyWaitingDialog();
                this.f56655e.stopTask();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56656e;

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
            this.f56656e = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56656e.stopTask();
                if (this.f56656e.mIsShareSuccess) {
                    this.f56656e.setResult(-1);
                }
                c.a.p0.s.a0.b.g(this.f56656e.getPageContext().getPageActivity(), 200, false);
                this.f56656e.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Activity f56657e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WriteShareActivity f56658f;

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
            this.f56658f = writeShareActivity;
            this.f56657e = null;
            this.f56657e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56657e == null) {
                return;
            }
            this.f56658f.setResult(0);
            c.a.p0.s.a0.b.g(this.f56657e, 200, false);
            this.f56657e.finish();
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
            c.a.q0.c3.a aVar = new c.a.q0.c3.a(getActivity());
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
            c.a.q0.c3.a aVar = new c.a.q0.c3.a(getActivity());
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
            this.mGetForumPrefixModel = new c.a.q0.c3.b(this, new j(this));
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
            c.a.q0.c3.c cVar = new c.a.q0.c3.c(this);
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
        c.a.q0.c3.c cVar;
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
                    c.a.q0.c3.a aVar = this.mShareSuccessDialog;
                    if (aVar != null) {
                        this.mIsShareSuccess = true;
                        aVar.o();
                    }
                    setResult(-1);
                    return;
                }
                createShareFailDialog();
                c.a.q0.c3.a aVar2 = this.mShareFailDialog;
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.q0.c3.c cVar = this.mView;
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
                c.a.q0.c3.c cVar = this.mView;
                if (cVar != null && cVar.s() != null && this.mView.s().isShowing()) {
                    c.a.e.e.m.g.d(this.mView.s(), getPageContext().getPageActivity());
                    return true;
                }
                stopTask();
                if (this.mIsShareSuccess) {
                    setResult(-1);
                } else {
                    setResult(0);
                }
                c.a.p0.s.a0.b.g(getPageContext().getPageActivity(), 200, false);
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
            c.a.q0.c3.c cVar = this.mView;
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
            c.a.e.e.p.l.I(getPageContext().getContext(), i2);
            new Handler().postDelayed(new m(this, getPageContext().getPageActivity()), 3500L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, onCancelListener) == null) {
            super.showLoadingDialog(str, onCancelListener);
            c.a.p0.s.f0.a aVar = this.mWaitingDialog;
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
