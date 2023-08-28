package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rya implements pya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewVcodeView a;
    public final NewWriteModel b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public boolean g;
    public Runnable h;
    public final NewWriteModel.d i;
    public NewWriteModel.d j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rya a;

        public a(rya ryaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ryaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ryaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null) {
                return;
            }
            if (StringUtils.isNull(this.a.f)) {
                this.a.a.showToast(false, this.a.a.getContext().getResources().getString(R.string.drag_vcode_error));
            } else {
                this.a.a.showToast(false, this.a.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rya a;

        public b(rya ryaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ryaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ryaVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qd5 qd5Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qd5Var, writeData, antiData}) != null) || this.a.a == null) {
                return;
            }
            this.a.a.showPostThreadLoadingView(false);
            if (!z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    this.a.a.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    return;
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && this.a.j != null) {
                    if (this.a.j != null) {
                        this.a.j.callback(z, postWriteCallBackData, qd5Var, writeData, antiData);
                        return;
                    }
                    return;
                } else if (postWriteCallBackData == null) {
                    return;
                } else {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        this.a.a.showToast(false, this.a.a.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        this.a.a.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    this.a.m();
                    return;
                }
            }
            this.a.g = true;
            if (writeData != null && writeData.isAddThread() && !writeData.isWriteTest()) {
                String string = this.a.a.getContext().getResources().getString(R.string.send_success);
                String str2 = null;
                if (postWriteCallBackData != null) {
                    str2 = postWriteCallBackData.getPreMsg();
                    str = postWriteCallBackData.getColorMsg();
                    string = postWriteCallBackData.getErrorString();
                } else {
                    str = null;
                }
                eia.b(this.a.a.getContext().getActivity(), string, str2, str);
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            dfa.k(writeData);
            fia.a(writeData, postWriteCallBackData.getThreadId());
            BaseActivity context = this.a.a.getContext();
            this.a.a.getContext();
            context.setResult(-1, intent);
            this.a.a.getContext().finish();
        }
    }

    public rya(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
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
        this.e = false;
        this.f = null;
        this.h = new a(this);
        b bVar = new b(this);
        this.i = bVar;
        this.a = newVcodeView;
        this.b = newWriteModel;
        newWriteModel.l0(bVar);
    }

    @Override // com.baidu.tieba.pya
    public void c(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
                return false;
            }
            this.d = split[0];
            l(split[1]);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pya
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
            this.e = z;
            this.f = str;
        }
    }

    @Override // com.baidu.tieba.pya
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, webView, str) == null) && (newVcodeView = this.a) != null) {
            newVcodeView.showWebViewDelay(500);
            if (this.e) {
                SafeHandler.getInst().postDelayed(this.h, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.pya
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.setRatio(1.2631578f);
            this.a.showWebView(false);
            String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
            if (z) {
                str = str + "?feedback=1";
            }
            this.a.getWebView().loadUrl(str);
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!BdUtilHelper.isNetOk()) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0e29);
                this.a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.a.showPostThreadLoadingView(true);
                this.b.d0().setVcode(str);
                this.b.d0().setVcodeType("4");
                this.b.o0();
            } else {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0e29);
                this.a.getContext().finish();
            }
        }
    }

    @Override // com.baidu.tieba.pya
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (str.contains("objc:jsChangeVcode")) {
                String jsCallback = VcodeTool.getJsCallback(str);
                this.c = jsCallback;
                if (jsCallback == null || this.b.d0() == null) {
                    return false;
                }
                NewVcodeView newVcodeView = this.a;
                String str2 = this.c;
                newVcodeView.runJsMethod(str2, "'" + this.b.d0().getVcodeUrl() + "'");
                return true;
            } else if (str.equals("objc:jumpToFeedback()")) {
                NewVcodeView newVcodeView2 = this.a;
                if (newVcodeView2 != null && newVcodeView2.getContext() != null) {
                    nya.a(this.a.getContext().getPageContext());
                }
                return true;
            } else if (!str.contains("objc:jsSubmit")) {
                return false;
            } else {
                return k(VcodeTool.getJsCallback(str));
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.pya
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.showPostThreadLoadingView(false);
            this.b.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pya
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.h);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NewVcodeView newVcodeView = this.a;
            String str = this.d;
            newVcodeView.runJsMethod(str, "'" + this.b.d0().getVcodeUrl() + "'");
        }
    }
}
