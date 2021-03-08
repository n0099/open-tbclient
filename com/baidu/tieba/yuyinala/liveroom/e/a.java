package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean hvT;
    private TbPageContext mTbPageContext;
    private b owq;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hvT = false;
        this.mTbPageContext = tbPageContext;
        this.owq = new b(this.mTbPageContext);
    }

    public void a(ab abVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (abVar == null || abVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.owq == null || this.owq.getView() == null || abVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hvT = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hvT = false;
        } else {
            this.owq.d(alaLastLiveroomInfo);
            this.owq.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.owq.ccI();
                }
            });
            this.owq.show();
            this.hvT = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.hvT) {
            this.owq.aH(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Au() {
        if (this.owq != null) {
            this.owq.ccK();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.owq != null) {
            this.owq.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.owq != null && this.owq.getView() != null) {
            this.owq.getView().setId(i);
        }
    }
}
