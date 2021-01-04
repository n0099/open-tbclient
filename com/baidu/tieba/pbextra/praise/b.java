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
/* loaded from: classes2.dex */
public class b {
    private View mmT;
    private HeadImageView mmU;
    private TextView mmV;
    private TextView mmW;
    private ImageView mmX;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mmT = null;
        this.mmU = null;
        this.mmV = null;
        this.mmW = null;
        this.mmX = null;
        this.mmT = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.mmU = (HeadImageView) this.mmT.findViewById(R.id.zan_list_item_head);
        this.mmV = (TextView) this.mmT.findViewById(R.id.zan_list_item_name);
        this.mmW = (TextView) this.mmT.findViewById(R.id.zan_list_item_time);
        this.mmX = (ImageView) this.mmT.findViewById(R.id.zan_list_item_line_bottom);
        this.mmX.setVisibility(0);
        this.mmT.setTag(this);
    }

    public View getView() {
        return this.mmT;
    }

    public void f(String str, String str2, long j, boolean z) {
        this.mmV.setText(str);
        this.mmU.setImageDrawable(null);
        this.mmW.setText(at.getFormatTime(j));
        this.mmU.startLoad(str2, 28, false);
    }
}
