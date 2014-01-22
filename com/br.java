package com;

import com.baidu.cloudsdk.social.core.MediaType;
/* loaded from: classes.dex */
/* synthetic */ class br {
    static final /* synthetic */ int[] a = new int[MediaType.values().length];

    static {
        try {
            a[MediaType.SINAWEIBO.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[MediaType.QZONE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
