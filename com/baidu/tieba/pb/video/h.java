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
    private BaseActivity bkU;
    private d fIC;
    private e fID;
    private com.baidu.tieba.c.d fIE;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bkU = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        aj(bdVar);
        b(bjVar, bdVar, i);
    }

    private void aj(bd bdVar) {
        if (bdVar != null) {
            if (this.fIC == null) {
                this.fIC = new d(LayoutInflater.from(this.bkU.getPageContext().getPageActivity()).inflate(d.i.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fIC.ag(bdVar);
        }
    }

    public View bhn() {
        if (this.fIC == null) {
            return null;
        }
        return this.fIC.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fID == null) {
                this.fID = new e(this.bkU, LayoutInflater.from(this.bkU.getPageContext().getPageActivity()).inflate(d.i.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.akm = i;
            this.fID.ah(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bho() {
        if (this.fID == null) {
            return null;
        }
        return this.fID.getRootView();
    }

    public void ak(bd bdVar) {
        if (this.fID != null && bdVar != null && bdVar.wm() != null && bdVar.wm().akm == 2) {
            if (this.fIE == null) {
                this.fIE = new com.baidu.tieba.c.d(this.bkU.getPageContext(), this.fID.bhk());
                this.fIE.jg(5000);
            }
            this.fIE.h(this.bkU.getResources().getString(d.k.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fID != null && j > 0) {
            this.fID.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fIC != null) {
                this.fIC.Fs();
            }
            if (this.fID != null) {
                this.fID.Fs();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fIC != null) {
            bdTypeListView.removeHeaderView(this.fIC.mRootView);
        }
        if (this.fID != null) {
            bdTypeListView.removeHeaderView(this.fID.getRootView());
        }
    }

    public void onDestroy() {
        bhp();
    }

    public void bhp() {
        if (this.fIE != null) {
            this.fIE.akT();
        }
    }
}
