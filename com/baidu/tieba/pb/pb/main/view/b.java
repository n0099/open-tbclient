package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class b {
    public final View cNA;
    private PbActivity hNh;
    public final View hZv;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.cNA && b.this.hNh != null) {
                b.this.hNh.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.hNh = pbActivity;
        this.cNA = this.hNh.findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hNh.findViewById(R.id.manga_navigation_bar_title);
        this.hZv = this.hNh.findViewById(R.id.manga_browser_navigation_bar);
        this.cNA.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hZv.setVisibility(0);
    }
}
