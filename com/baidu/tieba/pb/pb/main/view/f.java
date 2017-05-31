package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f {
    public final View aIp;
    public final TextView aaa;
    private View.OnClickListener bhc = new g(this);
    private PbActivity elf;
    public final View exg;

    public f(PbActivity pbActivity) {
        this.elf = pbActivity;
        this.aIp = this.elf.findViewById(w.h.manga_navigation_bar_back);
        this.aaa = (TextView) this.elf.findViewById(w.h.manga_navigation_bar_title);
        this.exg = this.elf.findViewById(w.h.manga_browser_navigation_bar);
        this.aIp.setOnClickListener(this.bhc);
    }

    public void setTitle(String str) {
        this.aaa.setText(str);
    }

    public void show() {
        this.exg.setVisibility(0);
    }
}
