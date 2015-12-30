package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j extends x.a {
    public RelativeLayout cTJ;
    public TextView cTK;
    public ImageView cTL;
    public ImageView cTM;
    public View cTb;
    public int mSkinType;

    public j(View view) {
        super(view);
        this.mSkinType = 3;
        this.cTb = null;
        this.cTJ = null;
        this.cTK = null;
        this.cTL = null;
        this.cTM = null;
        this.cTb = view.findViewById(n.g.top_divider);
        this.cTJ = (RelativeLayout) view.findViewById(n.g.live_thread_item);
        this.cTK = (TextView) view.findViewById(n.g.live_thread_item_title);
        this.cTM = (ImageView) view.findViewById(n.g.live_thread_item_icon);
        this.cTL = (ImageView) view.findViewById(n.g.live_thread_item_arrow);
    }
}
