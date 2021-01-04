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
    private c mez;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.iJr = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dmE() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.mez == null) {
                this.mez = new c(LayoutInflater.from(this.iJr.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.mez.a(fVar, str);
        }
    }

    public View dvd() {
        if (this.mez == null) {
            return null;
        }
        return this.mez.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mez != null) {
                this.mez.bCO();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.mez != null) {
            bdTypeListView.removeHeaderView(this.mez.mRootView);
        }
    }
}
