package com.bumptech.glide.util.pool;
/* loaded from: classes5.dex */
public final class GlideTrace {
    public static final int MAX_LENGTH = 127;
    public static final boolean TRACING_ENABLED = false;

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

    public static String truncateTag(String str) {
        return str.length() > 127 ? str.substring(0, 126) : str;
    }
}
