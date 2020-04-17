package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private BaseFragmentActivity gCG;
    private d jJk;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.gCG = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null && eVar.cvu() != null) {
            c(eVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null) {
            if (this.jJk == null) {
                this.jJk = new d(LayoutInflater.from(this.gCG.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.jJk.a(eVar, str);
        }
    }

    public View cDn() {
        if (this.jJk == null) {
            return null;
        }
        return this.jJk.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jJk != null) {
                this.jJk.aVd();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.jJk != null) {
            bdTypeListView.removeHeaderView(this.jJk.mRootView);
        }
    }
}
