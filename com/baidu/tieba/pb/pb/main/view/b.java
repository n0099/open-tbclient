package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View dFX;
    private PbFragment iEk;
    public final View iTW;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.dFX && b.this.iEk != null && b.this.iEk.getBaseFragmentActivity() != null) {
                b.this.iEk.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.iEk = pbFragment;
        this.dFX = this.iEk.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.iEk.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.iTW = this.iEk.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.dFX.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.iTW.setVisibility(0);
    }
}
