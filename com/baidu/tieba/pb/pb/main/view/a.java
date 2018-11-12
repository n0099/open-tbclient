package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes6.dex */
public class a {
    public final View bes;
    private PbActivity fOe;
    public final View fZY;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bes && a.this.fOe != null) {
                a.this.fOe.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fOe = pbActivity;
        this.bes = this.fOe.findViewById(e.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fOe.findViewById(e.g.manga_navigation_bar_title);
        this.fZY = this.fOe.findViewById(e.g.manga_browser_navigation_bar);
        this.bes.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fZY.setVisibility(0);
    }
}
