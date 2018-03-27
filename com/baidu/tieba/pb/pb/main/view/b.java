package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class b {
    public final View bCs;
    private PbActivity fNg;
    public final View fYJ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.bCs && b.this.fNg != null) {
                b.this.fNg.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.fNg = pbActivity;
        this.bCs = this.fNg.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fNg.findViewById(d.g.manga_navigation_bar_title);
        this.fYJ = this.fNg.findViewById(d.g.manga_browser_navigation_bar);
        this.bCs.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fYJ.setVisibility(0);
    }
}
