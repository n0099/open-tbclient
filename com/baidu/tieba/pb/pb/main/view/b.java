package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes16.dex */
public class b {
    public final View eUm;
    public final View kQP;
    private PbFragment kzt;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.eUm && b.this.kzt != null && b.this.kzt.getBaseFragmentActivity() != null) {
                b.this.kzt.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.kzt = pbFragment;
        this.eUm = this.kzt.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.kzt.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.kQP = this.kzt.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.eUm.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.kQP.setVisibility(0);
    }
}
