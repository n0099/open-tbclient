package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
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
public class w2a implements x2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewVcodeView a;
    public final NewWriteModel b;
    public boolean c;
    public PostWriteCallBackData d;
    public final NewWriteModel.d e;
    public NewWriteModel.d f;

    @Override // com.baidu.tieba.x2a
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    @Override // com.baidu.tieba.x2a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w2a a;

        public a(w2a w2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w2aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b95 b95Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, b95Var, writeData, antiData}) != null) || this.a.a == null) {
                return;
            }
            this.a.a.showPostThreadLoadingView(false);
            if (!z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    this.a.a.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    return;
                } else if (this.a.f != null) {
                    this.a.f.callback(false, postWriteCallBackData, b95Var, writeData, antiData);
                    return;
                } else {
                    return;
                }
            }
            this.a.d = postWriteCallBackData;
            this.a.c = true;
            String str3 = null;
            if (b95Var != null && b95Var.a() != null) {
                String str4 = b95Var.a().endPoint;
                String str5 = b95Var.a().successImg;
                String str6 = b95Var.a().slideEndPoint;
                str = str4;
                str3 = str5;
                str2 = str6;
            } else {
                str = null;
                str2 = null;
            }
            this.a.a.runJsMethod("success", str3 + "," + str + "," + str2);
            dl9.j(writeData);
            go9.a(writeData, postWriteCallBackData.getThreadId());
        }
    }

    public w2a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
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
        this.e = aVar;
        this.a = newVcodeView;
        this.b = newWriteModel;
        newWriteModel.o0(aVar);
    }

    @Override // com.baidu.tieba.x2a
    public void c(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f = dVar;
        }
    }

    @Override // com.baidu.tieba.x2a
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) && (newVcodeView = this.a) != null) {
            newVcodeView.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.x2a
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.setRatio(0.9433962f);
            this.a.showWebView(false);
            this.a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // com.baidu.tieba.x2a
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData g0;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.b.g0() == null || StringUtils.isNull(str) || (g0 = this.b.g0()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (g0.getVcodeExtra() == null) {
                    return false;
                }
                this.a.runJsMethod("handleFreshCaptcha", "'" + g0.getVcodeUrl() + "','" + g0.getVcodeExtra().slideImg + "','" + g0.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(as5.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (g0.isAddThread()) {
                    String string = this.a.getContext().getResources().getString(R.string.send_success);
                    PostWriteCallBackData postWriteCallBackData = this.d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.d.getColorMsg();
                        string = this.d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    fo9.b(this.a.getContext().getActivity(), string, str3, str2);
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.d);
                intent.putExtras(bundle);
                BaseActivity context = this.a.getContext();
                this.a.getContext();
                context.setResult(-1, intent);
                this.a.getContext().finish();
                return true;
            } else {
                if (str.contains("objc:jumpToFeedback()")) {
                    NewVcodeView newVcodeView = this.a;
                    if (newVcodeView != null && newVcodeView.getContext() != null) {
                        v2a.a(this.a.getContext().getPageContext());
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.x2a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.showPostThreadLoadingView(false);
            this.b.cancelLoadData();
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!ii.F()) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d1b);
                this.a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.a.showPostThreadLoadingView(true);
                this.b.g0().setVcode(str);
                this.b.g0().setVcodeType("5");
                this.b.r0();
            } else {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d1b);
                this.a.getContext().finish();
            }
        }
    }
}
