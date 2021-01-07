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
    private View mmS;
    private HeadImageView mmT;
    private TextView mmU;
    private TextView mmV;
    private ImageView mmW;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mmS = null;
        this.mmT = null;
        this.mmU = null;
        this.mmV = null;
        this.mmW = null;
        this.mmS = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.mmT = (HeadImageView) this.mmS.findViewById(R.id.zan_list_item_head);
        this.mmU = (TextView) this.mmS.findViewById(R.id.zan_list_item_name);
        this.mmV = (TextView) this.mmS.findViewById(R.id.zan_list_item_time);
        this.mmW = (ImageView) this.mmS.findViewById(R.id.zan_list_item_line_bottom);
        this.mmW.setVisibility(0);
        this.mmS.setTag(this);
    }

    public View getView() {
        return this.mmS;
    }

    public void f(String str, String str2, long j, boolean z) {
        this.mmU.setText(str);
        this.mmT.setImageDrawable(null);
        this.mmV.setText(at.getFormatTime(j));
        this.mmT.startLoad(str2, 28, false);
    }
}
