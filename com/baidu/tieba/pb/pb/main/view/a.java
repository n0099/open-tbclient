package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    public final View aMT;
    private PbActivity fhQ;
    public final View ftT;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == a.this.aMT && a.this.fhQ != null) {
                a.this.fhQ.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fhQ = pbActivity;
        this.aMT = this.fhQ.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fhQ.findViewById(d.g.manga_navigation_bar_title);
        this.ftT = this.fhQ.findViewById(d.g.manga_browser_navigation_bar);
        this.aMT.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.ftT.setVisibility(0);
    }
}
