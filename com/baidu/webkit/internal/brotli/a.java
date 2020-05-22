package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.brotli.DecoderJNI;
/* loaded from: classes11.dex */
final /* synthetic */ class a {
    static final /* synthetic */ int[] a = new int[DecoderJNI.a.values().length];

    static {
        try {
            a[DecoderJNI.a.DONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[DecoderJNI.a.OK.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[DecoderJNI.a.NEEDS_MORE_INPUT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[DecoderJNI.a.NEEDS_MORE_OUTPUT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
