package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends x.a {
    public int ahf;
    public View bfI;
    public ImageView cSG;
    public TextView cSH;
    public ImageView cSI;

    public e(View view) {
        super(view);
        this.ahf = 3;
        this.bfI = view.findViewById(n.g.friendfeed_divider);
        this.cSG = (ImageView) view.findViewById(n.g.forum_feed_icon);
        this.cSH = (TextView) view.findViewById(n.g.forum_feed_title);
        this.cSI = (ImageView) view.findViewById(n.g.nav_indicator);
    }
}
