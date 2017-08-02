package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class c {
    public final View aKL;
    private View.OnClickListener aXL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.aKL && c.this.eFn != null) {
                c.this.eFn.finish();
            }
        }
    };
    public final TextView aaA;
    private PbActivity eFn;
    public final View eTf;

    public c(PbActivity pbActivity) {
        this.eFn = pbActivity;
        this.aKL = this.eFn.findViewById(d.h.manga_navigation_bar_back);
        this.aaA = (TextView) this.eFn.findViewById(d.h.manga_navigation_bar_title);
        this.eTf = this.eFn.findViewById(d.h.manga_browser_navigation_bar);
        this.aKL.setOnClickListener(this.aXL);
    }

    public void setTitle(String str) {
        this.aaA.setText(str);
    }

    public void show() {
        this.eTf.setVisibility(0);
    }
}
