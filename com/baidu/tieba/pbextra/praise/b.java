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
/* loaded from: classes21.dex */
public class b {
    private View llB;
    private HeadImageView llC;
    private TextView llD;
    private TextView llE;
    private ImageView llF;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.llB = null;
        this.llC = null;
        this.llD = null;
        this.llE = null;
        this.llF = null;
        this.llB = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.llC = (HeadImageView) this.llB.findViewById(R.id.zan_list_item_head);
        this.llD = (TextView) this.llB.findViewById(R.id.zan_list_item_name);
        this.llE = (TextView) this.llB.findViewById(R.id.zan_list_item_time);
        this.llF = (ImageView) this.llB.findViewById(R.id.zan_list_item_line_bottom);
        this.llF.setVisibility(0);
        this.llB.setTag(this);
    }

    public View getView() {
        return this.llB;
    }

    public void b(String str, String str2, long j, boolean z) {
        this.llD.setText(str);
        this.llC.setImageDrawable(null);
        this.llE.setText(at.getFormatTime(j));
        this.llC.startLoad(str2, 28, false);
    }
}
