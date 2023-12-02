package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class xdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ydb a;
    public final NewWriteModel b;
    public boolean c;
    public final NewWriteModel.d d;

    /* loaded from: classes9.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xdb a;

        public a(xdb xdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xdbVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) && this.a.a != null && this.a.b != null && this.a.b.e0() != null) {
                this.a.a.p(false);
                if (writeData == null) {
                    writeData = this.a.b.e0();
                }
                WriteData writeData2 = writeData;
                if (!z) {
                    if (writeData2 != null && o95Var != null && !TextUtils.isEmpty(o95Var.d())) {
                        writeData2.setVcodeMD5(o95Var.b());
                        writeData2.setVcodeUrl(o95Var.c());
                        writeData2.setVcodeExtra(o95Var.a());
                        this.a.a.g().setVisible(false);
                        if (VcodeTool.needVcode(o95Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.g().getActivity(), 12006, writeData2, false, o95Var.d())));
                            return;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.g().getActivity(), writeData2, 12006)));
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        BaseActivity g = this.a.a.g();
                        this.a.a.g();
                        g.setResult(0, intent);
                        this.a.a.g().finish();
                        return;
                    } else {
                        if (postWriteCallBackData != null) {
                            sya.b(this.a.a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                            BaseActivity g2 = this.a.a.g();
                            this.a.a.g();
                            g2.setResult(0, null);
                        }
                        this.a.a.g().finish();
                        return;
                    }
                }
                this.a.c = true;
                if (postWriteCallBackData == null) {
                    sya.b(this.a.a.g().getActivity(), this.a.a.g().getResources().getString(R.string.send_success), null, null);
                } else {
                    sya.b(this.a.a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity g3 = this.a.a.g();
                this.a.a.g();
                g3.setResult(-1, intent2);
                this.a.a.g().finish();
            }
        }
    }

    public xdb(ydb ydbVar, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ydbVar, newWriteModel};
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
        this.a = ydbVar;
        this.b = newWriteModel;
        newWriteModel.m0(aVar);
    }

    public void h(String str) {
        ydb ydbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (ydbVar = this.a) != null) {
            ydbVar.q(true);
            this.a.r(false);
            this.a.j().loadUrl(str);
        }
    }

    public void d() {
        ydb ydbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ydbVar = this.a) != null) {
            ydbVar.s(500);
        }
    }

    public void e() {
        ydb ydbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ydbVar = this.a) != null) {
            ydbVar.p(false);
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
                this.a.g().finish();
                return true;
            } else if (str.equals(AccountAccessActivity.h)) {
                this.a.o(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
                if (this.a.h() != this.a.i()) {
                    ydb ydbVar = this.a;
                    ydbVar.n(ydbVar.h());
                    this.a.t();
                }
                this.a.j().setVisibility(0);
                return true;
            } else if (str.equals(AccountAccessActivity.i)) {
                g();
                return true;
            } else if (str.equals(AccountAccessActivity.j) || str.equals(AccountAccessActivity.k)) {
                this.a.g().finish();
                UrlManager.getInstance().dealOneLink(this.a.g().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
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
            if (!BdUtilHelper.isNetOk()) {
                this.a.g().showToast(R.string.obfuscated_res_0x7f0f0e70);
                this.a.g().finish();
                return;
            }
            this.a.p(true);
            this.b.p0();
        }
    }
}
