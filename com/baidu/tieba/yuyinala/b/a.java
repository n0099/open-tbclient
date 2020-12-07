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
    private String ohD;
    private AlaRankListActivity ohZ;
    private b oko;
    private com.baidu.tieba.yuyinala.view.b okp;
    private i okq;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ohZ = alaRankListActivity;
        this.ohD = str;
        bVG();
    }

    private View bVG() {
        this.okp = new com.baidu.tieba.yuyinala.view.b(this.ohZ, this.ohD);
        mE(true);
        return this.okp.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(final boolean z) {
        if (this.oko == null) {
            this.oko = new b(this.ohZ.getUniqueId());
            this.oko.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i egr = alaGetRoomRankListResponseMessage.egr();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.okq = egr;
                                a.this.okp.Yb();
                                a.this.a(a.this.okq);
                            } else if (a.this.okp != null) {
                                a.this.okp.dG(false);
                                a.this.okp.cps();
                                a.this.okp.Yb();
                                a.this.okp.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
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
                this.oko.Xf(this.ohD);
            }
        } else if (this.okp != null) {
            this.okp.Yb();
            this.okp.dG(false);
            this.okp.cps();
            this.okp.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.mE(z);
                    } else {
                        a.this.ohZ.getPageContext().showToast(a.this.ohZ.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.okp != null) {
                this.okp.cps();
                this.okp.Yb();
                this.okp.setDatas(new ArrayList<>());
                this.okp.xN(0);
                this.okp.dG(false);
                this.okp.xM(8);
                this.okp.gV(8);
                this.okp.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.mE(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.okp.Yb();
            this.okp.gV(0);
            this.okp.setDatas(new ArrayList<>());
            this.okp.xN(0);
            this.okp.dG(true);
            this.okp.xM(8);
            if (this.okp != null) {
                g gVar = new g();
                gVar.aJb = 0L;
                gVar.cover = this.ohZ.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.ohZ.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.okp.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.okp.gV(0);
            this.okp.Yb();
            if (this.okp != null) {
                this.okp.c(iVar);
                g ecT = iVar.ecT();
                ecT.by(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        ecT.aL(iVar.getList().get(i).aJg);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.okp.setDatas(new ArrayList<>());
                    this.okp.dG(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.okp.setDatas(arrayList);
                }
                this.okp.xN(0);
                this.okp.xM(0);
                if (this.okp != null) {
                    this.okp.b(ecT);
                }
                if (iVar.getList().size() < iVar.ecU()) {
                    this.okp.Xg(this.ohZ.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.okp.Xg(this.ohZ.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.okp.getView();
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
        if (this.oko != null) {
            this.oko.destory();
        }
        if (this.okp != null) {
            this.okp.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
