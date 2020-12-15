package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean hiv;
    private TbPageContext mTbPageContext;
    private b olE;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hiv = false;
        this.mTbPageContext = tbPageContext;
        this.olE = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.olE == null || this.olE.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hiv = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hiv = false;
        } else {
            this.olE.d(alaLastLiveroomInfo);
            this.olE.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.olE.ccB();
                }
            });
            this.olE.show();
            this.hiv = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        if (this.hiv) {
            this.olE.av(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void En() {
        if (this.olE != null) {
            this.olE.ccD();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.olE != null) {
            this.olE.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.olE != null && this.olE.getView() != null) {
            this.olE.getView().setId(i);
        }
    }
}
