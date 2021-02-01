package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean htW;
    private TbPageContext mTbPageContext;
    private b otK;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.htW = false;
        this.mTbPageContext = tbPageContext;
        this.otK = new b(this.mTbPageContext);
    }

    public void a(ab abVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (abVar == null || abVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.otK == null || this.otK.getView() == null || abVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.htW = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.htW = false;
        } else {
            this.otK.d(alaLastLiveroomInfo);
            this.otK.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.otK.ccv();
                }
            });
            this.otK.show();
            this.htW = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.htW) {
            this.otK.aH(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        if (this.otK != null) {
            this.otK.ccx();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.otK != null) {
            this.otK.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.otK != null && this.otK.getView() != null) {
            this.otK.getView().setId(i);
        }
    }
}
