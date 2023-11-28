package com.baidu.tieba;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.http.message.JsonResponsedMessage;
import com.baidu.tieba.http.message.ProtoResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class um8<T> extends pm8<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final long e;
    public transient /* synthetic */ FieldHolder $fh;
    public mm8<T> a;
    public HttpMessage b;
    public TbHttpMessageTask c;
    public tm8<T> d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948215913, "Lcom/baidu/tieba/um8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948215913, "Lcom/baidu/tieba/um8;");
                return;
            }
        }
        e = mc.b().a();
    }

    public final mm8<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (mm8) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public um8(mm8<T> builder) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((qm8) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a = builder;
        this.b = new HttpMessage(CmdConfigHttp.THE_COMMON_HTTP_CMD_FOR_ALL);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.THE_COMMON_HTTP_CMD_FOR_ALL, "");
        this.c = tbHttpMessageTask;
        tbHttpMessageTask.setIsNeedAddCommenParam(this.a.h());
        this.c.setIsNeedTbs(this.a.j());
        this.c.setIsNeedLogin(this.a.u());
        this.c.setIsNeedCookie(this.a.i());
        this.c.setPriority(this.a.l());
        this.c.setIsUseCurrentBDUSS(this.a.g());
        this.c.setIsBDImage(this.a.p());
        this.c.setIsFromCDN(this.a.r());
        this.c.setIsNeedAddStatisticsParam(this.a.s());
        this.c.setmIsNBaiduServer(this.a.q());
        this.c.setIsNeedToast(this.a.v());
        this.c.setIsNeedDialog(this.a.t());
    }

    @Override // com.baidu.tieba.om8
    public void a(nm8<T> nm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nm8Var) == null) {
            c(nm8Var, true);
        }
    }

    public final void c(nm8<T> nm8Var, boolean z) {
        HttpResponsedMessage httpResponsedMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, nm8Var, z) == null) {
            TbHttpMessageTask tbHttpMessageTask = this.c;
            tbHttpMessageTask.setUrl(this.a.f() + this.a.o());
            if (this.a.n() == 2) {
                this.c.setResponsedClass(JsonResponsedMessage.class);
            } else {
                this.c.setResponsedClass(ProtoResponseMessage.class);
            }
            this.c.setTimeOut(z6.d().b());
            this.c.setRetry(z6.d().a());
            this.c.setConnectTimeOut(z6.d().c());
            for (Map.Entry<String, Object> entry : this.a.k().entrySet()) {
                Object value = entry.getValue();
                this.b.addParam(entry.getKey(), value);
            }
            for (Map.Entry<String, String> entry2 : this.a.e().entrySet()) {
                this.b.addHeader(entry2.getKey(), entry2.getValue());
            }
            if (this.a.n() == 1) {
                this.b.addHeader(NetMessage.HTTP_HEADER_KEY, "protobuf");
            } else {
                this.b.removeHeader(NetMessage.HTTP_HEADER_KEY);
            }
            if (this.a.m() == 1) {
                this.c.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            } else {
                this.c.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            }
            this.b.setClientLogID(e);
            tm8<T> tm8Var = new tm8<>(this.b, this.c, this, nm8Var);
            this.d = tm8Var;
            if (z) {
                if (tm8Var != null) {
                    tm8Var.execute(new HttpMessage[0]);
                }
            } else if (tm8Var != null) {
                ResponsedMessage<?>[] responsedMessageArr = new ResponsedMessage[1];
                if (tm8Var != null) {
                    httpResponsedMessage = tm8Var.doInBackground(new HttpMessage[0]);
                } else {
                    httpResponsedMessage = null;
                }
                responsedMessageArr[0] = httpResponsedMessage;
                tm8Var.onProgressUpdate(responsedMessageArr);
            }
        }
    }
}
