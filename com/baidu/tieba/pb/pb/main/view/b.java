package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class b {
    public final View bCp;
    private PbActivity fMQ;
    public final View fYt;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.bCp && b.this.fMQ != null) {
                b.this.fMQ.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.fMQ = pbActivity;
        this.bCp = this.fMQ.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fMQ.findViewById(d.g.manga_navigation_bar_title);
        this.fYt = this.fMQ.findViewById(d.g.manga_browser_navigation_bar);
        this.bCp.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fYt.setVisibility(0);
    }
}
