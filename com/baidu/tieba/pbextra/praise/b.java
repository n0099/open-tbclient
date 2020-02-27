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
    private View cbP;
    private HeadImageView jfa;
    private TextView jfb;
    private TextView jfc;
    private ImageView jfd;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cbP = null;
        this.jfa = null;
        this.jfb = null;
        this.jfc = null;
        this.jfd = null;
        this.cbP = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jfa = (HeadImageView) this.cbP.findViewById(R.id.zan_list_item_head);
        this.jfb = (TextView) this.cbP.findViewById(R.id.zan_list_item_name);
        this.jfc = (TextView) this.cbP.findViewById(R.id.zan_list_item_time);
        this.jfd = (ImageView) this.cbP.findViewById(R.id.zan_list_item_line_bottom);
        this.jfd.setVisibility(0);
        this.cbP.setTag(this);
    }

    public View getView() {
        return this.cbP;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jfb.setText(str);
        this.jfa.setImageDrawable(null);
        this.jfc.setText(aq.getFormatTime(j));
        this.jfa.startLoad(str2, 28, false);
    }
}
