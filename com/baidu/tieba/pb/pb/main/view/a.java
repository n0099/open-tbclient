package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class a {
    public final View csB;
    public final View hAK;
    private PbActivity hoW;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.csB && a.this.hoW != null) {
                a.this.hoW.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.hoW = pbActivity;
        this.csB = this.hoW.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hoW.findViewById(d.g.manga_navigation_bar_title);
        this.hAK = this.hoW.findViewById(d.g.manga_browser_navigation_bar);
        this.csB.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hAK.setVisibility(0);
    }
}
