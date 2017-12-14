package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aMr;
    private PbActivity eVp;
    public final View fgw;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aMr && b.this.eVp != null) {
                b.this.eVp.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.eVp = pbActivity;
        this.aMr = this.eVp.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.eVp.findViewById(d.g.manga_navigation_bar_title);
        this.fgw = this.eVp.findViewById(d.g.manga_browser_navigation_bar);
        this.aMr.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fgw.setVisibility(0);
    }
}
