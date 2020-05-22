package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private BaseFragmentActivity gRv;
    private d kaZ;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.gRv = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null && eVar.cCi() != null) {
            c(eVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null) {
            if (this.kaZ == null) {
                this.kaZ = new d(LayoutInflater.from(this.gRv.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.kaZ.a(eVar, str);
        }
    }

    public View cKj() {
        if (this.kaZ == null) {
            return null;
        }
        return this.kaZ.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kaZ != null) {
                this.kaZ.bbl();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.kaZ != null) {
            bdTypeListView.removeHeaderView(this.kaZ.mRootView);
        }
    }
}
