package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes9.dex */
public class b {
    public final View efZ;
    public final View jFL;
    private PbFragment jpW;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.efZ && b.this.jpW != null && b.this.jpW.getBaseFragmentActivity() != null) {
                b.this.jpW.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.jpW = pbFragment;
        this.efZ = this.jpW.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.jpW.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.jFL = this.jpW.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.efZ.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.jFL.setVisibility(0);
    }
}
