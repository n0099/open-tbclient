package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class o86 extends pb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h86 a;
    public SparseArray b;
    public HashMap c;
    public Gson d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o86(int i) {
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
        this.d = new Gson();
        a();
    }

    public final void a() {
        int e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new SparseArray();
            ArrayList findHttpTasks = MessageManager.getInstance().findHttpTasks();
            if (ListUtils.isEmpty(findHttpTasks)) {
                return;
            }
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = ((HttpMessageTask) findHttpTasks.get(i)).getUrl();
                if (!ej.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ej.isEmpty(str) && str.contains("=") && (e = eh.e(str.split("[=]")[1], 0)) != 0) {
                        this.b.put(e, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void b(h86 h86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h86Var) == null) {
            this.a = h86Var;
        }
    }

    public void c(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            this.c = hashMap;
        }
    }

    @Override // com.baidu.tieba.kb
    public /* bridge */ /* synthetic */ Message process(Message message, MessageTask messageTask) {
        SocketMessage socketMessage = (SocketMessage) message;
        process(socketMessage, (SocketMessageTask) messageTask);
        return socketMessage;
    }

    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, socketMessage, socketMessageTask)) == null) {
            String str = (String) this.b.get(socketMessage.getCmd());
            if (str == null) {
                return socketMessage;
            }
            HashMap hashMap = this.c;
            if (hashMap != null && hashMap.get(str) != null && this.a != null) {
                this.a.a(str, this.d.toJson(this.c.get(str)), this.d.toJson(this.d.toJson(socketMessage.getData())));
            }
            return socketMessage;
        }
        return (SocketMessage) invokeLL.objValue;
    }
}
