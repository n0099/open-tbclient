package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View efU;
    public final View jFH;
    private PbFragment jpS;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.efU && b.this.jpS != null && b.this.jpS.getBaseFragmentActivity() != null) {
                b.this.jpS.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.jpS = pbFragment;
        this.efU = this.jpS.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.jpS.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.jFH = this.jpS.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.efU.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.jFH.setVisibility(0);
    }
}
