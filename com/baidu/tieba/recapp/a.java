package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.w;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a bXh;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> bXi = new HashMap<>();

    public static final a afo() {
        if (bXh != null) {
            return bXh;
        }
        synchronized (a.class) {
            if (bXh == null) {
                bXh = new a();
            }
        }
        return bXh;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.bXi.containsKey(Integer.valueOf(i))) {
            this.bXi.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder k(Context context, int i) {
        View inflate;
        if (context == null || !this.bXi.containsKey(Integer.valueOf(i))) {
            return null;
        }
        switch (i) {
            case 1:
                inflate = b.hH().inflate(context, w.pb_item_app, null);
                break;
            case 2:
                inflate = b.hH().inflate(context, w.pb_item_app_new, null);
                break;
            default:
                inflate = null;
                break;
        }
        try {
            return this.bXi.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
