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
    private static a dWY;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> dWZ = new HashMap<>();

    public static final a aLD() {
        if (dWY != null) {
            return dWY;
        }
        synchronized (a.class) {
            if (dWY == null) {
                dWY = new a();
            }
        }
        return dWY;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.dWZ.containsKey(Integer.valueOf(i))) {
            this.dWZ.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder m(Context context, int i) {
        View inflate;
        if (context == null || !this.dWZ.containsKey(Integer.valueOf(i))) {
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
            return this.dWZ.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            BdLog.e(e.toString());
            return null;
        }
    }
}
