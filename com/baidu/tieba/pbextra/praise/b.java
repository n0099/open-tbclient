package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private View bse;
    private HeadImageView fSv;
    private TextView fSw;
    private TextView fSx;
    private ImageView fSy;

    public static b c(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bse = null;
        this.fSv = null;
        this.fSw = null;
        this.fSx = null;
        this.fSy = null;
        this.bse = LayoutInflater.from(context).inflate(d.h.zan_list_item, (ViewGroup) null);
        this.fSv = (HeadImageView) this.bse.findViewById(d.g.zan_list_item_head);
        this.fSw = (TextView) this.bse.findViewById(d.g.zan_list_item_name);
        this.fSx = (TextView) this.bse.findViewById(d.g.zan_list_item_time);
        this.fSy = (ImageView) this.bse.findViewById(d.g.zan_list_item_line_bottom);
        this.fSy.setVisibility(0);
        this.bse.setTag(this);
    }

    public View getView() {
        return this.bse;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.fSw.setText(str);
        this.fSv.setImageDrawable(null);
        this.fSx.setText(ap.w(j));
        this.fSv.startLoad(str2, 28, false);
    }
}
