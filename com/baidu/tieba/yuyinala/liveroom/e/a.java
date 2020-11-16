package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean gYK;
    private TbPageContext mTbPageContext;
    private b nWE;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gYK = false;
        this.mTbPageContext = tbPageContext;
        this.nWE = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.nWE == null || this.nWE.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gYK = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gYK = false;
        } else {
            this.nWE.d(alaLastLiveroomInfo);
            this.nWE.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nWE.bYF();
                }
            });
            this.nWE.show();
            this.gYK = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        if (this.gYK) {
            this.nWE.av(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CD() {
        if (this.nWE != null) {
            this.nWE.bYH();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nWE != null) {
            this.nWE.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.nWE != null && this.nWE.getView() != null) {
            this.nWE.getView().setId(i);
        }
    }
}
