package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    public final View aIy;
    private View.OnClickListener aRY = new e(this);
    public final TextView aaG;
    private PbActivity ekw;
    public final View euv;

    public d(PbActivity pbActivity) {
        this.ekw = pbActivity;
        this.aIy = this.ekw.findViewById(w.h.manga_navigation_bar_back);
        this.aaG = (TextView) this.ekw.findViewById(w.h.manga_navigation_bar_title);
        this.euv = this.ekw.findViewById(w.h.manga_browser_navigation_bar);
        this.aIy.setOnClickListener(this.aRY);
    }

    public void setTitle(String str) {
        this.aaG.setText(str);
    }

    public void show() {
        this.euv.setVisibility(0);
    }
}
