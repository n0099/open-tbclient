package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean hur;
    private TbPageContext mTbPageContext;
    private b ooy;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hur = false;
        this.mTbPageContext = tbPageContext;
        this.ooy = new b(this.mTbPageContext);
    }

    public void a(x xVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (xVar == null || xVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.ooy == null || this.ooy.getView() == null || xVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hur = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hur = false;
        } else {
            this.ooy.d(alaLastLiveroomInfo);
            this.ooy.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ooy.cfr();
                }
            });
            this.ooy.show();
            this.hur = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.hur) {
            this.ooy.aH(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        if (this.ooy != null) {
            this.ooy.cft();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.ooy != null) {
            this.ooy.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.ooy != null && this.ooy.getView() != null) {
            this.ooy.getView().setId(i);
        }
    }
}
