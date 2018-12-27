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
    private View bFN;
    private HeadImageView gsj;
    private TextView gsk;
    private TextView gsl;
    private ImageView gsm;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bFN = null;
        this.gsj = null;
        this.gsk = null;
        this.gsl = null;
        this.gsm = null;
        this.bFN = LayoutInflater.from(context).inflate(e.h.zan_list_item, (ViewGroup) null);
        this.gsj = (HeadImageView) this.bFN.findViewById(e.g.zan_list_item_head);
        this.gsk = (TextView) this.bFN.findViewById(e.g.zan_list_item_name);
        this.gsl = (TextView) this.bFN.findViewById(e.g.zan_list_item_time);
        this.gsm = (ImageView) this.bFN.findViewById(e.g.zan_list_item_line_bottom);
        this.gsm.setVisibility(0);
        this.bFN.setTag(this);
    }

    public View getView() {
        return this.bFN;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.gsk.setText(str);
        this.gsj.setImageDrawable(null);
        this.gsl.setText(ao.M(j));
        this.gsj.startLoad(str2, 28, false);
    }
}
