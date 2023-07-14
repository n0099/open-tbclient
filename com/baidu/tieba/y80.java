package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class y80 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;
    public final Map<String, String> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948283896, "Lcom/baidu/tieba/y80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948283896, "Lcom/baidu/tieba/y80;");
                return;
            }
        }
        c = AppConfig.isDebug();
    }

    public y80() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new Handler(Looper.getMainLooper());
        HashMap hashMap = new HashMap(2);
        this.a = hashMap;
        hashMap.put("click_searchbox", WarmTipsManager.WIDGET_HISSUG_EXT_VALUE);
        this.a.put("click_feed_video", "video");
        HashMap hashMap2 = new HashMap(2);
        this.b = hashMap2;
        hashMap2.put("click_searchbox", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
        this.b.put("click_feed_video", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
        new HashMap(2);
    }
}
