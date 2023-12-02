package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.vivo.identifier.IdentifierIdClient;
/* loaded from: classes7.dex */
public class om1 implements fm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nm1 a;
    public String b;
    public mm1 c;

    public om1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.fm1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = this.a.a(0, null);
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fm1
    public void a(Context context, gm1 gm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gm1Var) == null) {
            this.a = new nm1(context);
            if (b()) {
                this.c = new mm1(this);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.c);
            }
            if (gm1Var != null) {
                gm1Var.a();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                str = (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class, String.class).invoke(cls, IdentifierIdClient.SYS_IDENTIFIERID_SUPPORTED, "0");
            } catch (Throwable unused) {
                str = null;
            }
            if ("1".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
