package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes22.dex */
public class b {
    public final View fjs;
    private PbFragment kXi;
    public final View loQ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fjs && b.this.kXi != null && b.this.kXi.getBaseFragmentActivity() != null) {
                b.this.kXi.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.kXi = pbFragment;
        this.fjs = this.kXi.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.kXi.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.loQ = this.kXi.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fjs.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.loQ.setVisibility(0);
    }
}
