package com.baidu.tieba.yuyinala.b;

import android.view.View;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.c.b;
import com.baidu.tieba.yuyinala.data.c;
import com.baidu.tieba.yuyinala.data.g;
import com.baidu.tieba.yuyinala.data.i;
import com.baidu.tieba.yuyinala.message.AlaGetRoomRankListResponseMessage;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a implements d {
    private AlaRankListActivity ooW;
    private String ooz;
    private b ort;
    private com.baidu.tieba.yuyinala.view.b oru;
    private i orv;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ooW = alaRankListActivity;
        this.ooz = str;
        bVk();
    }

    private View bVk() {
        this.oru = new com.baidu.tieba.yuyinala.view.b(this.ooW, this.ooz);
        nf(true);
        return this.oru.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(final boolean z) {
        if (this.ort == null) {
            this.ort = new b(this.ooW.getUniqueId());
            this.ort.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i efx = alaGetRoomRankListResponseMessage.efx();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.orv = efx;
                                a.this.oru.WZ();
                                a.this.a(a.this.orv);
                            } else if (a.this.oru != null) {
                                a.this.oru.dQ(false);
                                a.this.oru.cpA();
                                a.this.oru.WZ();
                                a.this.oru.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.nf(true);
                                    }
                                });
                            }
                        }
                    }
                }
            });
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (z) {
                this.ort.WI(this.ooz);
            }
        } else if (this.oru != null) {
            this.oru.WZ();
            this.oru.dQ(false);
            this.oru.cpA();
            this.oru.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.nf(z);
                    } else {
                        a.this.ooW.getPageContext().showToast(a.this.ooW.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.oru != null) {
                this.oru.cpA();
                this.oru.WZ();
                this.oru.setDatas(new ArrayList<>());
                this.oru.wF(0);
                this.oru.dQ(false);
                this.oru.wE(8);
                this.oru.fv(8);
                this.oru.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.nf(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.oru.WZ();
            this.oru.fv(0);
            this.oru.setDatas(new ArrayList<>());
            this.oru.wF(0);
            this.oru.dQ(true);
            this.oru.wE(8);
            if (this.oru != null) {
                g gVar = new g();
                gVar.aGz = 0L;
                gVar.cover = this.ooW.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.ooW.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.oru.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.oru.fv(0);
            this.oru.WZ();
            if (this.oru != null) {
                this.oru.c(iVar);
                g eak = iVar.eak();
                eak.bt(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        eak.aM(iVar.getList().get(i).aGE);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.oru.setDatas(new ArrayList<>());
                    this.oru.dQ(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.oru.setDatas(arrayList);
                }
                this.oru.wF(0);
                this.oru.wE(0);
                if (this.oru != null) {
                    this.oru.b(eak);
                }
                if (iVar.getList().size() < iVar.eal()) {
                    this.oru.WK(this.ooW.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.oru.WK(this.ooW.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.oru.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return "交友房日榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.ort != null) {
            this.ort.destory();
        }
        if (this.oru != null) {
            this.oru.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
