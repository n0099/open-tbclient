package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.ReflectionUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class lgb implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Object a;

    public lgb(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x02d0, code lost:
        continue;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        Object obj;
        String str;
        Field[] fieldArr;
        Object obj2;
        String str2;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                try {
                    LogPrinter.d("开始获取ripper路径，开始时间：" + System.currentTimeMillis(), new Object[0]);
                    ArrayList arrayList = new ArrayList();
                    new HashMap();
                    Object obj3 = this.a;
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(obj3.getClass().getName());
                    Class<? super Object> superclass = obj3.getClass().getSuperclass();
                    String name = obj3.getClass().getName();
                    Class<? super Object> cls = superclass;
                    while (true) {
                        z = true;
                        if (cls == null || !cls.getName().contains("bytedance")) {
                            break;
                        }
                        for (Field field : cls.getDeclaredFields()) {
                            field.setAccessible(true);
                            String name2 = field.getType().getName();
                            if (!arrayList2.contains(name2)) {
                                try {
                                    Object obj4 = field.get(obj3);
                                    if (obj4 != null) {
                                        arrayList3.add(name + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + obj4.getClass().getName());
                                        arrayList2.add(name2);
                                        arrayList.add(obj4);
                                    }
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        cls = cls.getSuperclass();
                    }
                    int i = 0;
                    while (obj3 != null) {
                        String str3 = "";
                        String str4 = "";
                        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                            str4 = (String) arrayList3.get(i2);
                            if (str4.endsWith(obj3.getClass().getName())) {
                                break;
                            }
                        }
                        Field[] declaredFields2 = obj3.getClass().getDeclaredFields();
                        int length = declaredFields2.length;
                        int i3 = 0;
                        while (i3 < length) {
                            Field field2 = declaredFields2[i3];
                            field2.setAccessible(z);
                            try {
                                String name3 = field2.getType().getName();
                                if (!arrayList2.contains(name3) && name3.contains("bytedance") && (obj2 = field2.get(obj3)) != null) {
                                    if (str4.equals(str3)) {
                                        str2 = name3;
                                    } else {
                                        str2 = str4 + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + name3;
                                    }
                                    arrayList3.add(str2);
                                    arrayList2.add(name3);
                                    arrayList.add(obj2);
                                    Class<? super Object> superclass2 = obj2.getClass().getSuperclass();
                                    String str5 = str2 + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
                                    if (superclass2 != null) {
                                        while (superclass2 != null && superclass2.getName().contains("bytedance")) {
                                            Field[] declaredFields3 = superclass2.getDeclaredFields();
                                            obj = obj3;
                                            try {
                                                int length2 = declaredFields3.length;
                                                str = str3;
                                                int i4 = 0;
                                                while (i4 < length2) {
                                                    int i5 = length2;
                                                    try {
                                                        Field field3 = declaredFields3[i4];
                                                        Field[] fieldArr2 = declaredFields3;
                                                        field3.setAccessible(true);
                                                        String name4 = field3.getType().getName();
                                                        Object obj5 = field3.get(obj2);
                                                        if (obj5 != null && !arrayList2.contains(name4) && name4.contains("bytedance")) {
                                                            fieldArr = declaredFields2;
                                                            try {
                                                                if (name4.contains("java.lang.Object")) {
                                                                    arrayList3.add(str5 + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + name4);
                                                                    arrayList2.add(name4);
                                                                    arrayList.add(obj5);
                                                                }
                                                                i4++;
                                                                length2 = i5;
                                                                declaredFields3 = fieldArr2;
                                                                declaredFields2 = fieldArr;
                                                            } catch (Exception unused) {
                                                            }
                                                        }
                                                        fieldArr = declaredFields2;
                                                        i4++;
                                                        length2 = i5;
                                                        declaredFields3 = fieldArr2;
                                                        declaredFields2 = fieldArr;
                                                    } catch (Exception unused2) {
                                                    }
                                                }
                                                Field[] fieldArr3 = declaredFields2;
                                                superclass2 = superclass2.getSuperclass();
                                                str5 = str5 + "+super+";
                                                obj3 = obj;
                                                str3 = str;
                                                declaredFields2 = fieldArr3;
                                            } catch (Exception unused3) {
                                            }
                                        }
                                    }
                                }
                            } catch (Exception unused4) {
                            }
                            obj = obj3;
                            str = str3;
                            fieldArr = declaredFields2;
                            i3++;
                            obj3 = obj;
                            str3 = str;
                            declaredFields2 = fieldArr;
                            z = true;
                        }
                        if (i >= arrayList.size()) {
                            obj3 = null;
                        } else {
                            obj3 = arrayList.get(i);
                            i++;
                        }
                        z = true;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        boolean z2 = false;
                        for (Class<?> cls2 = next.getClass(); cls2 != null && cls2.getName().contains("bytedance"); cls2 = cls2.getSuperclass()) {
                            ArrayList arrayList4 = new ArrayList();
                            Method[] methods = cls2.getMethods();
                            int length3 = methods.length;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= length3) {
                                    break;
                                }
                                Method method = methods[i6];
                                method.setAccessible(true);
                                if (method.getReturnType() != JSONObject.class && method.getReturnType() != String.class) {
                                    i6++;
                                }
                                arrayList4.add(method.getName());
                                Object invoke = ReflectionUtils.invoke(next, method.getName(), null, new Object[0]);
                                if (invoke != null && !TextUtils.isEmpty(invoke.toString()) && invoke.toString().contains("\"target_url\"")) {
                                    Iterator it2 = arrayList3.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        String str6 = (String) it2.next();
                                        if (str6.endsWith(cls2.getName())) {
                                            String str7 = str6.substring(str6.indexOf(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) + 1) + "+*" + method.getName();
                                            mgb.a = str7;
                                            igb.b.putString("key_ad_ripper_path_config", str7).apply();
                                            break;
                                        }
                                    }
                                    z2 = true;
                                } else {
                                    i6++;
                                }
                            }
                            if (z2) {
                                break;
                            }
                        }
                        continue;
                        if (z2) {
                            break;
                        }
                    }
                    LogPrinter.d("获取ripper路径完成，完成时间：" + System.currentTimeMillis(), new Object[0]);
                } catch (Exception e2) {
                    e = e2;
                    LogPrinter.e(e);
                }
            } catch (Error e3) {
                e = e3;
                LogPrinter.e(e);
            }
        }
    }
}
