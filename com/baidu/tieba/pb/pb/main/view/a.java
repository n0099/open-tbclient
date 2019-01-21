package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes6.dex */
public class a {
    public final View biH;
    private PbActivity fYK;
    public final View gkM;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.biH && a.this.fYK != null) {
                a.this.fYK.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fYK = pbActivity;
        this.biH = this.fYK.findViewById(e.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fYK.findViewById(e.g.manga_navigation_bar_title);
        this.gkM = this.fYK.findViewById(e.g.manga_browser_navigation_bar);
        this.biH.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.gkM.setVisibility(0);
    }
}
