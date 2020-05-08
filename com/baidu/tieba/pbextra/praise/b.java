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
    private View cBj;
    private HeadImageView jQZ;
    private TextView jRa;
    private TextView jRb;
    private ImageView jRc;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cBj = null;
        this.jQZ = null;
        this.jRa = null;
        this.jRb = null;
        this.jRc = null;
        this.cBj = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jQZ = (HeadImageView) this.cBj.findViewById(R.id.zan_list_item_head);
        this.jRa = (TextView) this.cBj.findViewById(R.id.zan_list_item_name);
        this.jRb = (TextView) this.cBj.findViewById(R.id.zan_list_item_time);
        this.jRc = (ImageView) this.cBj.findViewById(R.id.zan_list_item_line_bottom);
        this.jRc.setVisibility(0);
        this.cBj.setTag(this);
    }

    public View getView() {
        return this.cBj;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jRa.setText(str);
        this.jQZ.setImageDrawable(null);
        this.jRb.setText(aq.getFormatTime(j));
        this.jQZ.startLoad(str2, 28, false);
    }
}
