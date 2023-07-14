package com.baidu.tieba;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public class xl2 extends wl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ContentValues d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xl2(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentValues};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Map) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = contentValues;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xl2(@Nullable Map<String, String> map) {
        super("lifecycle", map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Map) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.wl2, com.baidu.tieba.vl2
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put("cuid", cv2.h0().i(cv2.c()));
            map.put("mtjCuid", cv2.h0().i(cv2.c()));
            ContentValues contentValues = this.d;
            if (contentValues != null) {
                for (String str : contentValues.keySet()) {
                    Object obj = this.d.get(str);
                    if (!(obj instanceof Number) && !(obj instanceof Boolean)) {
                        map.put(str, String.valueOf(obj));
                    } else {
                        map.put(str, obj);
                    }
                }
                return;
            }
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
