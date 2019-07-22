package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class b {
    public final View cCf;
    private PbActivity hMD;
    public final View hYM;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.cCf && b.this.hMD != null) {
                b.this.hMD.finish();
            }
        }
    };
    public final TextView mTitleView;

    public b(PbActivity pbActivity) {
        this.hMD = pbActivity;
        this.cCf = this.hMD.findViewById(R.id.manga_navigation_bar_back);
        this.mTitleView = (TextView) this.hMD.findViewById(R.id.manga_navigation_bar_title);
        this.hYM = this.hMD.findViewById(R.id.manga_browser_navigation_bar);
        this.cCf.setOnClickListener(this.mClickListener);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void show() {
        this.hYM.setVisibility(0);
    }
}
