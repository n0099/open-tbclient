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
    private d idp;
    private e idq;
    private com.baidu.tieba.c.d idr;
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
            if (this.idp == null) {
                this.idp = new d(LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.idp.aw(bhVar);
        }
    }

    public View bXQ() {
        if (this.idp == null) {
            return null;
        }
        return this.idp.mRootView;
    }

    private void b(bn bnVar, bh bhVar, int i) {
        if (bnVar != null && bhVar != null) {
            if (this.idq == null) {
                this.idq = new e(this.mActivity, LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bnVar.cec = i;
            this.idq.ax(bhVar);
            bhVar.a(bnVar);
        }
    }

    public View bXR() {
        if (this.idq == null) {
            return null;
        }
        return this.idq.getRootView();
    }

    public void aA(bh bhVar) {
        if (this.idq != null && bhVar != null && bhVar.ajN() != null && bhVar.ajN().cec == 2) {
            if (this.idr == null) {
                this.idr = new com.baidu.tieba.c.d(this.mActivity.getPageContext(), this.idq.bXN());
                this.idr.bC(5000);
            }
            this.idr.c(this.mActivity.getResources().getString(R.string.pb_order_channel_tip), SharedPrefConfig.PB_SHOW_ORDER_CHANNEL_TIP, true);
        }
    }

    public void r(long j, int i) {
        if (this.idq != null && j > 0) {
            this.idq.u(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.idp != null) {
                this.idp.ask();
            }
            if (this.idq != null) {
                this.idq.ask();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.idp != null) {
            bdTypeListView.removeHeaderView(this.idp.mRootView);
        }
        if (this.idq != null) {
            bdTypeListView.removeHeaderView(this.idq.getRootView());
        }
    }

    public void onDestroy() {
        bXS();
    }

    public void bXS() {
        if (this.idr != null) {
            this.idr.uQ();
        }
    }
}
