package com.baidu.wallet.base.widget.listview.internal;
/* loaded from: classes5.dex */
public class BindLayoutMapping {
    public static String getLayoutId(Class<?> cls) {
        BindLayout bindLayout = (BindLayout) cls.getAnnotation(BindLayout.class);
        return bindLayout != null ? bindLayout.value() : "";
    }
}
