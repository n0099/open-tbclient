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
    private String oeF;
    private AlaRankListActivity ofc;
    private i ohA;
    private b ohy;
    private com.baidu.tieba.yuyinala.view.b ohz;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ofc = alaRankListActivity;
        this.oeF = str;
        bUv();
    }

    private View bUv() {
        this.ohz = new com.baidu.tieba.yuyinala.view.b(this.ofc, this.oeF);
        na(true);
        return this.ohz.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.ohy == null) {
            this.ohy = new b(this.ofc.getUniqueId());
            this.ohy.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i edg = alaGetRoomRankListResponseMessage.edg();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.ohA = edg;
                                a.this.ohz.Vq();
                                a.this.a(a.this.ohA);
                            } else if (a.this.ohz != null) {
                                a.this.ohz.dI(false);
                                a.this.ohz.cov();
                                a.this.ohz.Vq();
                                a.this.ohz.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.na(true);
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
                this.ohy.VI(this.oeF);
            }
        } else if (this.ohz != null) {
            this.ohz.Vq();
            this.ohz.dI(false);
            this.ohz.cov();
            this.ohz.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.na(z);
                    } else {
                        a.this.ofc.getPageContext().showToast(a.this.ofc.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.ohz != null) {
                this.ohz.cov();
                this.ohz.Vq();
                this.ohz.setDatas(new ArrayList<>());
                this.ohz.wu(0);
                this.ohz.dI(false);
                this.ohz.wt(8);
                this.ohz.fp(8);
                this.ohz.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.na(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.ohz.Vq();
            this.ohz.fp(0);
            this.ohz.setDatas(new ArrayList<>());
            this.ohz.wu(0);
            this.ohz.dI(true);
            this.ohz.wt(8);
            if (this.ohz != null) {
                g gVar = new g();
                gVar.aEM = 0L;
                gVar.cover = this.ofc.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.ofc.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.ohz.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.ohz.fp(0);
            this.ohz.Vq();
            if (this.ohz != null) {
                this.ohz.c(iVar);
                g dXZ = iVar.dXZ();
                dXZ.br(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        dXZ.aK(iVar.getList().get(i).aER);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.ohz.setDatas(new ArrayList<>());
                    this.ohz.dI(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.ohz.setDatas(arrayList);
                }
                this.ohz.wu(0);
                this.ohz.wt(0);
                if (this.ohz != null) {
                    this.ohz.b(dXZ);
                }
                if (iVar.getList().size() < iVar.dYa()) {
                    this.ohz.VK(this.ofc.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.ohz.VK(this.ofc.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.ohz.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return "交友房日榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        if (this.ohy != null) {
            this.ohy.destory();
        }
        if (this.ohz != null) {
            this.ohz.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
