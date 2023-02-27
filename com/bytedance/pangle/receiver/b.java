package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class b {
    public static final c a;

    /* loaded from: classes7.dex */
    public interface c {
        boolean a(Context context);
    }

    /* loaded from: classes7.dex */
    public static class a implements c {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static Object b(Context context) {
            Field field;
            Object readField;
            try {
                Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 != null && (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) != null && (readField = FieldUtils.readField(field, context)) != null) {
                    return FieldUtils.readField(field2, readField);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public static Object a(Context context, String str) {
            return a(b(context), str);
        }

        public static Object a(Object obj, String str) {
            if (obj != null) {
                try {
                    return FieldUtils.readField(obj, str);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object b = b(context);
            Object a = a(b, "mWhiteList");
            if (a instanceof String[]) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(context.getPackageName());
                Collections.addAll(arrayList, (String[]) a);
                FieldUtils.writeField(b, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
                return true;
            } else if (b != null) {
                FieldUtils.writeField(b, "mResourceConfig", (Object) null);
                return false;
            } else {
                return false;
            }
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0514b extends e {
        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            return false;
        }

        public C0514b() {
            super((byte) 0);
        }

        public /* synthetic */ C0514b(byte b) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends a {
        public d() {
            super((byte) 0);
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            Object a = a.a(context, "mWhiteList");
            if (a instanceof List) {
                ((List) a).add(context.getPackageName());
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends a {
        public e() {
            super((byte) 0);
        }

        public /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object a = a.a(context, "mWhiteListMap");
            if (!(a instanceof Map)) {
                return false;
            }
            Map map = (Map) a;
            List list = (List) map.get(0);
            if (list == null) {
                list = new ArrayList();
                map.put(0, list);
            }
            list.add(context.getPackageName());
            return true;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            a = new a((byte) 0);
        } else if (i < 26) {
            a = new d((byte) 0);
        } else if (i < 28) {
            a = new e((byte) 0);
        } else {
            a = new C0514b((byte) 0);
        }
    }

    public static void a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), RomUtils.MANUFACTURER_HUAWEI)) {
                    a.a(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }
}
