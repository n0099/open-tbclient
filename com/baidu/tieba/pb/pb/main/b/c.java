package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    private View.OnClickListener OZ = new d(this);
    public final TextView WM;
    public final View aDt;
    private PbActivity dfw;
    public final View dnD;

    public c(PbActivity pbActivity) {
        this.dfw = pbActivity;
        this.aDt = this.dfw.findViewById(t.g.manga_navigation_bar_back);
        this.WM = (TextView) this.dfw.findViewById(t.g.manga_navigation_bar_title);
        this.dnD = this.dfw.findViewById(t.g.manga_browser_navigation_bar);
        this.aDt.setOnClickListener(this.OZ);
    }

    public void setTitle(String str) {
        this.WM.setText(str);
    }

    public void show() {
        this.dnD.setVisibility(0);
    }
}
