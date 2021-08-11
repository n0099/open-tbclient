package com.baidu.wallet.base.widget.listview;

import android.app.Activity;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class ViewMappingUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewMappingUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Object obj, View view, Class<?> cls) {
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, obj, view, cls) == null) {
            for (Field field : cls.getDeclaredFields()) {
                bind bindVar = (bind) field.getAnnotation(bind.class);
                if (bindVar != null) {
                    try {
                        field.setAccessible(true);
                        field.set(obj, view.findViewById(ResUtils.id(view.getContext(), bindVar.value())));
                    } catch (Exception unused) {
                        throw new RuntimeException(bindVar.value() + " map error!\nfield:" + field.getName());
                    }
                }
            }
        }
    }

    public static void mapView(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, activity) == null) {
            mapView(activity, activity.getWindow().getDecorView());
        }
    }

    public static void mapView(Object obj, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, obj, view) == null) {
            a(obj, view, obj.getClass());
        }
    }
}
