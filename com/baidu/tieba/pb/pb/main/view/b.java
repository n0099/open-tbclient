package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class b {
    public final View bAq;
    private PbActivity fJw;
    public final View fUX;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.bAq && b.this.fJw != null) {
                b.this.fJw.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.fJw = pbActivity;
        this.bAq = this.fJw.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fJw.findViewById(d.g.manga_navigation_bar_title);
        this.fUX = this.fJw.findViewById(d.g.manga_browser_navigation_bar);
        this.bAq.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fUX.setVisibility(0);
    }
}
