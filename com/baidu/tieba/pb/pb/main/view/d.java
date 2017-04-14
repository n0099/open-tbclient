package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    public final View aIw;
    private View.OnClickListener aRW = new e(this);
    public final TextView aaF;
    private PbActivity eig;
    public final View esd;

    public d(PbActivity pbActivity) {
        this.eig = pbActivity;
        this.aIw = this.eig.findViewById(w.h.manga_navigation_bar_back);
        this.aaF = (TextView) this.eig.findViewById(w.h.manga_navigation_bar_title);
        this.esd = this.eig.findViewById(w.h.manga_browser_navigation_bar);
        this.aIw.setOnClickListener(this.aRW);
    }

    public void setTitle(String str) {
        this.aaF.setText(str);
    }

    public void show() {
        this.esd.setVisibility(0);
    }
}
