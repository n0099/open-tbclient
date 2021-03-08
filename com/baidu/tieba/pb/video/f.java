package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f {
    private BaseFragmentActivity iMq;
    private int mSkinType = 3;
    private c mlo;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.iMq = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dlp() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.mlo == null) {
                this.mlo = new c(LayoutInflater.from(this.iMq.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.mlo.a(fVar, str);
        }
    }

    public View dtQ() {
        if (this.mlo == null) {
            return null;
        }
        return this.mlo.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mlo != null) {
                this.mlo.bzq();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.mlo != null) {
            bdTypeListView.removeHeaderView(this.mlo.mRootView);
        }
    }
}
