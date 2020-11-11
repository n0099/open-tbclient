package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean gZd;
    private TbPageContext mTbPageContext;
    private b nVb;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gZd = false;
        this.mTbPageContext = tbPageContext;
        this.nVb = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.nVb == null || this.nVb.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gZd = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gZd = false;
        } else {
            this.nVb.d(alaLastLiveroomInfo);
            this.nVb.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nVb.bZm();
                }
            });
            this.nVb.show();
            this.gZd = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        if (this.gZd) {
            this.nVb.az(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Dm() {
        if (this.nVb != null) {
            this.nVb.bZo();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nVb != null) {
            this.nVb.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.nVb != null && this.nVb.getView() != null) {
            this.nVb.getView().setId(i);
        }
    }
}
