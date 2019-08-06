package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class b {
    public final View cCm;
    private PbActivity hNx;
    public final View hZI;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.cCm && b.this.hNx != null) {
                b.this.hNx.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.hNx = pbActivity;
        this.cCm = this.hNx.findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hNx.findViewById(R.id.manga_navigation_bar_title);
        this.hZI = this.hNx.findViewById(R.id.manga_browser_navigation_bar);
        this.cCm.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hZI.setVisibility(0);
    }
}
