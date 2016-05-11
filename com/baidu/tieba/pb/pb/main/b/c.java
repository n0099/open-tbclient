package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    private View.OnClickListener Fn = new d(this);
    public final TextView RX;
    public final View azx;
    private PbActivity dhY;
    public final View dpS;

    public c(PbActivity pbActivity) {
        this.dhY = pbActivity;
        this.azx = this.dhY.findViewById(t.g.manga_navigation_bar_back);
        this.RX = (TextView) this.dhY.findViewById(t.g.manga_navigation_bar_title);
        this.dpS = this.dhY.findViewById(t.g.manga_browser_navigation_bar);
        this.azx.setOnClickListener(this.Fn);
    }

    public void setTitle(String str) {
        this.RX.setText(str);
    }

    public void show() {
        this.dpS.setVisibility(0);
    }
}
