package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.brotli.DecoderJNI;
/* loaded from: classes5.dex */
public final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f26910a;

    static {
        int[] iArr = new int[DecoderJNI.a.values().length];
        f26910a = iArr;
        try {
            iArr[DecoderJNI.a.DONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f26910a[DecoderJNI.a.OK.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f26910a[DecoderJNI.a.NEEDS_MORE_INPUT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f26910a[DecoderJNI.a.NEEDS_MORE_OUTPUT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
