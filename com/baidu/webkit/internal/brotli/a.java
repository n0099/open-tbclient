package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.brotli.DecoderJNI;
/* loaded from: classes14.dex */
final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f5663a = new int[DecoderJNI.a.values().length];

    static {
        try {
            f5663a[DecoderJNI.a.DONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5663a[DecoderJNI.a.OK.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5663a[DecoderJNI.a.NEEDS_MORE_INPUT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5663a[DecoderJNI.a.NEEDS_MORE_OUTPUT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
