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
    private b oox;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hur = false;
        this.mTbPageContext = tbPageContext;
        this.oox = new b(this.mTbPageContext);
    }

    public void a(x xVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (xVar == null || xVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.oox == null || this.oox.getView() == null || xVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hur = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hur = false;
        } else {
            this.oox.d(alaLastLiveroomInfo);
            this.oox.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.oox.cfs();
                }
            });
            this.oox.show();
            this.hur = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.hur) {
            this.oox.aH(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        if (this.oox != null) {
            this.oox.cfu();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oox != null) {
            this.oox.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.oox != null && this.oox.getView() != null) {
            this.oox.getView().setId(i);
        }
    }
}
