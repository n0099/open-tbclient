package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    public final View aVP;
    public final View fJt;
    private PbActivity fxm;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aVP && a.this.fxm != null) {
                a.this.fxm.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fxm = pbActivity;
        this.aVP = this.fxm.findViewById(f.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fxm.findViewById(f.g.manga_navigation_bar_title);
        this.fJt = this.fxm.findViewById(f.g.manga_browser_navigation_bar);
        this.aVP.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fJt.setVisibility(0);
    }
}
