package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class ng2 extends gg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String c;
    public final String d;

    public ng2(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = str;
        this.d = str2;
        this.a = "firstMeaningfulPainted";
    }

    @Override // com.baidu.tieba.gg2
    public void m(Map<String, Object> map) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            String str2 = "";
            if (TextUtils.isEmpty(this.c)) {
                str = "";
            } else {
                str = this.c;
            }
            map.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
            if (!TextUtils.isEmpty(this.d)) {
                str2 = this.d;
            }
            map.put(PrefetchEvent.EVENT_KEY_PAGE_URL, str2);
        }
    }
}
