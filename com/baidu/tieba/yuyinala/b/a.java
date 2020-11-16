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
    private String nSF;
    private AlaRankListActivity nTb;
    private b nVq;
    private com.baidu.tieba.yuyinala.view.b nVr;
    private i nVs;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.nTb = alaRankListActivity;
        this.nSF = str;
        bRW();
    }

    private View bRW() {
        this.nVr = new com.baidu.tieba.yuyinala.view.b(this.nTb, this.nSF);
        mj(true);
        return this.nVr.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(final boolean z) {
        if (this.nVq == null) {
            this.nVq = new b(this.nTb.getUniqueId());
            this.nVq.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i eaM = alaGetRoomRankListResponseMessage.eaM();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.nVs = eaM;
                                a.this.nVr.VB();
                                a.this.a(a.this.nVs);
                            } else if (a.this.nVr != null) {
                                a.this.nVr.ds(false);
                                a.this.nVr.cld();
                                a.this.nVr.VB();
                                a.this.nVr.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.mj(true);
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
                this.nVq.VQ(this.nSF);
            }
        } else if (this.nVr != null) {
            this.nVr.VB();
            this.nVr.ds(false);
            this.nVr.cld();
            this.nVr.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.mj(z);
                    } else {
                        a.this.nTb.getPageContext().showToast(a.this.nTb.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.nVr != null) {
                this.nVr.cld();
                this.nVr.VB();
                this.nVr.setDatas(new ArrayList<>());
                this.nVr.xh(0);
                this.nVr.ds(false);
                this.nVr.xg(8);
                this.nVr.gx(8);
                this.nVr.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.mj(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.nVr.VB();
            this.nVr.gx(0);
            this.nVr.setDatas(new ArrayList<>());
            this.nVr.xh(0);
            this.nVr.ds(true);
            this.nVr.xg(8);
            if (this.nVr != null) {
                g gVar = new g();
                gVar.aGs = 0L;
                gVar.cover = this.nTb.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.nTb.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.nVr.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.nVr.gx(0);
            this.nVr.VB();
            if (this.nVr != null) {
                this.nVr.c(iVar);
                g dXp = iVar.dXp();
                dXp.bq(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        dXp.an(iVar.getList().get(i).point);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.nVr.setDatas(new ArrayList<>());
                    this.nVr.ds(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.nVr.setDatas(arrayList);
                }
                this.nVr.xh(0);
                this.nVr.xg(0);
                if (this.nVr != null) {
                    this.nVr.b(dXp);
                }
                if (iVar.getList().size() < iVar.dXq()) {
                    this.nVr.VR(this.nTb.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.nVr.VR(this.nTb.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.nVr.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return "交友房日榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        if (this.nVq != null) {
            this.nVq.destory();
        }
        if (this.nVr != null) {
            this.nVr.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
