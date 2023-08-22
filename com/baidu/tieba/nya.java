package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
public class nya implements oya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewVcodeView a;
    public final NewWriteModel b;
    public boolean c;
    public PostWriteCallBackData d;
    public final NewWriteModel.d e;
    public NewWriteModel.d f;

    @Override // com.baidu.tieba.oya
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    @Override // com.baidu.tieba.oya
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nya a;

        public a(nya nyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nyaVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qd5 qd5Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
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
                } else if (this.a.f != null) {
                    this.a.f.callback(false, postWriteCallBackData, qd5Var, writeData, antiData);
                    return;
                } else {
                    return;
                }
            }
            this.a.d = postWriteCallBackData;
            this.a.c = true;
            String str3 = null;
            if (qd5Var != null && qd5Var.a() != null) {
                String str4 = qd5Var.a().endPoint;
                String str5 = qd5Var.a().successImg;
                String str6 = qd5Var.a().slideEndPoint;
                str = str4;
                str3 = str5;
                str2 = str6;
            } else {
                str = null;
                str2 = null;
            }
            this.a.a.runJsMethod("success", str3 + "," + str + "," + str2);
            dfa.k(writeData);
            fia.a(writeData, postWriteCallBackData.getThreadId());
        }
    }

    public nya(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
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
        newWriteModel.l0(aVar);
    }

    @Override // com.baidu.tieba.oya
    public void c(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f = dVar;
        }
    }

    @Override // com.baidu.tieba.oya
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) && (newVcodeView = this.a) != null) {
            newVcodeView.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.oya
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.setRatio(0.9433962f);
            this.a.showWebView(false);
            this.a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // com.baidu.tieba.oya
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData d0;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.b.d0() == null || StringUtils.isNull(str) || (d0 = this.b.d0()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (d0.getVcodeExtra() == null) {
                    return false;
                }
                this.a.runJsMethod("handleFreshCaptcha", "'" + d0.getVcodeUrl() + "','" + d0.getVcodeExtra().slideImg + "','" + d0.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(VcodeTool.getJsCallback(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (d0.isAddThread()) {
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
                    eia.b(this.a.getContext().getActivity(), string, str3, str2);
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
                        mya.a(this.a.getContext().getPageContext());
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.oya
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
            if (!BdUtilHelper.isNetOk()) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0e29);
                this.a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.a.showPostThreadLoadingView(true);
                this.b.d0().setVcode(str);
                this.b.d0().setVcodeType("5");
                this.b.o0();
            } else {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0e29);
                this.a.getContext().finish();
            }
        }
    }
}
