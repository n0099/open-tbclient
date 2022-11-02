package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p39 a;
    public final NewWriteModel b;
    public boolean c;
    public final NewWriteModel.d d;

    /* loaded from: classes5.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o39 a;

        public a(o39 o39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o39Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w25 w25Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, w25Var, writeData, antiData}) == null) && this.a.a != null && this.a.b != null && this.a.b.S() != null) {
                this.a.a.o(false);
                if (writeData == null) {
                    writeData = this.a.b.S();
                }
                WriteData writeData2 = writeData;
                if (!z) {
                    if (writeData2 != null && w25Var != null && !TextUtils.isEmpty(w25Var.d())) {
                        writeData2.setVcodeMD5(w25Var.b());
                        writeData2.setVcodeUrl(w25Var.c());
                        writeData2.setVcodeExtra(w25Var.a());
                        this.a.a.getContext().setVisible(false);
                        if (ak5.b(w25Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getContext().getActivity(), 12006, writeData2, false, w25Var.d())));
                            return;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getContext().getActivity(), writeData2, 12006)));
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        BaseActivity context = this.a.a.getContext();
                        this.a.a.getContext();
                        context.setResult(0, intent);
                        this.a.a.getContext().finish();
                        return;
                    } else {
                        if (postWriteCallBackData != null) {
                            dr8.b(this.a.a.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                            BaseActivity context2 = this.a.a.getContext();
                            this.a.a.getContext();
                            context2.setResult(0, null);
                        }
                        this.a.a.getContext().finish();
                        return;
                    }
                }
                this.a.c = true;
                if (postWriteCallBackData == null) {
                    dr8.b(this.a.a.getContext().getActivity(), this.a.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f115f), null, null);
                } else {
                    dr8.b(this.a.a.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity context3 = this.a.a.getContext();
                this.a.a.getContext();
                context3.setResult(-1, intent2);
                this.a.a.getContext().finish();
            }
        }
    }

    public o39(p39 p39Var, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p39Var, newWriteModel};
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
        this.d = aVar;
        this.a = p39Var;
        this.b = newWriteModel;
        newWriteModel.b0(aVar);
    }

    public void h(String str) {
        p39 p39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (p39Var = this.a) != null) {
            p39Var.p(true);
            this.a.q(false);
            this.a.i().loadUrl(str);
        }
    }

    public void d() {
        p39 p39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p39Var = this.a) != null) {
            p39Var.r(500);
        }
    }

    public void e() {
        p39 p39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (p39Var = this.a) != null) {
            p39Var.o(false);
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.a == null || str == null) {
                return false;
            }
            if (str.equals(AccountAccessActivity.g)) {
                this.a.getContext().finish();
                return true;
            } else if (str.equals(AccountAccessActivity.h)) {
                this.a.n(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
                if (this.a.g() != this.a.h()) {
                    p39 p39Var = this.a;
                    p39Var.m(p39Var.g());
                    this.a.s();
                }
                this.a.i().setVisibility(0);
                return true;
            } else if (str.equals(AccountAccessActivity.i)) {
                g();
                return true;
            } else if (str.equals(AccountAccessActivity.j) || str.equals(AccountAccessActivity.k)) {
                this.a.getContext().finish();
                UrlManager.getInstance().dealOneLink(this.a.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
                return true;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a != null && this.b != null) {
            if (!xi.F()) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0c7f);
                this.a.getContext().finish();
                return;
            }
            this.a.o(true);
            this.b.e0();
        }
    }
}
