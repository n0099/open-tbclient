package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h extends x.a {
    public RelativeLayout cOZ;
    public View cOr;
    public TextView cPa;
    public ImageView cPb;
    public ImageView cPc;
    public int mSkinType;

    public h(View view) {
        super(view);
        this.mSkinType = 3;
        this.cOr = null;
        this.cOZ = null;
        this.cPa = null;
        this.cPb = null;
        this.cPc = null;
        this.cOr = view.findViewById(n.f.top_divider);
        this.cOZ = (RelativeLayout) view.findViewById(n.f.live_thread_item);
        this.cPa = (TextView) view.findViewById(n.f.live_thread_item_title);
        this.cPc = (ImageView) view.findViewById(n.f.live_thread_item_icon);
        this.cPb = (ImageView) view.findViewById(n.f.live_thread_item_arrow);
    }
}
