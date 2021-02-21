package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes2.dex */
public class b {
    public final View fLW;
    private PbFragment lNm;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fLW && b.this.lNm != null && b.this.lNm.getBaseFragmentActivity() != null) {
                b.this.lNm.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;
    public final View mfB;

    public b(PbFragment pbFragment) {
        this.lNm = pbFragment;
        this.fLW = this.lNm.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.lNm.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.mfB = this.lNm.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fLW.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.mfB.setVisibility(0);
    }
}
