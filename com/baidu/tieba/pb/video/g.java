package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class g {
    private BaseFragmentActivity ifx;
    private d lEV;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.ifx = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dfI() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.lEV == null) {
                this.lEV = new d(LayoutInflater.from(this.ifx.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.lEV.a(fVar, str);
        }
    }

    public View dnS() {
        if (this.lEV == null) {
            return null;
        }
        return this.lEV.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lEV != null) {
                this.lEV.bvf();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.lEV != null) {
            bdTypeListView.removeHeaderView(this.lEV.mRootView);
        }
    }
}
