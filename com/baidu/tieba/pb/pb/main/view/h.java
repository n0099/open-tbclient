package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h {
    public final View aJD;
    public final TextView aab;
    private View.OnClickListener bkk = new i(this);
    public final View eGF;
    private PbActivity euf;

    public h(PbActivity pbActivity) {
        this.euf = pbActivity;
        this.aJD = this.euf.findViewById(w.h.manga_navigation_bar_back);
        this.aab = (TextView) this.euf.findViewById(w.h.manga_navigation_bar_title);
        this.eGF = this.euf.findViewById(w.h.manga_browser_navigation_bar);
        this.aJD.setOnClickListener(this.bkk);
    }

    public void setTitle(String str) {
        this.aab.setText(str);
    }

    public void show() {
        this.eGF.setVisibility(0);
    }
}
