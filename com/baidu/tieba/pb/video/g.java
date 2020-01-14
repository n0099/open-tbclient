package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class g {
    private BaseFragmentActivity gpB;
    private d iVY;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.gpB = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.ciS() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.iVY == null) {
                this.iVY = new d(LayoutInflater.from(this.gpB.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.iVY.a(fVar, str);
        }
    }

    public View cqT() {
        if (this.iVY == null) {
            return null;
        }
        return this.iVY.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iVY != null) {
                this.iVY.aKd();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.iVY != null) {
            bdTypeListView.removeHeaderView(this.iVY.mRootView);
        }
    }
}
