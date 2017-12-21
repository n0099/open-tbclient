package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aMu;
    private PbActivity eVu;
    public final View fgB;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aMu && b.this.eVu != null) {
                b.this.eVu.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.eVu = pbActivity;
        this.aMu = this.eVu.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.eVu.findViewById(d.g.manga_navigation_bar_title);
        this.fgB = this.eVu.findViewById(d.g.manga_browser_navigation_bar);
        this.aMu.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fgB.setVisibility(0);
    }
}
