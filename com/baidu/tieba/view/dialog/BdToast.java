package com.baidu.tieba.view.dialog;

import com.slidingmenu.lib.R;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class BdToast {
    private static HashMap<DefaultIcon, Integer> a;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DefaultIcon[] valuesCustom() {
            DefaultIcon[] valuesCustom = values();
            int length = valuesCustom.length;
            DefaultIcon[] defaultIconArr = new DefaultIcon[length];
            System.arraycopy(valuesCustom, 0, defaultIconArr, 0, length);
            return defaultIconArr;
        }
    }

    static {
        HashMap<DefaultIcon, Integer> hashMap = new HashMap<>(2);
        a = hashMap;
        hashMap.put(DefaultIcon.SUCCESS, Integer.valueOf((int) R.drawable.icon_unite_pass));
        a.put(DefaultIcon.FAILURE, Integer.valueOf((int) R.drawable.icon_unite_lose));
    }
}
