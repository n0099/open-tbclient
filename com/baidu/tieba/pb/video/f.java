package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f {
    private BaseFragmentActivity iKt;
    private int mSkinType = 3;
    private c miX;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.iKt = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dkZ() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.miX == null) {
                this.miX = new c(LayoutInflater.from(this.iKt.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.miX.a(fVar, str);
        }
    }

    public View dtA() {
        if (this.miX == null) {
            return null;
        }
        return this.miX.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.miX != null) {
                this.miX.bzn();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.miX != null) {
            bdTypeListView.removeHeaderView(this.miX.mRootView);
        }
    }
}
