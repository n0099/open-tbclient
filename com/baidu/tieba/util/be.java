package com.baidu.tieba.util;

import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class be {
    static final /* synthetic */ int[] a = new int[UtilHelper.NetworkStateInfo.values().length];

    static {
        try {
            a[UtilHelper.NetworkStateInfo.WIFI.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[UtilHelper.NetworkStateInfo.TwoG.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[UtilHelper.NetworkStateInfo.ThreeG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
