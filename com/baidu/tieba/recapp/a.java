package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.r;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a cba;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> cbb = new HashMap<>();

    public static final a ahh() {
        if (cba != null) {
            return cba;
        }
        synchronized (a.class) {
            if (cba == null) {
                cba = new a();
            }
        }
        return cba;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.cbb.containsKey(Integer.valueOf(i))) {
            this.cbb.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder k(Context context, int i) {
        View inflate;
        if (context == null || !this.cbb.containsKey(Integer.valueOf(i))) {
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
            return this.cbb.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
