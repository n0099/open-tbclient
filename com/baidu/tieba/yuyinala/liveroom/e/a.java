package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean gSY;
    private TbPageContext mTbPageContext;
    private b nPd;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gSY = false;
        this.mTbPageContext = tbPageContext;
        this.nPd = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.nPd == null || this.nPd.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gSY = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gSY = false;
        } else {
            this.nPd.d(alaLastLiveroomInfo);
            this.nPd.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nPd.bWK();
                }
            });
            this.nPd.show();
            this.gSY = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void av(ViewGroup viewGroup) {
        if (this.gSY) {
            this.nPd.ax(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CT() {
        if (this.nPd != null) {
            this.nPd.bWM();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nPd != null) {
            this.nPd.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.nPd != null && this.nPd.getView() != null) {
            this.nPd.getView().setId(i);
        }
    }
}
