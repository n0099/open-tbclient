package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f {
    private BaseFragmentActivity iKH;
    private int mSkinType = 3;
    private c mjm;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.iKH = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.dlg() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.mjm == null) {
                this.mjm = new c(LayoutInflater.from(this.iKH.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.mjm.a(fVar, str);
        }
    }

    public View dtH() {
        if (this.mjm == null) {
            return null;
        }
        return this.mjm.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mjm != null) {
                this.mjm.bzn();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.mjm != null) {
            bdTypeListView.removeHeaderView(this.mjm.mRootView);
        }
    }
}
