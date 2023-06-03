package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mfa implements lfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final NewVcodeView a;
    @NonNull
    public final NewWriteModel b;
    public final NewWriteModel.d c;

    @Override // com.baidu.tieba.lfa
    public void c(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
        }
    }

    @Override // com.baidu.tieba.lfa
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    @Override // com.baidu.tieba.lfa
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mfa a;

        public a(mfa mfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mfaVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, xd5 xd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, xd5Var, writeData, antiData}) == null) {
                this.a.a.showPostThreadLoadingView(false);
                if (z) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    hx9.j(writeData);
                    k0a.a(writeData, postWriteCallBackData.getThreadId());
                    this.a.a.getContext().setResult(-1, intent);
                    this.a.a.getContext().finish();
                } else if (xd5Var != null && !TextUtils.isEmpty(xd5Var.c())) {
                    if (this.a.a.getWebView() != null) {
                        this.a.a.getWebView().loadUrl(xd5Var.c());
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        this.a.a.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    this.a.a.getContext().finish();
                }
            }
        }
    }

    public mfa(@NonNull NewVcodeView newVcodeView, @NonNull NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newVcodeView, newWriteModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.c = aVar;
        this.a = newVcodeView;
        this.b = newWriteModel;
        newWriteModel.s0(aVar);
    }

    @Override // com.baidu.tieba.lfa
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (TextUtils.isEmpty(str) || !str.contains("objc:jsAiCodeBack")) {
                return false;
            }
            String a2 = fy5.a(str);
            if (!TextUtils.isEmpty(a2) && !"0".equals(a2)) {
                g(a2);
                return true;
            }
            this.a.getContext().finish();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.lfa
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.showWebView(false);
            if (this.b.k0() == null) {
                return;
            }
            String vcodeUrl = this.b.k0().getVcodeUrl();
            if (!TextUtils.isEmpty(vcodeUrl) && this.a.getWebView() != null) {
                this.a.getWebView().loadUrl(vcodeUrl);
            }
        }
    }

    @Override // com.baidu.tieba.lfa
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.showPostThreadLoadingView(false);
            this.b.cancelLoadData();
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!vi.F()) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0def);
                this.a.getContext().finish();
            } else if (!TextUtils.isEmpty(str)) {
                this.a.showPostThreadLoadingView(true);
                if (this.b.k0() != null) {
                    this.b.k0().setVcode(str);
                    this.b.k0().setVcodeType("6");
                }
                this.b.v0();
            } else {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0def);
                this.a.getContext().finish();
            }
        }
    }

    @Override // com.baidu.tieba.lfa
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) {
            this.a.showWebViewDelay(500);
        }
    }
}
