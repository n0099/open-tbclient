package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aLI;
    private View.OnClickListener aYK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aLI && b.this.eGQ != null) {
                b.this.eGQ.finish();
            }
        }
    };
    public final TextView abe;
    private PbActivity eGQ;
    public final View eUM;

    public b(PbActivity pbActivity) {
        this.eGQ = pbActivity;
        this.aLI = this.eGQ.findViewById(d.h.manga_navigation_bar_back);
        this.abe = (TextView) this.eGQ.findViewById(d.h.manga_navigation_bar_title);
        this.eUM = this.eGQ.findViewById(d.h.manga_browser_navigation_bar);
        this.aLI.setOnClickListener(this.aYK);
    }

    public void setTitle(String str) {
        this.abe.setText(str);
    }

    public void show() {
        this.eUM.setVisibility(0);
    }
}
