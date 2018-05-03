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
    private HeadImageView fBH;
    private TextView fBI;
    private TextView fBJ;
    private ImageView fBK;

    public static b d(Context context, View view2) {
        if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view2.getTag();
    }

    private b(Context context) {
        this.bhL = null;
        this.fBH = null;
        this.fBI = null;
        this.fBJ = null;
        this.fBK = null;
        this.bhL = LayoutInflater.from(context).inflate(d.i.zan_list_item, (ViewGroup) null);
        this.fBH = (HeadImageView) this.bhL.findViewById(d.g.zan_list_item_head);
        this.fBI = (TextView) this.bhL.findViewById(d.g.zan_list_item_name);
        this.fBJ = (TextView) this.bhL.findViewById(d.g.zan_list_item_time);
        this.fBK = (ImageView) this.bhL.findViewById(d.g.zan_list_item_line_bottom);
        this.fBK.setVisibility(0);
        this.bhL.setTag(this);
    }

    public View getView() {
        return this.bhL;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.fBI.setText(str);
        this.fBH.setImageDrawable(null);
        this.fBJ.setText(an.s(j));
        this.fBH.startLoad(str2, 28, false);
    }
}
