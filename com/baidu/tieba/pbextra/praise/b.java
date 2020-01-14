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
/* loaded from: classes7.dex */
public class b {
    private View bXL;
    private HeadImageView jee;
    private TextView jef;
    private TextView jeg;
    private ImageView jeh;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bXL = null;
        this.jee = null;
        this.jef = null;
        this.jeg = null;
        this.jeh = null;
        this.bXL = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jee = (HeadImageView) this.bXL.findViewById(R.id.zan_list_item_head);
        this.jef = (TextView) this.bXL.findViewById(R.id.zan_list_item_name);
        this.jeg = (TextView) this.bXL.findViewById(R.id.zan_list_item_time);
        this.jeh = (ImageView) this.bXL.findViewById(R.id.zan_list_item_line_bottom);
        this.jeh.setVisibility(0);
        this.bXL.setTag(this);
    }

    public View getView() {
        return this.bXL;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jef.setText(str);
        this.jee.setImageDrawable(null);
        this.jeg.setText(aq.getFormatTime(j));
        this.jee.startLoad(str2, 28, false);
    }
}
