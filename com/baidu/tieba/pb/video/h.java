package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity cmZ;
    private d fYK;
    private e fYL;
    private com.baidu.tieba.d.b fYM;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cmZ = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        ac(bdVar);
        b(bjVar, bdVar, i);
    }

    private void ac(bd bdVar) {
        if (bdVar != null) {
            if (this.fYK == null) {
                this.fYK = new d(LayoutInflater.from(this.cmZ.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fYK.Z(bdVar);
        }
    }

    public View bfN() {
        if (this.fYK == null) {
            return null;
        }
        return this.fYK.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fYL == null) {
                this.fYL = new e(this.cmZ, LayoutInflater.from(this.cmZ.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aPt = i;
            this.fYL.aa(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bfO() {
        if (this.fYL == null) {
            return null;
        }
        return this.fYL.getRootView();
    }

    public void ad(bd bdVar) {
        if (this.fYL != null && bdVar != null && bdVar.zV() != null && bdVar.zV().aPt == 2) {
            if (this.fYM == null) {
                this.fYM = new com.baidu.tieba.d.b(this.cmZ.getPageContext(), this.fYL.bfK());
                this.fYM.lW(5000);
            }
            this.fYM.g(this.cmZ.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fYL != null && j > 0) {
            this.fYL.j(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fYK != null) {
                this.fYK.Iv();
            }
            if (this.fYL != null) {
                this.fYL.Iv();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fYK != null) {
            bdTypeListView.removeHeaderView(this.fYK.mRootView);
        }
        if (this.fYL != null) {
            bdTypeListView.removeHeaderView(this.fYL.getRootView());
        }
    }

    public void onDestroy() {
        bfP();
    }

    public void bfP() {
        if (this.fYM != null) {
            this.fYM.amw();
        }
    }
}
