package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class g {
    private BaseFragmentActivity hjZ;
    private d kEN;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.hjZ = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.cKx() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.kEN == null) {
                this.kEN = new d(LayoutInflater.from(this.hjZ.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.kEN.a(fVar, str);
        }
    }

    public View cSE() {
        if (this.kEN == null) {
            return null;
        }
        return this.kEN.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kEN != null) {
                this.kEN.bgV();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.kEN != null) {
            bdTypeListView.removeHeaderView(this.kEN.mRootView);
        }
    }
}
