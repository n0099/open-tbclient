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
    private View bxX;
    private HeadImageView fZD;
    private TextView fZE;
    private TextView fZF;
    private ImageView fZG;

    public static b c(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bxX = null;
        this.fZD = null;
        this.fZE = null;
        this.fZF = null;
        this.fZG = null;
        this.bxX = LayoutInflater.from(context).inflate(e.h.zan_list_item, (ViewGroup) null);
        this.fZD = (HeadImageView) this.bxX.findViewById(e.g.zan_list_item_head);
        this.fZE = (TextView) this.bxX.findViewById(e.g.zan_list_item_name);
        this.fZF = (TextView) this.bxX.findViewById(e.g.zan_list_item_time);
        this.fZG = (ImageView) this.bxX.findViewById(e.g.zan_list_item_line_bottom);
        this.fZG.setVisibility(0);
        this.bxX.setTag(this);
    }

    public View getView() {
        return this.bxX;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.fZE.setText(str);
        this.fZD.setImageDrawable(null);
        this.fZF.setText(ao.A(j));
        this.fZD.startLoad(str2, 28, false);
    }
}
