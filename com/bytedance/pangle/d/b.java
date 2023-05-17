package com.bytedance.pangle.d;

import com.bytedance.pangle.util.MethodUtils;
/* loaded from: classes8.dex */
public final class b {

    /* loaded from: classes8.dex */
    public static class a {
        public static int a = 0;
        public static int b = 1;
        public static int c = 3;
    }

    public static String a() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
