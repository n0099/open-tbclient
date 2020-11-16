package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes21.dex */
public class b {
    public final View fwY;
    public final View lHD;
    private PbFragment lpX;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fwY && b.this.lpX != null && b.this.lpX.getBaseFragmentActivity() != null) {
                b.this.lpX.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.lpX = pbFragment;
        this.fwY = this.lpX.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.lpX.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.lHD = this.lpX.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fwY.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.lHD.setVisibility(0);
    }
}
