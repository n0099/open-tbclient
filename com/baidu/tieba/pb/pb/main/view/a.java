package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes6.dex */
public class a {
    public final View bhS;
    private PbActivity fUU;
    public final View ggP;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bhS && a.this.fUU != null) {
                a.this.fUU.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fUU = pbActivity;
        this.bhS = this.fUU.findViewById(e.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fUU.findViewById(e.g.manga_navigation_bar_title);
        this.ggP = this.fUU.findViewById(e.g.manga_browser_navigation_bar);
        this.bhS.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.ggP.setVisibility(0);
    }
}
