package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class g {
    private BaseFragmentActivity ixc;
    private d lZh;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.ixc = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dmT() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.lZh == null) {
                this.lZh = new d(LayoutInflater.from(this.ixc.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.lZh.a(fVar, str);
        }
    }

    public View dvn() {
        if (this.lZh == null) {
            return null;
        }
        return this.lZh.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lZh != null) {
                this.lZh.bAu();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.lZh != null) {
            bdTypeListView.removeHeaderView(this.lZh.mRootView);
        }
    }
}
