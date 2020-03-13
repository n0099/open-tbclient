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
    private View cbR;
    private HeadImageView jfo;
    private TextView jfp;
    private TextView jfq;
    private ImageView jfr;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cbR = null;
        this.jfo = null;
        this.jfp = null;
        this.jfq = null;
        this.jfr = null;
        this.cbR = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jfo = (HeadImageView) this.cbR.findViewById(R.id.zan_list_item_head);
        this.jfp = (TextView) this.cbR.findViewById(R.id.zan_list_item_name);
        this.jfq = (TextView) this.cbR.findViewById(R.id.zan_list_item_time);
        this.jfr = (ImageView) this.cbR.findViewById(R.id.zan_list_item_line_bottom);
        this.jfr.setVisibility(0);
        this.cbR.setTag(this);
    }

    public View getView() {
        return this.cbR;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jfp.setText(str);
        this.jfo.setImageDrawable(null);
        this.jfq.setText(aq.getFormatTime(j));
        this.jfo.startLoad(str2, 28, false);
    }
}
