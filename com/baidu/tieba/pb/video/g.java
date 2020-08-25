package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class g {
    private BaseFragmentActivity hwQ;
    private d kUu;
    private int mSkinType = 3;

    public g(BaseFragmentActivity baseFragmentActivity) {
        this.hwQ = baseFragmentActivity;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null && fVar.cVl() != null) {
            c(fVar, str);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, String str) {
        if (fVar != null) {
            if (this.kUu == null) {
                this.kUu = new d(LayoutInflater.from(this.hwQ.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.kUu.a(fVar, str);
        }
    }

    public View ddw() {
        if (this.kUu == null) {
            return null;
        }
        return this.kUu.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kUu != null) {
                this.kUu.bpH();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.kUu != null) {
            bdTypeListView.removeHeaderView(this.kUu.mRootView);
        }
    }
}
