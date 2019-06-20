package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class b {
    public final View cAO;
    private PbActivity hGq;
    public final View hSz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.cAO && b.this.hGq != null) {
                b.this.hGq.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.hGq = pbActivity;
        this.cAO = this.hGq.findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hGq.findViewById(R.id.manga_navigation_bar_title);
        this.hSz = this.hGq.findViewById(R.id.manga_browser_navigation_bar);
        this.cAO.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hSz.setVisibility(0);
    }
}
