package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class b {
    public final View bAh;
    private PbActivity fHW;
    public final View fTx;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.bAh && b.this.fHW != null) {
                b.this.fHW.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.fHW = pbActivity;
        this.bAh = this.fHW.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fHW.findViewById(d.g.manga_navigation_bar_title);
        this.fTx = this.fHW.findViewById(d.g.manga_browser_navigation_bar);
        this.bAh.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fTx.setVisibility(0);
    }
}
