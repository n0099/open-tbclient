package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes16.dex */
public class b {
    public final View eUq;
    public final View kQW;
    private PbFragment kzA;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.eUq && b.this.kzA != null && b.this.kzA.getBaseFragmentActivity() != null) {
                b.this.kzA.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.kzA = pbFragment;
        this.eUq = this.kzA.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.kzA.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.kQW = this.kzA.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.eUq.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.kQW.setVisibility(0);
    }
}
