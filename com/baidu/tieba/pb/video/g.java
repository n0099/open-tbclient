package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private BaseFragmentActivity grR;
    private d iXB;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.grR = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null && eVar.ckv() != null) {
            c(eVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null) {
            if (this.iXB == null) {
                this.iXB = new d(LayoutInflater.from(this.grR.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.iXB.a(eVar, str);
        }
    }

    public View csm() {
        if (this.iXB == null) {
            return null;
        }
        return this.iXB.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iXB != null) {
                this.iXB.aMC();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.iXB != null) {
            bdTypeListView.removeHeaderView(this.iXB.mRootView);
        }
    }
}
