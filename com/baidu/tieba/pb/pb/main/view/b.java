package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aKU;
    private View.OnClickListener aOR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aKU && b.this.eDo != null) {
                b.this.eDo.finish();
            }
        }
    };
    public final TextView aaS;
    private PbActivity eDo;
    public final View ePu;

    public b(PbActivity pbActivity) {
        this.eDo = pbActivity;
        this.aKU = this.eDo.findViewById(d.h.manga_navigation_bar_back);
        this.aaS = (TextView) this.eDo.findViewById(d.h.manga_navigation_bar_title);
        this.ePu = this.eDo.findViewById(d.h.manga_browser_navigation_bar);
        this.aKU.setOnClickListener(this.aOR);
    }

    public void setTitle(String str) {
        this.aaS.setText(str);
    }

    public void show() {
        this.ePu.setVisibility(0);
    }
}
