package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d {
    public final TextView Ve;
    public final View aCJ;
    private View.OnClickListener aLT = new e(this);
    private PbActivity ehi;
    public final View eqP;

    public d(PbActivity pbActivity) {
        this.ehi = pbActivity;
        this.aCJ = this.ehi.findViewById(r.h.manga_navigation_bar_back);
        this.Ve = (TextView) this.ehi.findViewById(r.h.manga_navigation_bar_title);
        this.eqP = this.ehi.findViewById(r.h.manga_browser_navigation_bar);
        this.aCJ.setOnClickListener(this.aLT);
    }

    public void setTitle(String str) {
        this.Ve.setText(str);
    }

    public void show() {
        this.eqP.setVisibility(0);
    }
}
