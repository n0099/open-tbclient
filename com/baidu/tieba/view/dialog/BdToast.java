package com.baidu.tieba.view.dialog;

import com.slidingmenu.lib.R;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> a = new HashMap<>(2);

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE
    }

    static {
        a.put(DefaultIcon.SUCCESS, Integer.valueOf((int) R.drawable.icon_unite_pass));
        a.put(DefaultIcon.FAILURE, Integer.valueOf((int) R.drawable.icon_unite_lose));
    }
}
