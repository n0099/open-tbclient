package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes6.dex */
public class a {
    public final View bdE;
    private PbActivity fMF;
    public final View fYz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bdE && a.this.fMF != null) {
                a.this.fMF.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fMF = pbActivity;
        this.bdE = this.fMF.findViewById(e.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fMF.findViewById(e.g.manga_navigation_bar_title);
        this.fYz = this.fMF.findViewById(e.g.manga_browser_navigation_bar);
        this.bdE.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fYz.setVisibility(0);
    }
}
