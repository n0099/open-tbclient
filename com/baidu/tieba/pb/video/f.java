package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f {
    private BaseFragmentActivity iEK;
    private c lZQ;
    private int mSkinType = 3;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.iEK = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.diN() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.lZQ == null) {
                this.lZQ = new c(LayoutInflater.from(this.iEK.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.lZQ.a(fVar, str);
        }
    }

    public View drm() {
        if (this.lZQ == null) {
            return null;
        }
        return this.lZQ.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lZQ != null) {
                this.lZQ.byV();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.lZQ != null) {
            bdTypeListView.removeHeaderView(this.lZQ.mRootView);
        }
    }
}
