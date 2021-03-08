package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private View mtH;
    private HeadImageView mtI;
    private TextView mtJ;
    private TextView mtK;
    private ImageView mtL;

    public static b c(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mtH = null;
        this.mtI = null;
        this.mtJ = null;
        this.mtK = null;
        this.mtL = null;
        this.mtH = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.mtI = (HeadImageView) this.mtH.findViewById(R.id.zan_list_item_head);
        this.mtJ = (TextView) this.mtH.findViewById(R.id.zan_list_item_name);
        this.mtK = (TextView) this.mtH.findViewById(R.id.zan_list_item_time);
        this.mtL = (ImageView) this.mtH.findViewById(R.id.zan_list_item_line_bottom);
        this.mtL.setVisibility(0);
        this.mtH.setTag(this);
    }

    public View getView() {
        return this.mtH;
    }

    public void f(String str, String str2, long j, boolean z) {
        this.mtJ.setText(str);
        this.mtI.setImageDrawable(null);
        this.mtK.setText(au.getFormatTime(j));
        this.mtI.startLoad(str2, 28, false);
    }
}
