package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n extends y.a {
    public int aej;
    public View biC;
    public ImageView cJU;
    public TextView dBD;
    public ImageView dBE;

    public n(View view) {
        super(view);
        this.aej = 3;
        this.biC = view.findViewById(t.g.togetherhi_divider);
        this.cJU = (ImageView) view.findViewById(t.g.togetherhi_icon);
        this.dBD = (TextView) view.findViewById(t.g.togetherhi_title);
        this.dBE = (ImageView) view.findViewById(t.g.nav_indicator);
    }
}
