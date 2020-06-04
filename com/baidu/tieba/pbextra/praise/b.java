package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private View kjX;
    private HeadImageView kjY;
    private TextView kjZ;
    private TextView kka;
    private ImageView kkb;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.kjX = null;
        this.kjY = null;
        this.kjZ = null;
        this.kka = null;
        this.kkb = null;
        this.kjX = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.kjY = (HeadImageView) this.kjX.findViewById(R.id.zan_list_item_head);
        this.kjZ = (TextView) this.kjX.findViewById(R.id.zan_list_item_name);
        this.kka = (TextView) this.kjX.findViewById(R.id.zan_list_item_time);
        this.kkb = (ImageView) this.kjX.findViewById(R.id.zan_list_item_line_bottom);
        this.kkb.setVisibility(0);
        this.kjX.setTag(this);
    }

    public View getView() {
        return this.kjX;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.kjZ.setText(str);
        this.kjY.setImageDrawable(null);
        this.kka.setText(aq.getFormatTime(j));
        this.kjY.startLoad(str2, 28, false);
    }
}
