package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    public final View aMS;
    private PbActivity fgM;
    public final View fsP;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == a.this.aMS && a.this.fgM != null) {
                a.this.fgM.finish();
            }
        }
    };
    public final TextView mTitleView;

    public a(PbActivity pbActivity) {
        this.fgM = pbActivity;
        this.aMS = this.fgM.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.fgM.findViewById(d.g.manga_navigation_bar_title);
        this.fsP = this.fgM.findViewById(d.g.manga_browser_navigation_bar);
        this.aMS.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.fsP.setVisibility(0);
    }
}
