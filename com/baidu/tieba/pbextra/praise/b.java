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
    private View bFK;
    private HeadImageView gps;
    private TextView gpt;
    private TextView gpu;
    private ImageView gpv;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bFK = null;
        this.gps = null;
        this.gpt = null;
        this.gpu = null;
        this.gpv = null;
        this.bFK = LayoutInflater.from(context).inflate(e.h.zan_list_item, (ViewGroup) null);
        this.gps = (HeadImageView) this.bFK.findViewById(e.g.zan_list_item_head);
        this.gpt = (TextView) this.bFK.findViewById(e.g.zan_list_item_name);
        this.gpu = (TextView) this.bFK.findViewById(e.g.zan_list_item_time);
        this.gpv = (ImageView) this.bFK.findViewById(e.g.zan_list_item_line_bottom);
        this.gpv.setVisibility(0);
        this.bFK.setTag(this);
    }

    public View getView() {
        return this.bFK;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.gpt.setText(str);
        this.gps.setImageDrawable(null);
        this.gpu.setText(ao.L(j));
        this.gps.startLoad(str2, 28, false);
    }
}
