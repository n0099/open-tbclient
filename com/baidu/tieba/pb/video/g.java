package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private BaseFragmentActivity grE;
    private d iXp;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.grE = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null && eVar.cku() != null) {
            c(eVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null) {
            if (this.iXp == null) {
                this.iXp = new d(LayoutInflater.from(this.grE.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.iXp.a(eVar, str);
        }
    }

    public View csl() {
        if (this.iXp == null) {
            return null;
        }
        return this.iXp.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iXp != null) {
                this.iXp.aMB();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.iXp != null) {
            bdTypeListView.removeHeaderView(this.iXp.mRootView);
        }
    }
}
