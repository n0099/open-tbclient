package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes2.dex */
public class b {
    public final View fJL;
    private PbFragment lEi;
    public final View lWh;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fJL && b.this.lEi != null && b.this.lEi.getBaseFragmentActivity() != null) {
                b.this.lEi.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.lEi = pbFragment;
        this.fJL = this.lEi.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.lEi.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.lWh = this.lEi.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fJL.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.lWh.setVisibility(0);
    }
}
