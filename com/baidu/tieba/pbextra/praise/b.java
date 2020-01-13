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
/* loaded from: classes7.dex */
public class b {
    private View bXL;
    private HeadImageView jdZ;
    private TextView jea;
    private TextView jeb;
    private ImageView jec;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bXL = null;
        this.jdZ = null;
        this.jea = null;
        this.jeb = null;
        this.jec = null;
        this.bXL = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jdZ = (HeadImageView) this.bXL.findViewById(R.id.zan_list_item_head);
        this.jea = (TextView) this.bXL.findViewById(R.id.zan_list_item_name);
        this.jeb = (TextView) this.bXL.findViewById(R.id.zan_list_item_time);
        this.jec = (ImageView) this.bXL.findViewById(R.id.zan_list_item_line_bottom);
        this.jec.setVisibility(0);
        this.bXL.setTag(this);
    }

    public View getView() {
        return this.bXL;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jea.setText(str);
        this.jdZ.setImageDrawable(null);
        this.jeb.setText(aq.getFormatTime(j));
        this.jdZ.startLoad(str2, 28, false);
    }
}
