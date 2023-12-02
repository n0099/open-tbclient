package com.baidu.tieba;

import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.http.message.JsonResponsedMessage;
import com.baidu.tieba.http.message.ProtoResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class xm8<T> extends HttpClient.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ym8<T> e;
    public final rm8<T> f;
    public T g;

    /* loaded from: classes9.dex */
    public static final class a extends vm8<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(T t) {
            super(t);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xm8(HttpMessage msg, HttpMessageTask task, ym8<T> request, rm8<T> rm8Var) {
        super(msg, task);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msg, task, request, rm8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((HttpMessage) objArr2[0], (HttpMessageTask) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(request, "request");
        this.e = request;
        this.f = rm8Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.client.HttpClient.a, com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public HttpResponsedMessage doInBackground(HttpMessage... params) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            return super.doInBackground((HttpMessage[]) Arrays.copyOf(params, params.length));
        }
        return (HttpResponsedMessage) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.client.HttpClient.a, com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onProgressUpdate(ResponsedMessage<?>... values) {
        boolean z;
        String str;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, values) == null) {
            Intrinsics.checkNotNullParameter(values, "values");
            boolean z2 = true;
            if (values.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if ((!z) && values[0] != null) {
                ResponsedMessage<?> responsedMessage = values[0];
                if (((responsedMessage == null || responsedMessage.getError() != 0) ? false : false) && (t = this.g) != null) {
                    rm8<T> rm8Var = this.f;
                    if (rm8Var != null) {
                        rm8Var.b(this.e, new a(t));
                        return;
                    }
                    return;
                }
                rm8<T> rm8Var2 = this.f;
                if (rm8Var2 != null) {
                    ym8<T> ym8Var = this.e;
                    ResponsedMessage<?> responsedMessage2 = values[0];
                    if (responsedMessage2 != null) {
                        str = responsedMessage2.getErrorString();
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "unknown error";
                    }
                    rm8Var2.a(ym8Var, new Throwable(str));
                    return;
                }
                return;
            }
            rm8<T> rm8Var3 = this.f;
            if (rm8Var3 != null) {
                rm8Var3.a(this.e, new Throwable("no response error"));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void publishProgress(ResponsedMessage<?>... values) {
        boolean z;
        ProtoResponseMessage protoResponseMessage;
        byte[] bArr;
        String str;
        JsonResponsedMessage jsonResponsedMessage;
        JsonResponsedMessage jsonResponsedMessage2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, values) == null) {
            Intrinsics.checkNotNullParameter(values, "values");
            if (values.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if ((!z) && values[0] != null) {
                ResponsedMessage<?> responsedMessage = values[0];
                T t = null;
                if (this.e.b().n() == 2) {
                    boolean z2 = responsedMessage instanceof JsonResponsedMessage;
                    if (z2) {
                        jsonResponsedMessage = (JsonResponsedMessage) responsedMessage;
                    } else {
                        jsonResponsedMessage = null;
                    }
                    if (jsonResponsedMessage != null) {
                        bArr = jsonResponsedMessage.getData();
                    } else {
                        bArr = null;
                    }
                    if (z2) {
                        jsonResponsedMessage2 = (JsonResponsedMessage) responsedMessage;
                    } else {
                        jsonResponsedMessage2 = null;
                    }
                    if (jsonResponsedMessage2 != null) {
                        str = jsonResponsedMessage2.getCharset();
                    } else {
                        str = null;
                    }
                } else {
                    if (responsedMessage instanceof ProtoResponseMessage) {
                        protoResponseMessage = (ProtoResponseMessage) responsedMessage;
                    } else {
                        protoResponseMessage = null;
                    }
                    if (protoResponseMessage != null) {
                        bArr = protoResponseMessage.getData();
                    } else {
                        bArr = null;
                    }
                    str = "uft-8";
                }
                wm8<T> d = this.e.b().d();
                if (d != null) {
                    t = d.a(bArr, str);
                }
                this.g = t;
            }
            super.publishProgress(Arrays.copyOf(values, values.length));
        }
    }
}
