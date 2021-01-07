package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f {
    private BaseFragmentActivity iJr;
    private int mSkinType = 3;
    private c mey;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.iJr = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dmF() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.mey == null) {
                this.mey = new c(LayoutInflater.from(this.iJr.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.mey.a(fVar, str);
        }
    }

    public View dve() {
        if (this.mey == null) {
            return null;
        }
        return this.mey.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mey != null) {
                this.mey.bCP();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.mey != null) {
            bdTypeListView.removeHeaderView(this.mey.mRootView);
        }
    }
}
