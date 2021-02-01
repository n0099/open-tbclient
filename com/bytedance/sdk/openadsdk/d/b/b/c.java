package com.bytedance.sdk.openadsdk.d.b.b;

import com.bytedance.sdk.openadsdk.d.m;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private static Class f6930a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f6931b = b();
    private final Field c = c();

    @Override // com.bytedance.sdk.openadsdk.d.b.b.b
    public void a(AccessibleObject accessibleObject) {
        if (!b(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
                throw new m("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
            }
        }
    }

    boolean b(AccessibleObject accessibleObject) {
        if (this.f6931b != null && this.c != null) {
            try {
                f6930a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f6931b, accessibleObject, Long.valueOf(((Long) f6930a.getMethod("objectFieldOffset", Field.class).invoke(this.f6931b, this.c)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object b() {
        try {
            f6930a = Class.forName("sun.misc.Unsafe");
            Field declaredField = f6930a.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
