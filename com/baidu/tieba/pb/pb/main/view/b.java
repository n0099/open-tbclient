package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class b {
    public final View cDi;
    private PbActivity hPu;
    public final View ibF;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.cDi && b.this.hPu != null) {
                b.this.hPu.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.hPu = pbActivity;
        this.cDi = this.hPu.findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hPu.findViewById(R.id.manga_navigation_bar_title);
        this.ibF = this.hPu.findViewById(R.id.manga_browser_navigation_bar);
        this.cDi.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.ibF.setVisibility(0);
    }
}
