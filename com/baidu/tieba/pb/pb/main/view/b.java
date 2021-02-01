package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes2.dex */
public class b {
    public final View fLW;
    private PbFragment lMX;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fLW && b.this.lMX != null && b.this.lMX.getBaseFragmentActivity() != null) {
                b.this.lMX.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;
    public final View mfm;

    public b(PbFragment pbFragment) {
        this.lMX = pbFragment;
        this.fLW = this.lMX.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.lMX.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.mfm = this.lMX.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fLW.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.mfm.setVisibility(0);
    }
}
