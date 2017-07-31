package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class c {
    public final View aMa;
    private View.OnClickListener aYW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.aMa && c.this.eGA != null) {
                c.this.eGA.finish();
            }
        }
    };
    public final TextView abX;
    private PbActivity eGA;
    public final View eUs;

    public c(PbActivity pbActivity) {
        this.eGA = pbActivity;
        this.aMa = this.eGA.findViewById(d.h.manga_navigation_bar_back);
        this.abX = (TextView) this.eGA.findViewById(d.h.manga_navigation_bar_title);
        this.eUs = this.eGA.findViewById(d.h.manga_browser_navigation_bar);
        this.aMa.setOnClickListener(this.aYW);
    }

    public void setTitle(String str) {
        this.abX.setText(str);
    }

    public void show() {
        this.eUs.setVisibility(0);
    }
}
