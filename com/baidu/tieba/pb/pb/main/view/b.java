package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes2.dex */
public class b {
    public final View fOs;
    private PbFragment lIO;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fOs && b.this.lIO != null && b.this.lIO.getBaseFragmentActivity() != null) {
                b.this.lIO.getBaseFragmentActivity().finish();
            }
        }
    };
    public final TextView mTitleView;
    public final View maP;

    public b(PbFragment pbFragment) {
        this.lIO = pbFragment;
        this.fOs = this.lIO.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.lIO.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.maP = this.lIO.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.fOs.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.maP.setVisibility(0);
    }
}
