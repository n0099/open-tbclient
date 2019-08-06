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
    private View dbY;
    private HeadImageView iiI;
    private TextView iiJ;
    private TextView iiK;
    private ImageView iiL;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.dbY = null;
        this.iiI = null;
        this.iiJ = null;
        this.iiK = null;
        this.iiL = null;
        this.dbY = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.iiI = (HeadImageView) this.dbY.findViewById(R.id.zan_list_item_head);
        this.iiJ = (TextView) this.dbY.findViewById(R.id.zan_list_item_name);
        this.iiK = (TextView) this.dbY.findViewById(R.id.zan_list_item_time);
        this.iiL = (ImageView) this.dbY.findViewById(R.id.zan_list_item_line_bottom);
        this.iiL.setVisibility(0);
        this.dbY.setTag(this);
    }

    public View getView() {
        return this.dbY;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.iiJ.setText(str);
        this.iiI.setImageDrawable(null);
        this.iiK.setText(aq.aD(j));
        this.iiI.startLoad(str2, 28, false);
    }
}
