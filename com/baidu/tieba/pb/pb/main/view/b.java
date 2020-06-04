package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View eun;
    private PbFragment jHL;
    public final View jYs;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.eun && b.this.jHL != null && b.this.jHL.getBaseFragmentActivity() != null) {
                b.this.jHL.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.jHL = pbFragment;
        this.eun = this.jHL.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.jHL.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.jYs = this.jHL.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.eun.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.jYs.setVisibility(0);
    }
}
