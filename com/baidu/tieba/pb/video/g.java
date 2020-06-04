package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private BaseFragmentActivity gRG;
    private d kcf;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.gRG = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null && eVar.cCy() != null) {
            c(eVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.e eVar, String str) {
        if (eVar != null) {
            if (this.kcf == null) {
                this.kcf = new d(LayoutInflater.from(this.gRG.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.kcf.a(eVar, str);
        }
    }

    public View cKz() {
        if (this.kcf == null) {
            return null;
        }
        return this.kcf.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kcf != null) {
                this.kcf.bbm();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.kcf != null) {
            bdTypeListView.removeHeaderView(this.kcf.mRootView);
        }
    }
}
