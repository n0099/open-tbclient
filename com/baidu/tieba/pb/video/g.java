package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private BaseFragmentActivity grC;
    private d iXn;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.grC = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null && eVar.cks() != null) {
            c(eVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null) {
            if (this.iXn == null) {
                this.iXn = new d(LayoutInflater.from(this.grC.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.iXn.a(eVar, str);
        }
    }

    public View csj() {
        if (this.iXn == null) {
            return null;
        }
        return this.iXn.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iXn != null) {
                this.iXn.aMz();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.iXn != null) {
            bdTypeListView.removeHeaderView(this.iXn.mRootView);
        }
    }
}
