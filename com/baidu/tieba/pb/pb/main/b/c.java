package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c {
    public final TextView So;
    public final View aAp;
    private View.OnClickListener aew = new d(this);
    private PbActivity dOg;
    public final View dWq;

    public c(PbActivity pbActivity) {
        this.dOg = pbActivity;
        this.aAp = this.dOg.findViewById(u.g.manga_navigation_bar_back);
        this.So = (TextView) this.dOg.findViewById(u.g.manga_navigation_bar_title);
        this.dWq = this.dOg.findViewById(u.g.manga_browser_navigation_bar);
        this.aAp.setOnClickListener(this.aew);
    }

    public void setTitle(String str) {
        this.So.setText(str);
    }

    public void show() {
        this.dWq.setVisibility(0);
    }
}
