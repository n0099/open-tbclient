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
    private View ccc;
    private HeadImageView jgN;
    private TextView jgO;
    private TextView jgP;
    private ImageView jgQ;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.ccc = null;
        this.jgN = null;
        this.jgO = null;
        this.jgP = null;
        this.jgQ = null;
        this.ccc = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jgN = (HeadImageView) this.ccc.findViewById(R.id.zan_list_item_head);
        this.jgO = (TextView) this.ccc.findViewById(R.id.zan_list_item_name);
        this.jgP = (TextView) this.ccc.findViewById(R.id.zan_list_item_time);
        this.jgQ = (ImageView) this.ccc.findViewById(R.id.zan_list_item_line_bottom);
        this.jgQ.setVisibility(0);
        this.ccc.setTag(this);
    }

    public View getView() {
        return this.ccc;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jgO.setText(str);
        this.jgN.setImageDrawable(null);
        this.jgP.setText(aq.getFormatTime(j));
        this.jgN.startLoad(str2, 28, false);
    }
}
