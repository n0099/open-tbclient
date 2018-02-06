package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private View bXV;
    private HeadImageView ghj;
    private TextView ghk;
    private TextView ghl;
    private ImageView ghm;

    public static b c(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bXV = null;
        this.ghj = null;
        this.ghk = null;
        this.ghl = null;
        this.ghm = null;
        this.bXV = LayoutInflater.from(context).inflate(d.h.zan_list_item, (ViewGroup) null);
        this.ghj = (HeadImageView) this.bXV.findViewById(d.g.zan_list_item_head);
        this.ghk = (TextView) this.bXV.findViewById(d.g.zan_list_item_name);
        this.ghl = (TextView) this.bXV.findViewById(d.g.zan_list_item_time);
        this.ghm = (ImageView) this.bXV.findViewById(d.g.zan_list_item_line_bottom);
        this.ghm.setVisibility(0);
        this.bXV.setTag(this);
    }

    public View getView() {
        return this.bXV;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ghk.setText(str);
        this.ghj.setImageDrawable(null);
        this.ghl.setText(am.z(j));
        this.ghj.startLoad(str2, 28, false);
    }
}
