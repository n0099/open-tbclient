package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private View mrp;
    private HeadImageView mrq;
    private TextView mrr;
    private TextView mrs;
    private ImageView mrt;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mrp = null;
        this.mrq = null;
        this.mrr = null;
        this.mrs = null;
        this.mrt = null;
        this.mrp = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.mrq = (HeadImageView) this.mrp.findViewById(R.id.zan_list_item_head);
        this.mrr = (TextView) this.mrp.findViewById(R.id.zan_list_item_name);
        this.mrs = (TextView) this.mrp.findViewById(R.id.zan_list_item_time);
        this.mrt = (ImageView) this.mrp.findViewById(R.id.zan_list_item_line_bottom);
        this.mrt.setVisibility(0);
        this.mrp.setTag(this);
    }

    public View getView() {
        return this.mrp;
    }

    public void f(String str, String str2, long j, boolean z) {
        this.mrr.setText(str);
        this.mrq.setImageDrawable(null);
        this.mrs.setText(au.getFormatTime(j));
        this.mrq.startLoad(str2, 28, false);
    }
}
