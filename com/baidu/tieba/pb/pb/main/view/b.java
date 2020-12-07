package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes22.dex */
public class b {
    public final View fEN;
    private PbFragment lDG;
    public final View lVy;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fEN && b.this.lDG != null && b.this.lDG.getBaseFragmentActivity() != null) {
                b.this.lDG.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.lDG = pbFragment;
        this.fEN = this.lDG.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.lDG.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.lVy = this.lDG.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fEN.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.lVy.setVisibility(0);
    }
}
