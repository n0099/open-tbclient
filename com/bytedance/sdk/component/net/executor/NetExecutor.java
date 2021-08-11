package com.bytedance.sdk.component.net.executor;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.e;
import com.bytedance.sdk.component.b.b.n;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes9.dex */
public abstract class NetExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NetExecutor";
    public transient /* synthetic */ FieldHolder $fh;
    public Object extra;
    public Map<String, Object> extraMap;
    public w okHttpClient;
    public final Map<String, String> requestHeadsMap;
    public String tag;
    public String url;

    public NetExecutor(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tag = null;
        this.requestHeadsMap = new HashMap();
        this.url = null;
        this.okHttpClient = wVar;
        setTag(UUID.randomUUID().toString());
    }

    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.requestHeadsMap.put(str, str2);
        }
    }

    public void cancel() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.tag == null || (wVar = this.okHttpClient) == null) {
            return;
        }
        n s = wVar.s();
        synchronized (s) {
            for (e eVar : s.b()) {
                if (this.tag.equals(eVar.a().e())) {
                    eVar.c();
                }
            }
            for (e eVar2 : s.c()) {
                if (this.tag.equals(eVar2.a().e())) {
                    eVar2.c();
                }
            }
        }
    }

    public abstract void enqueue(NetCallback netCallback);

    public abstract NetResponse execute();

    public Object getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.extra : invokeV.objValue;
    }

    public Map<String, Object> getExtraMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.extraMap : (Map) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.tag : (String) invokeV.objValue;
    }

    public void removeHeader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.requestHeadsMap.remove(str);
        }
    }

    public void setExtra(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
            this.extra = obj;
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
            this.extraMap = map;
        }
    }

    public void setHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, map) == null) || map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.requestHeadsMap.put(entry.getKey(), entry.getValue());
        }
    }

    public void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.tag = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.url = str;
        }
    }

    public void traverseHeadMapToRequestBuilder(z.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null || this.requestHeadsMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : this.requestHeadsMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                aVar.b(key, value);
            }
        }
    }
}
