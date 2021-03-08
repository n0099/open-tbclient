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
/* loaded from: classes10.dex */
public class a implements d {
    private AlaRankListActivity orD;
    private String orf;
    private b otY;
    private com.baidu.tieba.yuyinala.view.b otZ;
    private i oua;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.orD = alaRankListActivity;
        this.orf = str;
        bVx();
    }

    private View bVx() {
        this.otZ = new com.baidu.tieba.yuyinala.view.b(this.orD, this.orf);
        nf(true);
        return this.otZ.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(final boolean z) {
        if (this.otY == null) {
            this.otY = new b(this.orD.getUniqueId());
            this.otY.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i efN = alaGetRoomRankListResponseMessage.efN();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.oua = efN;
                                a.this.otZ.Xc();
                                a.this.a(a.this.oua);
                            } else if (a.this.otZ != null) {
                                a.this.otZ.dQ(false);
                                a.this.otZ.cpN();
                                a.this.otZ.Xc();
                                a.this.otZ.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
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
                this.otY.Xb(this.orf);
            }
        } else if (this.otZ != null) {
            this.otZ.Xc();
            this.otZ.dQ(false);
            this.otZ.cpN();
            this.otZ.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.nf(z);
                    } else {
                        a.this.orD.getPageContext().showToast(a.this.orD.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.otZ != null) {
                this.otZ.cpN();
                this.otZ.Xc();
                this.otZ.setDatas(new ArrayList<>());
                this.otZ.wG(0);
                this.otZ.dQ(false);
                this.otZ.wF(8);
                this.otZ.fw(8);
                this.otZ.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.nf(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.otZ.Xc();
            this.otZ.fw(0);
            this.otZ.setDatas(new ArrayList<>());
            this.otZ.wG(0);
            this.otZ.dQ(true);
            this.otZ.wF(8);
            if (this.otZ != null) {
                g gVar = new g();
                gVar.aHZ = 0L;
                gVar.cover = this.orD.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.orD.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.otZ.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.otZ.fw(0);
            this.otZ.Xc();
            if (this.otZ != null) {
                this.otZ.c(iVar);
                g eaA = iVar.eaA();
                eaA.bt(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        eaA.aM(iVar.getList().get(i).aIe);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.otZ.setDatas(new ArrayList<>());
                    this.otZ.dQ(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.otZ.setDatas(arrayList);
                }
                this.otZ.wG(0);
                this.otZ.wF(0);
                if (this.otZ != null) {
                    this.otZ.b(eaA);
                }
                if (iVar.getList().size() < iVar.eaB()) {
                    this.otZ.Xd(this.orD.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.otZ.Xd(this.orD.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.otZ.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return "交友房日榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
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
        if (this.otY != null) {
            this.otY.destory();
        }
        if (this.otZ != null) {
            this.otZ.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
