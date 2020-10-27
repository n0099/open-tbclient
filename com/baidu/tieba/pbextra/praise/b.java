package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    private View lNq;
    private HeadImageView lNr;
    private TextView lNs;
    private TextView lNt;
    private ImageView lNu;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.lNq = null;
        this.lNr = null;
        this.lNs = null;
        this.lNt = null;
        this.lNu = null;
        this.lNq = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.lNr = (HeadImageView) this.lNq.findViewById(R.id.zan_list_item_head);
        this.lNs = (TextView) this.lNq.findViewById(R.id.zan_list_item_name);
        this.lNt = (TextView) this.lNq.findViewById(R.id.zan_list_item_time);
        this.lNu = (ImageView) this.lNq.findViewById(R.id.zan_list_item_line_bottom);
        this.lNu.setVisibility(0);
        this.lNq.setTag(this);
    }

    public View getView() {
        return this.lNq;
    }

    public void b(String str, String str2, long j, boolean z) {
        this.lNs.setText(str);
        this.lNr.setImageDrawable(null);
        this.lNt.setText(at.getFormatTime(j));
        this.lNr.startLoad(str2, 28, false);
    }
}
