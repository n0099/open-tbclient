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
    private View bBF;
    private HeadImageView ghf;
    private TextView ghg;
    private TextView ghh;
    private ImageView ghi;

    public static b c(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bBF = null;
        this.ghf = null;
        this.ghg = null;
        this.ghh = null;
        this.ghi = null;
        this.bBF = LayoutInflater.from(context).inflate(e.h.zan_list_item, (ViewGroup) null);
        this.ghf = (HeadImageView) this.bBF.findViewById(e.g.zan_list_item_head);
        this.ghg = (TextView) this.bBF.findViewById(e.g.zan_list_item_name);
        this.ghh = (TextView) this.bBF.findViewById(e.g.zan_list_item_time);
        this.ghi = (ImageView) this.bBF.findViewById(e.g.zan_list_item_line_bottom);
        this.ghi.setVisibility(0);
        this.bBF.setTag(this);
    }

    public View getView() {
        return this.bBF;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ghg.setText(str);
        this.ghf.setImageDrawable(null);
        this.ghh.setText(ao.C(j));
        this.ghf.startLoad(str2, 28, false);
    }
}
