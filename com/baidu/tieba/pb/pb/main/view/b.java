package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class b {
    public final View cOr;
    private PbActivity hNY;
    public final View iam;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.cOr && b.this.hNY != null) {
                b.this.hNY.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.hNY = pbActivity;
        this.cOr = this.hNY.findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hNY.findViewById(R.id.manga_navigation_bar_title);
        this.iam = this.hNY.findViewById(R.id.manga_browser_navigation_bar);
        this.cOr.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.iam.setVisibility(0);
    }
}
