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
    private View bXJ;
    private HeadImageView ggY;
    private TextView ggZ;
    private TextView gha;
    private ImageView ghb;

    public static b c(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bXJ = null;
        this.ggY = null;
        this.ggZ = null;
        this.gha = null;
        this.ghb = null;
        this.bXJ = LayoutInflater.from(context).inflate(d.h.zan_list_item, (ViewGroup) null);
        this.ggY = (HeadImageView) this.bXJ.findViewById(d.g.zan_list_item_head);
        this.ggZ = (TextView) this.bXJ.findViewById(d.g.zan_list_item_name);
        this.gha = (TextView) this.bXJ.findViewById(d.g.zan_list_item_time);
        this.ghb = (ImageView) this.bXJ.findViewById(d.g.zan_list_item_line_bottom);
        this.ghb.setVisibility(0);
        this.bXJ.setTag(this);
    }

    public View getView() {
        return this.bXJ;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ggZ.setText(str);
        this.ggY.setImageDrawable(null);
        this.gha.setText(am.z(j));
        this.ggY.startLoad(str2, 28, false);
    }
}
