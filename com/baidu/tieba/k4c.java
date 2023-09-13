package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class k4c {
    public static /* synthetic */ Interceptable $ic;
    public static k4c b;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, j4c> a;

    public k4c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
    }

    public static k4c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (k4c.class) {
                    if (b == null) {
                        b = new k4c();
                    }
                }
            }
            return b;
        }
        return (k4c) invokeV.objValue;
    }

    public void a(String str, j4c j4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, j4cVar) == null) {
            TLog.h("[VodPlayerManager]", "bindUniqueKeyForPlayer key:" + str + "-vodPlayer:" + j4cVar);
            if (!TextUtils.isEmpty(str) && j4cVar != null) {
                if (this.a.containsKey(str) && this.a.get(str) != null) {
                    TLog.h("[VodPlayerManager]", "bindUniqueKeyForPlayer contain key and player");
                    return;
                }
                if (this.a.containsValue(j4cVar)) {
                    Iterator<Map.Entry<String, j4c>> it = this.a.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, j4c> next = it.next();
                        if (j4cVar == next.getValue()) {
                            this.a.remove(next.getKey());
                            break;
                        }
                    }
                }
                this.a.put(str, j4cVar);
                TLog.h("[VodPlayerManager]", "player bind suc, tastId:" + j4cVar.d());
                return;
            }
            TLog.h("[VodPlayerManager]", "player or key is null");
        }
    }

    public j4c c(String str, boolean z) {
        InterceptResult invokeLZ;
        c4c f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            TLog.h("[VodPlayerManager]", "obtainPlayer key:" + str);
            if (!TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                j4c j4cVar = this.a.get(str);
                TLog.h("[VodPlayerManager]", "TaskID:" + j4cVar.d() + "-obtainPlayer vodPlayer:" + j4cVar);
                if (z && (f = j4cVar.f()) != null) {
                    f.onPlayerStateUpdate(j4cVar, 10, 0);
                }
                return j4cVar;
            }
            TLog.h("[VodPlayerManager]", "player is null");
            return null;
        }
        return (j4c) invokeLZ.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            e(str, "");
        }
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            TLog.h("[VodPlayerManager]", "removePlayerUniqueKey key:" + str + ", source:" + str2);
            if (!TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                this.a.remove(str);
            }
        }
    }
}
