package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    public final View aIC;
    private View.OnClickListener aSt = new e(this);
    public final TextView aab;
    private PbActivity efF;
    public final View epY;

    public d(PbActivity pbActivity) {
        this.efF = pbActivity;
        this.aIC = this.efF.findViewById(w.h.manga_navigation_bar_back);
        this.aab = (TextView) this.efF.findViewById(w.h.manga_navigation_bar_title);
        this.epY = this.efF.findViewById(w.h.manga_browser_navigation_bar);
        this.aIC.setOnClickListener(this.aSt);
    }

    public void setTitle(String str) {
        this.aab.setText(str);
    }

    public void show() {
        this.epY.setVisibility(0);
    }
}
