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
    private View cBd;
    private HeadImageView jQV;
    private TextView jQW;
    private TextView jQX;
    private ImageView jQY;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cBd = null;
        this.jQV = null;
        this.jQW = null;
        this.jQX = null;
        this.jQY = null;
        this.cBd = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jQV = (HeadImageView) this.cBd.findViewById(R.id.zan_list_item_head);
        this.jQW = (TextView) this.cBd.findViewById(R.id.zan_list_item_name);
        this.jQX = (TextView) this.cBd.findViewById(R.id.zan_list_item_time);
        this.jQY = (ImageView) this.cBd.findViewById(R.id.zan_list_item_line_bottom);
        this.jQY.setVisibility(0);
        this.cBd.setTag(this);
    }

    public View getView() {
        return this.cBd;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jQW.setText(str);
        this.jQV.setImageDrawable(null);
        this.jQX.setText(aq.getFormatTime(j));
        this.jQV.startLoad(str2, 28, false);
    }
}
