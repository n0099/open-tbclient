package com.baidu.vi;

import android.net.NetworkInfo;
/* loaded from: classes26.dex */
/* synthetic */ class i {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f3912a = new int[NetworkInfo.State.values().length];

    static {
        try {
            f3912a[NetworkInfo.State.CONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3912a[NetworkInfo.State.CONNECTING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3912a[NetworkInfo.State.DISCONNECTED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3912a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f3912a[NetworkInfo.State.SUSPENDED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
