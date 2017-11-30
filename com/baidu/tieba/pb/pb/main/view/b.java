package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aMn;
    private PbActivity eUm;
    public final View ffy;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aMn && b.this.eUm != null) {
                b.this.eUm.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.eUm = pbActivity;
        this.aMn = this.eUm.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.eUm.findViewById(d.g.manga_navigation_bar_title);
        this.ffy = this.eUm.findViewById(d.g.manga_browser_navigation_bar);
        this.aMn.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.ffy.setVisibility(0);
    }
}
