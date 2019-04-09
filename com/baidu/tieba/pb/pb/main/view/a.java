package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class a {
    public final View csE;
    public final View hAx;
    private PbActivity hoK;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.csE && a.this.hoK != null) {
                a.this.hoK.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.hoK = pbActivity;
        this.csE = this.hoK.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hoK.findViewById(d.g.manga_navigation_bar_title);
        this.hAx = this.hoK.findViewById(d.g.manga_browser_navigation_bar);
        this.csE.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hAx.setVisibility(0);
    }
}
