package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class g {
    private BaseFragmentActivity ixe;
    private d lZj;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.ixe = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dmU() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.lZj == null) {
                this.lZj = new d(LayoutInflater.from(this.ixe.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.lZj.a(fVar, str);
        }
    }

    public View dvo() {
        if (this.lZj == null) {
            return null;
        }
        return this.lZj.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lZj != null) {
                this.lZj.bAu();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.lZj != null) {
            bdTypeListView.removeHeaderView(this.lZj.mRootView);
        }
    }
}
