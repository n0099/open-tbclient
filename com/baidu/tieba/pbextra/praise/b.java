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
    private View cRX;
    private HeadImageView hJl;
    private TextView hJm;
    private TextView hJn;
    private ImageView hJo;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cRX = null;
        this.hJl = null;
        this.hJm = null;
        this.hJn = null;
        this.hJo = null;
        this.cRX = LayoutInflater.from(context).inflate(d.h.zan_list_item, (ViewGroup) null);
        this.hJl = (HeadImageView) this.cRX.findViewById(d.g.zan_list_item_head);
        this.hJm = (TextView) this.cRX.findViewById(d.g.zan_list_item_name);
        this.hJn = (TextView) this.cRX.findViewById(d.g.zan_list_item_time);
        this.hJo = (ImageView) this.cRX.findViewById(d.g.zan_list_item_line_bottom);
        this.hJo.setVisibility(0);
        this.cRX.setTag(this);
    }

    public View getView() {
        return this.cRX;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.hJm.setText(str);
        this.hJl.setImageDrawable(null);
        this.hJn.setText(ap.ao(j));
        this.hJl.startLoad(str2, 28, false);
    }
}
