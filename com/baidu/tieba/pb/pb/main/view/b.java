package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View eun;
    private PbFragment jGF;
    public final View jXm;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.eun && b.this.jGF != null && b.this.jGF.getBaseFragmentActivity() != null) {
                b.this.jGF.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.jGF = pbFragment;
        this.eun = this.jGF.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.jGF.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.jXm = this.jGF.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.eun.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.jXm.setVisibility(0);
    }
}
