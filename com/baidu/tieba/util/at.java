package com.baidu.tieba.util;

import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class at {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f2588a = new int[UtilHelper.NetworkStateInfo.values().length];

    static {
        try {
            f2588a[UtilHelper.NetworkStateInfo.WIFI.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2588a[UtilHelper.NetworkStateInfo.TwoG.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2588a[UtilHelper.NetworkStateInfo.ThreeG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
