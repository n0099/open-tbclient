package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View eDr;
    private PbFragment kbv;
    public final View ksk;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.eDr && b.this.kbv != null && b.this.kbv.getBaseFragmentActivity() != null) {
                b.this.kbv.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.kbv = pbFragment;
        this.eDr = this.kbv.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.kbv.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.ksk = this.kbv.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.eDr.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.ksk.setVisibility(0);
    }
}
