package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a cIW;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> cIX = new HashMap<>();

    public static final a aqc() {
        if (cIW != null) {
            return cIW;
        }
        synchronized (a.class) {
            if (cIW == null) {
                cIW = new a();
            }
        }
        return cIW;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.cIX.containsKey(Integer.valueOf(i))) {
            this.cIX.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder l(Context context, int i) {
        View inflate;
        if (context == null || !this.cIX.containsKey(Integer.valueOf(i))) {
            return null;
        }
        switch (i) {
            case 1:
                inflate = LayoutInflater.from(context).inflate(i.g.pb_item_app, (ViewGroup) null);
                break;
            case 2:
                inflate = LayoutInflater.from(context).inflate(i.g.pb_item_app_new, (ViewGroup) null);
                break;
            case 3:
                inflate = LayoutInflater.from(context).inflate(i.g.pb_item_app_multi_pic, (ViewGroup) null);
                break;
            default:
                inflate = null;
                break;
        }
        try {
            return this.cIX.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
