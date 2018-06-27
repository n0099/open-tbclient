package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    public final View aVN;
    public final View fJl;
    private PbActivity fxh;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aVN && a.this.fxh != null) {
                a.this.fxh.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fxh = pbActivity;
        this.aVN = this.fxh.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fxh.findViewById(d.g.manga_navigation_bar_title);
        this.fJl = this.fxh.findViewById(d.g.manga_browser_navigation_bar);
        this.aVN.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fJl.setVisibility(0);
    }
}
