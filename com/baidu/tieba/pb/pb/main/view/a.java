package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    public final View aVP;
    public final View fJA;
    private PbActivity fxt;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aVP && a.this.fxt != null) {
                a.this.fxt.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fxt = pbActivity;
        this.aVP = this.fxt.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fxt.findViewById(d.g.manga_navigation_bar_title);
        this.fJA = this.fxt.findViewById(d.g.manga_browser_navigation_bar);
        this.aVP.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fJA.setVisibility(0);
    }
}
