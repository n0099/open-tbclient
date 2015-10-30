package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a cHA;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> cHB = new HashMap<>();

    public static final a apw() {
        if (cHA != null) {
            return cHA;
        }
        synchronized (a.class) {
            if (cHA == null) {
                cHA = new a();
            }
        }
        return cHA;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.cHB.containsKey(Integer.valueOf(i))) {
            this.cHB.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder l(Context context, int i) {
        View inflate;
        if (context == null || !this.cHB.containsKey(Integer.valueOf(i))) {
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
            return this.cHB.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
