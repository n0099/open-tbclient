package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class c {
    public final View aMc;
    private View.OnClickListener aYY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.aMc && c.this.eIw != null) {
                c.this.eIw.finish();
            }
        }
    };
    public final TextView abZ;
    private PbActivity eIw;
    public final View eWn;

    public c(PbActivity pbActivity) {
        this.eIw = pbActivity;
        this.aMc = this.eIw.findViewById(d.h.manga_navigation_bar_back);
        this.abZ = (TextView) this.eIw.findViewById(d.h.manga_navigation_bar_title);
        this.eWn = this.eIw.findViewById(d.h.manga_browser_navigation_bar);
        this.aMc.setOnClickListener(this.aYY);
    }

    public void setTitle(String str) {
        this.abZ.setText(str);
    }

    public void show() {
        this.eWn.setVisibility(0);
    }
}
