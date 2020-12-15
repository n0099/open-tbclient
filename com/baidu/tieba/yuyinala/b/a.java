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
/* loaded from: classes4.dex */
public class a implements d {
    private String ohF;
    private AlaRankListActivity oib;
    private b okq;
    private com.baidu.tieba.yuyinala.view.b okr;
    private i oks;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.oib = alaRankListActivity;
        this.ohF = str;
        bVH();
    }

    private View bVH() {
        this.okr = new com.baidu.tieba.yuyinala.view.b(this.oib, this.ohF);
        mE(true);
        return this.okr.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(final boolean z) {
        if (this.okq == null) {
            this.okq = new b(this.oib.getUniqueId());
            this.okq.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i egs = alaGetRoomRankListResponseMessage.egs();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.oks = egs;
                                a.this.okr.Yb();
                                a.this.a(a.this.oks);
                            } else if (a.this.okr != null) {
                                a.this.okr.dG(false);
                                a.this.okr.cpt();
                                a.this.okr.Yb();
                                a.this.okr.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.mE(true);
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
                this.okq.Xf(this.ohF);
            }
        } else if (this.okr != null) {
            this.okr.Yb();
            this.okr.dG(false);
            this.okr.cpt();
            this.okr.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.mE(z);
                    } else {
                        a.this.oib.getPageContext().showToast(a.this.oib.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.okr != null) {
                this.okr.cpt();
                this.okr.Yb();
                this.okr.setDatas(new ArrayList<>());
                this.okr.xN(0);
                this.okr.dG(false);
                this.okr.xM(8);
                this.okr.gV(8);
                this.okr.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.mE(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.okr.Yb();
            this.okr.gV(0);
            this.okr.setDatas(new ArrayList<>());
            this.okr.xN(0);
            this.okr.dG(true);
            this.okr.xM(8);
            if (this.okr != null) {
                g gVar = new g();
                gVar.aJb = 0L;
                gVar.cover = this.oib.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.oib.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.okr.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.okr.gV(0);
            this.okr.Yb();
            if (this.okr != null) {
                this.okr.c(iVar);
                g ecU = iVar.ecU();
                ecU.by(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        ecU.aL(iVar.getList().get(i).aJg);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.okr.setDatas(new ArrayList<>());
                    this.okr.dG(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.okr.setDatas(arrayList);
                }
                this.okr.xN(0);
                this.okr.xM(0);
                if (this.okr != null) {
                    this.okr.b(ecU);
                }
                if (iVar.getList().size() < iVar.ecV()) {
                    this.okr.Xg(this.oib.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.okr.Xg(this.oib.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.okr.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return "交友房日榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        if (this.okq != null) {
            this.okq.destory();
        }
        if (this.okr != null) {
            this.okr.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
