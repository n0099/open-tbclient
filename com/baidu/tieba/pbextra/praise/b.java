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
    private View bhL;
    private HeadImageView fBK;
    private TextView fBL;
    private TextView fBM;
    private ImageView fBN;

    public static b d(Context context, View view2) {
        if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view2.getTag();
    }

    private b(Context context) {
        this.bhL = null;
        this.fBK = null;
        this.fBL = null;
        this.fBM = null;
        this.fBN = null;
        this.bhL = LayoutInflater.from(context).inflate(d.i.zan_list_item, (ViewGroup) null);
        this.fBK = (HeadImageView) this.bhL.findViewById(d.g.zan_list_item_head);
        this.fBL = (TextView) this.bhL.findViewById(d.g.zan_list_item_name);
        this.fBM = (TextView) this.bhL.findViewById(d.g.zan_list_item_time);
        this.fBN = (ImageView) this.bhL.findViewById(d.g.zan_list_item_line_bottom);
        this.fBN.setVisibility(0);
        this.bhL.setTag(this);
    }

    public View getView() {
        return this.bhL;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.fBL.setText(str);
        this.fBK.setImageDrawable(null);
        this.fBM.setText(an.s(j));
        this.fBK.startLoad(str2, 28, false);
    }
}
