package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes22.dex */
public class b {
    public final View fxJ;
    public final View lHl;
    private PbFragment lpI;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fxJ && b.this.lpI != null && b.this.lpI.getBaseFragmentActivity() != null) {
                b.this.lpI.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.lpI = pbFragment;
        this.fxJ = this.lpI.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.lpI.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.lHl = this.lpI.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fxJ.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.lHl.setVisibility(0);
    }
}
