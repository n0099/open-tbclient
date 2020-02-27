package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View dFJ;
    private PbFragment iDW;
    public final View iTI;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.dFJ && b.this.iDW != null && b.this.iDW.getBaseFragmentActivity() != null) {
                b.this.iDW.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.iDW = pbFragment;
        this.dFJ = this.iDW.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.iDW.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.iTI = this.iDW.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.dFJ.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.iTI.setVisibility(0);
    }
}
