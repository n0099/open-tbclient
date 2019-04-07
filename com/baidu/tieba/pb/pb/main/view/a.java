package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class a {
    public final View csD;
    public final View hAw;
    private PbActivity hoJ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.csD && a.this.hoJ != null) {
                a.this.hoJ.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.hoJ = pbActivity;
        this.csD = this.hoJ.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hoJ.findViewById(d.g.manga_navigation_bar_title);
        this.hAw = this.hoJ.findViewById(d.g.manga_browser_navigation_bar);
        this.csD.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hAw.setVisibility(0);
    }
}
