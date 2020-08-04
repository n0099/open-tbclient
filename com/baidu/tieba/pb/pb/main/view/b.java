package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes16.dex */
public class b {
    public final View eJG;
    public final View kBk;
    private PbFragment kkb;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.eJG && b.this.kkb != null && b.this.kkb.getBaseFragmentActivity() != null) {
                b.this.kkb.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbFragment pbFragment) {
        this.kkb = pbFragment;
        this.eJG = this.kkb.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.kkb.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.kBk = this.kkb.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.eJG.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.kBk.setVisibility(0);
    }
}
