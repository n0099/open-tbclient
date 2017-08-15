package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class c {
    public final View aMb;
    private View.OnClickListener aYX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.aMb && c.this.eIu != null) {
                c.this.eIu.finish();
            }
        }
    };
    public final TextView abZ;
    private PbActivity eIu;
    public final View eWl;

    public c(PbActivity pbActivity) {
        this.eIu = pbActivity;
        this.aMb = this.eIu.findViewById(d.h.manga_navigation_bar_back);
        this.abZ = (TextView) this.eIu.findViewById(d.h.manga_navigation_bar_title);
        this.eWl = this.eIu.findViewById(d.h.manga_browser_navigation_bar);
        this.aMb.setOnClickListener(this.aYX);
    }

    public void setTitle(String str) {
        this.abZ.setText(str);
    }

    public void show() {
        this.eWl.setVisibility(0);
    }
}
