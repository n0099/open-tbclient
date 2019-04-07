package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b {
    private View cRW;
    private HeadImageView hJk;
    private TextView hJl;
    private TextView hJm;
    private ImageView hJn;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cRW = null;
        this.hJk = null;
        this.hJl = null;
        this.hJm = null;
        this.hJn = null;
        this.cRW = LayoutInflater.from(context).inflate(d.h.zan_list_item, (ViewGroup) null);
        this.hJk = (HeadImageView) this.cRW.findViewById(d.g.zan_list_item_head);
        this.hJl = (TextView) this.cRW.findViewById(d.g.zan_list_item_name);
        this.hJm = (TextView) this.cRW.findViewById(d.g.zan_list_item_time);
        this.hJn = (ImageView) this.cRW.findViewById(d.g.zan_list_item_line_bottom);
        this.hJn.setVisibility(0);
        this.cRW.setTag(this);
    }

    public View getView() {
        return this.cRW;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.hJl.setText(str);
        this.hJk.setImageDrawable(null);
        this.hJm.setText(ap.ao(j));
        this.hJk.startLoad(str2, 28, false);
    }
}
