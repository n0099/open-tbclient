package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes2.dex */
public class b {
    public final View fNw;
    private PbFragment lPo;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fNw && b.this.lPo != null && b.this.lPo.getBaseFragmentActivity() != null) {
                b.this.lPo.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;
    public final View mhD;

    public b(PbFragment pbFragment) {
        this.lPo = pbFragment;
        this.fNw = this.lPo.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.lPo.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.mhD = this.lPo.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fNw.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.mhD.setVisibility(0);
    }
}
