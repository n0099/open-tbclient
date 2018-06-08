package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    public final View aUR;
    public final View fFk;
    private PbActivity ftp;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aUR && a.this.ftp != null) {
                a.this.ftp.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.ftp = pbActivity;
        this.aUR = this.ftp.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.ftp.findViewById(d.g.manga_navigation_bar_title);
        this.fFk = this.ftp.findViewById(d.g.manga_browser_navigation_bar);
        this.aUR.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fFk.setVisibility(0);
    }
}
