package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends y.a {
    public int aej;
    public View biC;
    public ImageView cJU;
    public TextView dBD;
    public ImageView dBE;

    public g(View view) {
        super(view);
        this.aej = 3;
        this.biC = view.findViewById(t.g.friendfeed_divider);
        this.cJU = (ImageView) view.findViewById(t.g.forum_feed_icon);
        this.dBD = (TextView) view.findViewById(t.g.forum_feed_title);
        this.dBE = (ImageView) view.findViewById(t.g.nav_indicator);
    }
}
