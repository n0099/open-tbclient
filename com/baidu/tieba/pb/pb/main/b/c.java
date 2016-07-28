package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c {
    public final TextView SW;
    public final View aBf;
    private View.OnClickListener afk = new d(this);
    private PbActivity eat;
    public final View eiT;

    public c(PbActivity pbActivity) {
        this.eat = pbActivity;
        this.aBf = this.eat.findViewById(u.g.manga_navigation_bar_back);
        this.SW = (TextView) this.eat.findViewById(u.g.manga_navigation_bar_title);
        this.eiT = this.eat.findViewById(u.g.manga_browser_navigation_bar);
        this.aBf.setOnClickListener(this.afk);
    }

    public void setTitle(String str) {
        this.SW.setText(str);
    }

    public void show() {
        this.eiT.setVisibility(0);
    }
}
