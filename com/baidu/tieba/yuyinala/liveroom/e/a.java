package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean hpL;
    private TbPageContext mTbPageContext;
    private b ojS;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hpL = false;
        this.mTbPageContext = tbPageContext;
        this.ojS = new b(this.mTbPageContext);
    }

    public void a(x xVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (xVar == null || xVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.ojS == null || this.ojS.getView() == null || xVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hpL = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hpL = false;
        } else {
            this.ojS.d(alaLastLiveroomInfo);
            this.ojS.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ojS.cbA();
                }
            });
            this.ojS.show();
            this.hpL = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.hpL) {
            this.ojS.aH(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        if (this.ojS != null) {
            this.ojS.cbC();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.ojS != null) {
            this.ojS.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.ojS != null && this.ojS.getView() != null) {
            this.ojS.getView().setId(i);
        }
    }
}
