package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes6.dex */
public class a {
    public final View bhV;
    private PbActivity fXM;
    public final View gjI;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bhV && a.this.fXM != null) {
                a.this.fXM.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fXM = pbActivity;
        this.bhV = this.fXM.findViewById(e.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fXM.findViewById(e.g.manga_navigation_bar_title);
        this.gjI = this.fXM.findViewById(e.g.manga_browser_navigation_bar);
        this.bhV.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.gjI.setVisibility(0);
    }
}
