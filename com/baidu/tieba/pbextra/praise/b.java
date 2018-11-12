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
    private View bCr;
    private HeadImageView giC;
    private TextView giD;
    private TextView giE;
    private ImageView giF;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bCr = null;
        this.giC = null;
        this.giD = null;
        this.giE = null;
        this.giF = null;
        this.bCr = LayoutInflater.from(context).inflate(e.h.zan_list_item, (ViewGroup) null);
        this.giC = (HeadImageView) this.bCr.findViewById(e.g.zan_list_item_head);
        this.giD = (TextView) this.bCr.findViewById(e.g.zan_list_item_name);
        this.giE = (TextView) this.bCr.findViewById(e.g.zan_list_item_time);
        this.giF = (ImageView) this.bCr.findViewById(e.g.zan_list_item_line_bottom);
        this.giF.setVisibility(0);
        this.bCr.setTag(this);
    }

    public View getView() {
        return this.bCr;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.giD.setText(str);
        this.giC.setImageDrawable(null);
        this.giE.setText(ao.E(j));
        this.giC.startLoad(str2, 28, false);
    }
}
