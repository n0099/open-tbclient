package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes6.dex */
public class a {
    public final View biG;
    private PbActivity fYJ;
    public final View gkL;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.biG && a.this.fYJ != null) {
                a.this.fYJ.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fYJ = pbActivity;
        this.biG = this.fYJ.findViewById(e.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fYJ.findViewById(e.g.manga_navigation_bar_title);
        this.gkL = this.fYJ.findViewById(e.g.manga_browser_navigation_bar);
        this.biG.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.gkL.setVisibility(0);
    }
}
