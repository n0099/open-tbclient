package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aLF;
    private View.OnClickListener aYH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aLF && b.this.eHK != null) {
                b.this.eHK.finish();
            }
        }
    };
    public final TextView abe;
    private PbActivity eHK;
    public final View eVG;

    public b(PbActivity pbActivity) {
        this.eHK = pbActivity;
        this.aLF = this.eHK.findViewById(d.h.manga_navigation_bar_back);
        this.abe = (TextView) this.eHK.findViewById(d.h.manga_navigation_bar_title);
        this.eVG = this.eHK.findViewById(d.h.manga_browser_navigation_bar);
        this.aLF.setOnClickListener(this.aYH);
    }

    public void setTitle(String str) {
        this.abe.setText(str);
    }

    public void show() {
        this.eVG.setVisibility(0);
    }
}
