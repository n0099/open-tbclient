package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class g {
    private BaseFragmentActivity imj;
    private d lLj;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.imj = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dhH() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.lLj == null) {
                this.lLj = new d(LayoutInflater.from(this.imj.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.lLj.a(fVar, str);
        }
    }

    public View dpU() {
        if (this.lLj == null) {
            return null;
        }
        return this.lLj.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lLj != null) {
                this.lLj.bwU();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.lLj != null) {
            bdTypeListView.removeHeaderView(this.lLj.mRootView);
        }
    }
}
