package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class g {
    private BaseFragmentActivity ilu;
    private d lKR;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.ilu = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dik() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.lKR == null) {
                this.lKR = new d(LayoutInflater.from(this.ilu.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.lKR.a(fVar, str);
        }
    }

    public View dqu() {
        if (this.lKR == null) {
            return null;
        }
        return this.lKR.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lKR != null) {
                this.lKR.bxE();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.lKR != null) {
            bdTypeListView.removeHeaderView(this.lKR.mRootView);
        }
    }
}
