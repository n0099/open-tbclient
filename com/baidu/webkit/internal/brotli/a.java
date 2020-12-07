package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.brotli.DecoderJNI;
/* loaded from: classes12.dex */
final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f3937a = new int[DecoderJNI.a.values().length];

    static {
        try {
            f3937a[DecoderJNI.a.DONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3937a[DecoderJNI.a.OK.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3937a[DecoderJNI.a.NEEDS_MORE_INPUT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3937a[DecoderJNI.a.NEEDS_MORE_OUTPUT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
