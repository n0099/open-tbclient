package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class b {
    public final View cAN;
    private PbActivity hGm;
    public final View hSv;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.cAN && b.this.hGm != null) {
                b.this.hGm.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.hGm = pbActivity;
        this.cAN = this.hGm.findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hGm.findViewById(R.id.manga_navigation_bar_title);
        this.hSv = this.hGm.findViewById(R.id.manga_browser_navigation_bar);
        this.cAN.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hSv.setVisibility(0);
    }
}
