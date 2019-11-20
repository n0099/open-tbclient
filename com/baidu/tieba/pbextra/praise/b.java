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
/* loaded from: classes4.dex */
public class b {
    private View dmp;
    private HeadImageView iiA;
    private TextView iiB;
    private TextView iiC;
    private ImageView iiD;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.dmp = null;
        this.iiA = null;
        this.iiB = null;
        this.iiC = null;
        this.iiD = null;
        this.dmp = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.iiA = (HeadImageView) this.dmp.findViewById(R.id.zan_list_item_head);
        this.iiB = (TextView) this.dmp.findViewById(R.id.zan_list_item_name);
        this.iiC = (TextView) this.dmp.findViewById(R.id.zan_list_item_time);
        this.iiD = (ImageView) this.dmp.findViewById(R.id.zan_list_item_line_bottom);
        this.iiD.setVisibility(0);
        this.dmp.setTag(this);
    }

    public View getView() {
        return this.dmp;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.iiB.setText(str);
        this.iiA.setImageDrawable(null);
        this.iiC.setText(aq.getFormatTime(j));
        this.iiA.startLoad(str2, 28, false);
    }
}
