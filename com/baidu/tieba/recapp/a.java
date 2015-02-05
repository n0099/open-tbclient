package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.x;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a bMz;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> bMA = new HashMap<>();

    public static final a ach() {
        if (bMz != null) {
            return bMz;
        }
        synchronized (a.class) {
            if (bMz == null) {
                bMz = new a();
            }
        }
        return bMz;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.bMA.containsKey(Integer.valueOf(i))) {
            this.bMA.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder j(Context context, int i) {
        View inflate;
        if (context == null || !this.bMA.containsKey(Integer.valueOf(i))) {
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
            return this.bMA.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
