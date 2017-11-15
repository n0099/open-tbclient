package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public final View aLM;
    private PbActivity eMB;
    public final View eYH;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.aLM && b.this.eMB != null) {
                b.this.eMB.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.eMB = pbActivity;
        this.aLM = this.eMB.findViewById(d.g.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.eMB.findViewById(d.g.manga_navigation_bar_title);
        this.eYH = this.eMB.findViewById(d.g.manga_browser_navigation_bar);
        this.aLM.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.eYH.setVisibility(0);
    }
}
