package com.baidu.wallet.base.widget.listview;

import android.app.Activity;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class ViewMappingUtil {
    public static void a(Object obj, View view, Class<?> cls) {
        Field[] declaredFields;
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

    public static void mapView(Activity activity) {
        mapView(activity, activity.getWindow().getDecorView());
    }

    public static void mapView(Object obj, View view) {
        a(obj, view, obj.getClass());
    }
}
