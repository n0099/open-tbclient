package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class n extends y.a {
    public int afy;
    public View bNl;
    public ImageView dsQ;
    public TextView ewI;
    public ImageView ewJ;

    public n(View view) {
        super(view);
        this.afy = 3;
        this.bNl = view.findViewById(u.g.togetherhi_divider);
        this.dsQ = (ImageView) view.findViewById(u.g.togetherhi_icon);
        this.ewI = (TextView) view.findViewById(u.g.togetherhi_title);
        this.ewJ = (ImageView) view.findViewById(u.g.nav_indicator);
    }
}
