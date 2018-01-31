package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class b {
    public final View bAy;
    private PbActivity fJR;
    public final View fVs;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.bAy && b.this.fJR != null) {
                b.this.fJR.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.fJR = pbActivity;
        this.bAy = this.fJR.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fJR.findViewById(d.g.manga_navigation_bar_title);
        this.fVs = this.fJR.findViewById(d.g.manga_browser_navigation_bar);
        this.bAy.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fVs.setVisibility(0);
    }
}
