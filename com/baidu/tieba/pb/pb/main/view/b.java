package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View dFK;
    private PbFragment iDY;
    public final View iTK;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.dFK && b.this.iDY != null && b.this.iDY.getBaseFragmentActivity() != null) {
                b.this.iDY.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.iDY = pbFragment;
        this.dFK = this.iDY.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.iDY.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.iTK = this.iDY.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.dFK.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.iTK.setVisibility(0);
    }
}
