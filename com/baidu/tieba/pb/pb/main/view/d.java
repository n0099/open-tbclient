package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    public final View aIg;
    private View.OnClickListener aRG = new e(this);
    public final TextView aap;
    private PbActivity eka;
    public final View eua;

    public d(PbActivity pbActivity) {
        this.eka = pbActivity;
        this.aIg = this.eka.findViewById(w.h.manga_navigation_bar_back);
        this.aap = (TextView) this.eka.findViewById(w.h.manga_navigation_bar_title);
        this.eua = this.eka.findViewById(w.h.manga_browser_navigation_bar);
        this.aIg.setOnClickListener(this.aRG);
    }

    public void setTitle(String str) {
        this.aap.setText(str);
    }

    public void show() {
        this.eua.setVisibility(0);
    }
}
