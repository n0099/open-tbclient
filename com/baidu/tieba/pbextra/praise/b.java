package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private View bpW;
    private HeadImageView fOh;
    private TextView fOi;
    private TextView fOj;
    private ImageView fOk;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bpW = null;
        this.fOh = null;
        this.fOi = null;
        this.fOj = null;
        this.fOk = null;
        this.bpW = LayoutInflater.from(context).inflate(d.i.zan_list_item, (ViewGroup) null);
        this.fOh = (HeadImageView) this.bpW.findViewById(d.g.zan_list_item_head);
        this.fOi = (TextView) this.bpW.findViewById(d.g.zan_list_item_name);
        this.fOj = (TextView) this.bpW.findViewById(d.g.zan_list_item_time);
        this.fOk = (ImageView) this.bpW.findViewById(d.g.zan_list_item_line_bottom);
        this.fOk.setVisibility(0);
        this.bpW.setTag(this);
    }

    public View getView() {
        return this.bpW;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.fOi.setText(str);
        this.fOh.setImageDrawable(null);
        this.fOj.setText(ao.v(j));
        this.fOh.startLoad(str2, 28, false);
    }
}
