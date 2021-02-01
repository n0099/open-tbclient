package com.bumptech.glide.util.pool;

import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes15.dex */
public final class GlideTrace {
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    private GlideTrace() {
    }

    private static String truncateTag(String str) {
        if (str.length() > 127) {
            return str.substring(0, Opcodes.IAND);
        }
        return str;
    }

    public static void beginSection(String str) {
    }

    public static void beginSectionFormat(String str, Object obj) {
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2) {
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2, Object obj3) {
    }

    public static void endSection() {
    }
}
