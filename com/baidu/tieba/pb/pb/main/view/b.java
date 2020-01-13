package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes7.dex */
public class b {
    public final View dBI;
    private PbFragment iCe;
    public final View iSn;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.dBI && b.this.iCe != null && b.this.iCe.getBaseFragmentActivity() != null) {
                b.this.iCe.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.iCe = pbFragment;
        this.dBI = this.iCe.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.iCe.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.iSn = this.iCe.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.dBI.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.iSn.setVisibility(0);
    }
}
