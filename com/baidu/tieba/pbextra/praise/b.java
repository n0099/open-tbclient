package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    private View bGA;
    private HeadImageView gtn;
    private TextView gto;
    private TextView gtp;
    private ImageView gtq;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bGA = null;
        this.gtn = null;
        this.gto = null;
        this.gtp = null;
        this.gtq = null;
        this.bGA = LayoutInflater.from(context).inflate(e.h.zan_list_item, (ViewGroup) null);
        this.gtn = (HeadImageView) this.bGA.findViewById(e.g.zan_list_item_head);
        this.gto = (TextView) this.bGA.findViewById(e.g.zan_list_item_name);
        this.gtp = (TextView) this.bGA.findViewById(e.g.zan_list_item_time);
        this.gtq = (ImageView) this.bGA.findViewById(e.g.zan_list_item_line_bottom);
        this.gtq.setVisibility(0);
        this.bGA.setTag(this);
    }

    public View getView() {
        return this.bGA;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.gto.setText(str);
        this.gtn.setImageDrawable(null);
        this.gtp.setText(ao.M(j));
        this.gtn.startLoad(str2, 28, false);
    }
}
