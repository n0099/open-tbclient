package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aLE;
    private PbActivity eMh;
    public final View eYm;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aLE && b.this.eMh != null) {
                b.this.eMh.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.eMh = pbActivity;
        this.aLE = this.eMh.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.eMh.findViewById(d.g.manga_navigation_bar_title);
        this.eYm = this.eMh.findViewById(d.g.manga_browser_navigation_bar);
        this.aLE.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.eYm.setVisibility(0);
    }
}
