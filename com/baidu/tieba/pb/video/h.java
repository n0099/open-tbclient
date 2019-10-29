package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h {
    private d iei;
    private e iej;
    private com.baidu.tieba.c.d iek;
    private BaseActivity mActivity;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    public void a(bn bnVar, bh bhVar, int i) {
        az(bhVar);
        b(bnVar, bhVar, i);
    }

    private void az(bh bhVar) {
        if (bhVar != null) {
            if (this.iei == null) {
                this.iei = new d(LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.iei.aw(bhVar);
        }
    }

    public View bXS() {
        if (this.iei == null) {
            return null;
        }
        return this.iei.mRootView;
    }

    private void b(bn bnVar, bh bhVar, int i) {
        if (bnVar != null && bhVar != null) {
            if (this.iej == null) {
                this.iej = new e(this.mActivity, LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bnVar.ceT = i;
            this.iej.ax(bhVar);
            bhVar.a(bnVar);
        }
    }

    public View bXT() {
        if (this.iej == null) {
            return null;
        }
        return this.iej.getRootView();
    }

    public void aA(bh bhVar) {
        if (this.iej != null && bhVar != null && bhVar.ajP() != null && bhVar.ajP().ceT == 2) {
            if (this.iek == null) {
                this.iek = new com.baidu.tieba.c.d(this.mActivity.getPageContext(), this.iej.bXP());
                this.iek.bC(5000);
            }
            this.iek.c(this.mActivity.getResources().getString(R.string.pb_order_channel_tip), SharedPrefConfig.PB_SHOW_ORDER_CHANNEL_TIP, true);
        }
    }

    public void r(long j, int i) {
        if (this.iej != null && j > 0) {
            this.iej.w(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iei != null) {
                this.iei.asm();
            }
            if (this.iej != null) {
                this.iej.asm();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.iei != null) {
            bdTypeListView.removeHeaderView(this.iei.mRootView);
        }
        if (this.iej != null) {
            bdTypeListView.removeHeaderView(this.iej.getRootView());
        }
    }

    public void onDestroy() {
        bXU();
    }

    public void bXU() {
        if (this.iek != null) {
            this.iek.uP();
        }
    }
}
