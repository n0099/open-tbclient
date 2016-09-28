package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    public final TextView VW;
    public final View aDK;
    private View.OnClickListener ahN = new d(this);
    private PbActivity eow;
    public final View exg;

    public c(PbActivity pbActivity) {
        this.eow = pbActivity;
        this.aDK = this.eow.findViewById(r.g.manga_navigation_bar_back);
        this.VW = (TextView) this.eow.findViewById(r.g.manga_navigation_bar_title);
        this.exg = this.eow.findViewById(r.g.manga_browser_navigation_bar);
        this.aDK.setOnClickListener(this.ahN);
    }

    public void setTitle(String str) {
        this.VW.setText(str);
    }

    public void show() {
        this.exg.setVisibility(0);
    }
}
