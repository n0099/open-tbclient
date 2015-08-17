package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a crS;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> crT = new HashMap<>();

    public static final a aje() {
        if (crS != null) {
            return crS;
        }
        synchronized (a.class) {
            if (crS == null) {
                crS = new a();
            }
        }
        return crS;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.crT.containsKey(Integer.valueOf(i))) {
            this.crT.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder l(Context context, int i) {
        View inflate;
        if (context == null || !this.crT.containsKey(Integer.valueOf(i))) {
            return null;
        }
        switch (i) {
            case 1:
                inflate = LayoutInflater.from(context).inflate(i.g.pb_item_app, (ViewGroup) null);
                break;
            case 2:
                inflate = LayoutInflater.from(context).inflate(i.g.pb_item_app_new, (ViewGroup) null);
                break;
            default:
                inflate = null;
                break;
        }
        try {
            return this.crT.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
