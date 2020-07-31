package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes16.dex */
public class b {
    public final View eJG;
    public final View kBi;
    private PbFragment kjZ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.eJG && b.this.kjZ != null && b.this.kjZ.getBaseFragmentActivity() != null) {
                b.this.kjZ.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.kjZ = pbFragment;
        this.eJG = this.kjZ.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.kjZ.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.kBi = this.kjZ.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.eJG.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.kBi.setVisibility(0);
    }
}
