package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.r;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a cbb;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> cbc = new HashMap<>();

    public static final a ahi() {
        if (cbb != null) {
            return cbb;
        }
        synchronized (a.class) {
            if (cbb == null) {
                cbb = new a();
            }
        }
        return cbb;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.cbc.containsKey(Integer.valueOf(i))) {
            this.cbc.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder k(Context context, int i) {
        View inflate;
        if (context == null || !this.cbc.containsKey(Integer.valueOf(i))) {
            return null;
        }
        switch (i) {
            case 1:
                inflate = b.hr().inflate(context, r.pb_item_app, null);
                break;
            case 2:
                inflate = b.hr().inflate(context, r.pb_item_app_new, null);
                break;
            default:
                inflate = null;
                break;
        }
        try {
            return this.cbc.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
