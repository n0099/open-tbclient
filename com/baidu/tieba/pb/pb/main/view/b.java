package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes6.dex */
public class b {
    public final View dBy;
    public final View iOJ;
    private PbFragment iyA;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.dBy && b.this.iyA != null && b.this.iyA.getBaseFragmentActivity() != null) {
                b.this.iyA.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.iyA = pbFragment;
        this.dBy = this.iyA.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.iyA.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.iOJ = this.iyA.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.dBy.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.iOJ.setVisibility(0);
    }
}
