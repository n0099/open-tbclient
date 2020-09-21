package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes21.dex */
public class b {
    public final View eXg;
    private PbFragment kHX;
    public final View kZy;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.eXg && b.this.kHX != null && b.this.kHX.getBaseFragmentActivity() != null) {
                b.this.kHX.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.kHX = pbFragment;
        this.eXg = this.kHX.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.kHX.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.kZy = this.kHX.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.eXg.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.kZy.setVisibility(0);
    }
}
