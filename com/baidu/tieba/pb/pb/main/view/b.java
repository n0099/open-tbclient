package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View dGn;
    private PbFragment iFL;
    public final View iVx;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.dGn && b.this.iFL != null && b.this.iFL.getBaseFragmentActivity() != null) {
                b.this.iFL.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.iFL = pbFragment;
        this.dGn = this.iFL.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.iFL.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.iVx = this.iFL.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.dGn.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.iVx.setVisibility(0);
    }
}
