package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private BaseFragmentActivity hep;
    private d kvS;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.hep = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null && eVar.cGO() != null) {
            c(eVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null) {
            if (this.kvS == null) {
                this.kvS = new d(LayoutInflater.from(this.hep.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.kvS.a(eVar, str);
        }
    }

    public View cOR() {
        if (this.kvS == null) {
            return null;
        }
        return this.kvS.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kvS != null) {
                this.kvS.bdo();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.kvS != null) {
            bdTypeListView.removeHeaderView(this.kvS.mRootView);
        }
    }
}
