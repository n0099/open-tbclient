package com.baidu.tieba;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ja6 extends ib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public da6 a;
    public HashMap<String, String> b;
    public Gson c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ja6(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new Gson();
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str.contains("?")) {
                str = str.split("[?]")[0];
            }
            String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
            HashMap<String, String> hashMap = this.b;
            if (hashMap != null) {
                return hashMap.get(replace);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void b(da6 da6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, da6Var) == null) {
            this.a = da6Var;
        }
    }

    public void c(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            this.b = hashMap;
        }
    }

    /* renamed from: process  reason: avoid collision after fix types in other method */
    public HttpMessage process2(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        String json;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, httpMessage, httpMessageTask)) == null) {
            String a = a(httpMessageTask.getUrl());
            if (a != null && this.a != null) {
                if (httpMessage.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                    if (netMessage.getSocketMessage() != null) {
                        json = this.c.toJson(netMessage.getSocketMessage().getData());
                    } else {
                        json = "";
                    }
                } else {
                    json = this.c.toJson(httpMessage.getParams());
                }
                this.a.a(httpMessageTask.getUrl(), this.c.toJson(a), this.c.toJson(json));
            }
            return httpMessage;
        }
        return (HttpMessage) invokeLL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // com.baidu.tieba.kb
    public /* bridge */ /* synthetic */ HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        process2(httpMessage2, httpMessageTask);
        return httpMessage2;
    }
}
