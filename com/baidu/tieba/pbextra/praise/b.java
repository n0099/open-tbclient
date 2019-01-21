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
    private View bGB;
    private HeadImageView gto;
    private TextView gtp;
    private TextView gtq;
    private ImageView gtr;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bGB = null;
        this.gto = null;
        this.gtp = null;
        this.gtq = null;
        this.gtr = null;
        this.bGB = LayoutInflater.from(context).inflate(e.h.zan_list_item, (ViewGroup) null);
        this.gto = (HeadImageView) this.bGB.findViewById(e.g.zan_list_item_head);
        this.gtp = (TextView) this.bGB.findViewById(e.g.zan_list_item_name);
        this.gtq = (TextView) this.bGB.findViewById(e.g.zan_list_item_time);
        this.gtr = (ImageView) this.bGB.findViewById(e.g.zan_list_item_line_bottom);
        this.gtr.setVisibility(0);
        this.bGB.setTag(this);
    }

    public View getView() {
        return this.bGB;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.gtp.setText(str);
        this.gto.setImageDrawable(null);
        this.gtq.setText(ao.M(j));
        this.gto.startLoad(str2, 28, false);
    }
}
