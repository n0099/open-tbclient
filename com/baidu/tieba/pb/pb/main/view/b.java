package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes22.dex */
public class b {
    public final View frR;
    public final View lBp;
    private PbFragment ljH;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.frR && b.this.ljH != null && b.this.ljH.getBaseFragmentActivity() != null) {
                b.this.ljH.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.ljH = pbFragment;
        this.frR = this.ljH.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.ljH.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.lBp = this.ljH.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.frR.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.lBp.setVisibility(0);
    }
}
