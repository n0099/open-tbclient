package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private View bhQ;
    private HeadImageView fCN;
    private TextView fCO;
    private TextView fCP;
    private ImageView fCQ;

    public static b d(Context context, View view2) {
        if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view2.getTag();
    }

    private b(Context context) {
        this.bhQ = null;
        this.fCN = null;
        this.fCO = null;
        this.fCP = null;
        this.fCQ = null;
        this.bhQ = LayoutInflater.from(context).inflate(d.i.zan_list_item, (ViewGroup) null);
        this.fCN = (HeadImageView) this.bhQ.findViewById(d.g.zan_list_item_head);
        this.fCO = (TextView) this.bhQ.findViewById(d.g.zan_list_item_name);
        this.fCP = (TextView) this.bhQ.findViewById(d.g.zan_list_item_time);
        this.fCQ = (ImageView) this.bhQ.findViewById(d.g.zan_list_item_line_bottom);
        this.fCQ.setVisibility(0);
        this.bhQ.setTag(this);
    }

    public View getView() {
        return this.bhQ;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.fCO.setText(str);
        this.fCN.setImageDrawable(null);
        this.fCP.setText(an.s(j));
        this.fCN.startLoad(str2, 28, false);
    }
}
