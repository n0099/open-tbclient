package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h {
    private BaseActivity cXM;
    private com.baidu.tieba.c.d ifA;
    private d ify;
    private e ifz;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cXM = baseActivity;
    }

    public void a(bn bnVar, bh bhVar, int i) {
        aB(bhVar);
        b(bnVar, bhVar, i);
    }

    private void aB(bh bhVar) {
        if (bhVar != null) {
            if (this.ify == null) {
                this.ify = new d(LayoutInflater.from(this.cXM.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.ify.ay(bhVar);
        }
    }

    public View caP() {
        if (this.ify == null) {
            return null;
        }
        return this.ify.mRootView;
    }

    private void b(bn bnVar, bh bhVar, int i) {
        if (bnVar != null && bhVar != null) {
            if (this.ifz == null) {
                this.ifz = new e(this.cXM, LayoutInflater.from(this.cXM.getPageContext().getPageActivity()).inflate(R.layout.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bnVar.bNk = i;
            this.ifz.az(bhVar);
            bhVar.a(bnVar);
        }
    }

    public View caQ() {
        if (this.ifz == null) {
            return null;
        }
        return this.ifz.getRootView();
    }

    public void aC(bh bhVar) {
        if (this.ifz != null && bhVar != null && bhVar.afM() != null && bhVar.afM().bNk == 2) {
            if (this.ifA == null) {
                this.ifA = new com.baidu.tieba.c.d(this.cXM.getPageContext(), this.ifz.caM());
                this.ifA.qg(5000);
            }
            this.ifA.v(this.cXM.getResources().getString(R.string.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void q(long j, int i) {
        if (this.ifz != null && j > 0) {
            this.ifz.w(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ify != null) {
                this.ify.aqs();
            }
            if (this.ifz != null) {
                this.ifz.aqs();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.ify != null) {
            bdTypeListView.removeHeaderView(this.ify.mRootView);
        }
        if (this.ifz != null) {
            bdTypeListView.removeHeaderView(this.ifz.getRootView());
        }
    }

    public void onDestroy() {
        caR();
    }

    public void caR() {
        if (this.ifA != null) {
            this.ifA.bcf();
        }
    }
}
