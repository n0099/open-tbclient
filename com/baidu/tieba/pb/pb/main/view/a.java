package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class a {
    public final View csE;
    public final View hAP;
    private PbActivity hpc;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.csE && a.this.hpc != null) {
                a.this.hpc.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.hpc = pbActivity;
        this.csE = this.hpc.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hpc.findViewById(d.g.manga_navigation_bar_title);
        this.hAP = this.hpc.findViewById(d.g.manga_browser_navigation_bar);
        this.csE.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hAP.setVisibility(0);
    }
}
