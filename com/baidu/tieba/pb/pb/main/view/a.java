package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    public final View aZe;
    private PbActivity fFd;
    public final View fQY;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aZe && a.this.fFd != null) {
                a.this.fFd.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fFd = pbActivity;
        this.aZe = this.fFd.findViewById(e.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fFd.findViewById(e.g.manga_navigation_bar_title);
        this.fQY = this.fFd.findViewById(e.g.manga_browser_navigation_bar);
        this.aZe.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fQY.setVisibility(0);
    }
}
