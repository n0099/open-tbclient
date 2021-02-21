package com.baidu.tieba.yuyinala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private boolean huk;
    private TbPageContext mTbPageContext;
    private b ouk;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.huk = false;
        this.mTbPageContext = tbPageContext;
        this.ouk = new b(this.mTbPageContext);
    }

    public void a(ab abVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (abVar == null || abVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.ouk == null || this.ouk.getView() == null || abVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.huk = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.huk = false;
        } else {
            this.ouk.d(alaLastLiveroomInfo);
            this.ouk.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ouk.ccC();
                }
            });
            this.ouk.show();
            this.huk = true;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.huk) {
            this.ouk.aH(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        if (this.ouk != null) {
            this.ouk.ccE();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.ouk != null) {
            this.ouk.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.ouk != null && this.ouk.getView() != null) {
            this.ouk.getView().setId(i);
        }
    }
}
