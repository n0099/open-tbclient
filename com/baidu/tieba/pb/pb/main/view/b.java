package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aLh;
    private View.OnClickListener aPe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aLh && b.this.eDC != null) {
                b.this.eDC.finish();
            }
        }
    };
    public final TextView abf;
    private PbActivity eDC;
    public final View ePI;

    public b(PbActivity pbActivity) {
        this.eDC = pbActivity;
        this.aLh = this.eDC.findViewById(d.h.manga_navigation_bar_back);
        this.abf = (TextView) this.eDC.findViewById(d.h.manga_navigation_bar_title);
        this.ePI = this.eDC.findViewById(d.h.manga_browser_navigation_bar);
        this.aLh.setOnClickListener(this.aPe);
    }

    public void setTitle(String str) {
        this.abf.setText(str);
    }

    public void show() {
        this.ePI.setVisibility(0);
    }
}
