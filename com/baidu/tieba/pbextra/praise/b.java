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
/* loaded from: classes6.dex */
public class b {
    private View bXz;
    private HeadImageView jaw;
    private TextView jax;
    private TextView jay;
    private ImageView jaz;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bXz = null;
        this.jaw = null;
        this.jax = null;
        this.jay = null;
        this.jaz = null;
        this.bXz = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jaw = (HeadImageView) this.bXz.findViewById(R.id.zan_list_item_head);
        this.jax = (TextView) this.bXz.findViewById(R.id.zan_list_item_name);
        this.jay = (TextView) this.bXz.findViewById(R.id.zan_list_item_time);
        this.jaz = (ImageView) this.bXz.findViewById(R.id.zan_list_item_line_bottom);
        this.jaz.setVisibility(0);
        this.bXz.setTag(this);
    }

    public View getView() {
        return this.bXz;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jax.setText(str);
        this.jaw.setImageDrawable(null);
        this.jay.setText(aq.getFormatTime(j));
        this.jaw.startLoad(str2, 28, false);
    }
}
