package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class g {
    private BaseFragmentActivity hEa;
    private d ldf;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.hEa = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.cYR() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.ldf == null) {
                this.ldf = new d(LayoutInflater.from(this.hEa.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.ldf.a(fVar, str);
        }
    }

    public View dhb() {
        if (this.ldf == null) {
            return null;
        }
        return this.ldf.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ldf != null) {
                this.ldf.bqC();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.ldf != null) {
            bdTypeListView.removeHeaderView(this.ldf.mRootView);
        }
    }
}
