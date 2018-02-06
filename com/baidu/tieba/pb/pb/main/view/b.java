package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class b {
    public final View bCC;
    private PbActivity fNb;
    public final View fYE;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.bCC && b.this.fNb != null) {
                b.this.fNb.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.fNb = pbActivity;
        this.bCC = this.fNb.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fNb.findViewById(d.g.manga_navigation_bar_title);
        this.fYE = this.fNb.findViewById(d.g.manga_browser_navigation_bar);
        this.bCC.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fYE.setVisibility(0);
    }
}
