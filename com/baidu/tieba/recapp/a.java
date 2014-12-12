package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.x;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a bKP;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> bKQ = new HashMap<>();

    public static final a abI() {
        if (bKP != null) {
            return bKP;
        }
        synchronized (a.class) {
            if (bKP == null) {
                bKP = new a();
            }
        }
        return bKP;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.bKQ.containsKey(Integer.valueOf(i))) {
            this.bKQ.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder k(Context context, int i) {
        View inflate;
        if (context == null || !this.bKQ.containsKey(Integer.valueOf(i))) {
            return null;
        }
        switch (i) {
            case 1:
                inflate = b.ek().inflate(context, x.pb_item_app, null);
                break;
            case 2:
                inflate = b.ek().inflate(context, x.pb_item_app_new, null);
                break;
            default:
                inflate = null;
                break;
        }
        try {
            return this.bKQ.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
