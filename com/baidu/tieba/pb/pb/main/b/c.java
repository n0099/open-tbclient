package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    public final TextView VM;
    public final View aEm;
    private View.OnClickListener aif = new d(this);
    private PbActivity emy;
    public final View eva;

    public c(PbActivity pbActivity) {
        this.emy = pbActivity;
        this.aEm = this.emy.findViewById(t.g.manga_navigation_bar_back);
        this.VM = (TextView) this.emy.findViewById(t.g.manga_navigation_bar_title);
        this.eva = this.emy.findViewById(t.g.manga_browser_navigation_bar);
        this.aEm.setOnClickListener(this.aif);
    }

    public void setTitle(String str) {
        this.VM.setText(str);
    }

    public void show() {
        this.eva.setVisibility(0);
    }
}
