package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.t;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a dUg;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> dUh = new HashMap<>();

    public static final a aLw() {
        if (dUg != null) {
            return dUg;
        }
        synchronized (a.class) {
            if (dUg == null) {
                dUg = new a();
            }
        }
        return dUg;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.dUh.containsKey(Integer.valueOf(i))) {
            this.dUh.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder m(Context context, int i) {
        View inflate;
        if (context == null || !this.dUh.containsKey(Integer.valueOf(i))) {
            return null;
        }
        switch (i) {
            case 1:
                inflate = LayoutInflater.from(context).inflate(t.h.pb_item_app, (ViewGroup) null);
                break;
            case 2:
                inflate = LayoutInflater.from(context).inflate(t.h.pb_item_app_new, (ViewGroup) null);
                break;
            case 3:
                inflate = LayoutInflater.from(context).inflate(t.h.pb_item_app_multi_pic, (ViewGroup) null);
                break;
            default:
                inflate = null;
                break;
        }
        try {
            return this.dUh.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            BdLog.e(e.toString());
            return null;
        }
    }
}
