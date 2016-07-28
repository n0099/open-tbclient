package com.baidu.tieba.recapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.u;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a eTv;
    private HashMap<Integer, Class<? extends PbRecBaseViewHolder>> eTw = new HashMap<>();

    public static final a aXW() {
        if (eTv != null) {
            return eTv;
        }
        synchronized (a.class) {
            if (eTv == null) {
                eTv = new a();
            }
        }
        return eTv;
    }

    public void registerHolder(int i, Class<? extends PbRecBaseViewHolder> cls) {
        if (i >= 0 && cls != null && !this.eTw.containsKey(Integer.valueOf(i))) {
            this.eTw.put(Integer.valueOf(i), cls);
        }
    }

    public PbRecBaseViewHolder n(Context context, int i) {
        View inflate;
        if (context == null || !this.eTw.containsKey(Integer.valueOf(i))) {
            return null;
        }
        switch (i) {
            case 1:
                inflate = LayoutInflater.from(context).inflate(u.h.pb_item_app, (ViewGroup) null);
                break;
            case 2:
                inflate = LayoutInflater.from(context).inflate(u.h.pb_item_app_new, (ViewGroup) null);
                break;
            case 3:
                inflate = LayoutInflater.from(context).inflate(u.h.pb_item_app_multi_pic, (ViewGroup) null);
                break;
            default:
                inflate = null;
                break;
        }
        try {
            return this.eTw.get(Integer.valueOf(i)).getConstructor(View.class).newInstance(inflate);
        } catch (Exception e) {
            BdLog.e(e.toString());
            return null;
        }
    }
}
