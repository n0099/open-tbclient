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
    private View cRU;
    private TextView hJA;
    private ImageView hJB;
    private HeadImageView hJy;
    private TextView hJz;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cRU = null;
        this.hJy = null;
        this.hJz = null;
        this.hJA = null;
        this.hJB = null;
        this.cRU = LayoutInflater.from(context).inflate(d.h.zan_list_item, (ViewGroup) null);
        this.hJy = (HeadImageView) this.cRU.findViewById(d.g.zan_list_item_head);
        this.hJz = (TextView) this.cRU.findViewById(d.g.zan_list_item_name);
        this.hJA = (TextView) this.cRU.findViewById(d.g.zan_list_item_time);
        this.hJB = (ImageView) this.cRU.findViewById(d.g.zan_list_item_line_bottom);
        this.hJB.setVisibility(0);
        this.cRU.setTag(this);
    }

    public View getView() {
        return this.cRU;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.hJz.setText(str);
        this.hJy.setImageDrawable(null);
        this.hJA.setText(ap.ao(j));
        this.hJy.startLoad(str2, 28, false);
    }
}
