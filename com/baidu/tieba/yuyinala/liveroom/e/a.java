package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean hit;
    private TbPageContext mTbPageContext;
    private b olC;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hit = false;
        this.mTbPageContext = tbPageContext;
        this.olC = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.olC == null || this.olC.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hit = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hit = false;
        } else {
            this.olC.d(alaLastLiveroomInfo);
            this.olC.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.olC.ccA();
                }
            });
            this.olC.show();
            this.hit = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        if (this.hit) {
            this.olC.av(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void En() {
        if (this.olC != null) {
            this.olC.ccC();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.olC != null) {
            this.olC.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.olC != null && this.olC.getView() != null) {
            this.olC.getView().setId(i);
        }
    }
}
