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
    private View lAT;
    private HeadImageView lAU;
    private TextView lAV;
    private TextView lAW;
    private ImageView lAX;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.lAT = null;
        this.lAU = null;
        this.lAV = null;
        this.lAW = null;
        this.lAX = null;
        this.lAT = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.lAU = (HeadImageView) this.lAT.findViewById(R.id.zan_list_item_head);
        this.lAV = (TextView) this.lAT.findViewById(R.id.zan_list_item_name);
        this.lAW = (TextView) this.lAT.findViewById(R.id.zan_list_item_time);
        this.lAX = (ImageView) this.lAT.findViewById(R.id.zan_list_item_line_bottom);
        this.lAX.setVisibility(0);
        this.lAT.setTag(this);
    }

    public View getView() {
        return this.lAT;
    }

    public void b(String str, String str2, long j, boolean z) {
        this.lAV.setText(str);
        this.lAU.setImageDrawable(null);
        this.lAW.setText(at.getFormatTime(j));
        this.lAU.startLoad(str2, 28, false);
    }
}
