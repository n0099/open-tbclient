package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.x;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a bMA;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> bMB = new HashMap<>();

    public static final a acm() {
        if (bMA != null) {
            return bMA;
        }
        synchronized (a.class) {
            if (bMA == null) {
                bMA = new a();
            }
        }
        return bMA;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.bMB.containsKey(Integer.valueOf(i))) {
            this.bMB.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder j(Context context, int i) {
        View inflate;
        if (context == null || !this.bMB.containsKey(Integer.valueOf(i))) {
            return null;
        }
        switch (i) {
            case 1:
                inflate = b.ei().inflate(context, x.pb_item_app, null);
                break;
            case 2:
                inflate = b.ei().inflate(context, x.pb_item_app_new, null);
                break;
            default:
                inflate = null;
                break;
        }
        try {
            return this.bMB.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
