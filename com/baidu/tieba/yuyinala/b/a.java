package com.baidu.tieba.yuyinala.b;

import android.view.View;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.data.c;
import com.baidu.tieba.yuyinala.data.g;
import com.baidu.tieba.yuyinala.data.i;
import com.baidu.tieba.yuyinala.message.AlaGetRoomRankListResponseMessage;
import com.baidu.tieba.yuyinala.view.b;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a implements d {
    private String oeG;
    private AlaRankListActivity ofd;
    private b ohA;
    private i ohB;
    private com.baidu.tieba.yuyinala.c.b ohz;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ofd = alaRankListActivity;
        this.oeG = str;
        bUv();
    }

    private View bUv() {
        this.ohA = new b(this.ofd, this.oeG);
        na(true);
        return this.ohA.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.ohz == null) {
            this.ohz = new com.baidu.tieba.yuyinala.c.b(this.ofd.getUniqueId());
            this.ohz.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i edg = alaGetRoomRankListResponseMessage.edg();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.ohB = edg;
                                a.this.ohA.Vq();
                                a.this.a(a.this.ohB);
                            } else if (a.this.ohA != null) {
                                a.this.ohA.dI(false);
                                a.this.ohA.cov();
                                a.this.ohA.Vq();
                                a.this.ohA.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
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
                this.ohz.VJ(this.oeG);
            }
        } else if (this.ohA != null) {
            this.ohA.Vq();
            this.ohA.dI(false);
            this.ohA.cov();
            this.ohA.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.na(z);
                    } else {
                        a.this.ofd.getPageContext().showToast(a.this.ofd.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.ohA != null) {
                this.ohA.cov();
                this.ohA.Vq();
                this.ohA.setDatas(new ArrayList<>());
                this.ohA.wu(0);
                this.ohA.dI(false);
                this.ohA.wt(8);
                this.ohA.fp(8);
                this.ohA.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.na(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.ohA.Vq();
            this.ohA.fp(0);
            this.ohA.setDatas(new ArrayList<>());
            this.ohA.wu(0);
            this.ohA.dI(true);
            this.ohA.wt(8);
            if (this.ohA != null) {
                g gVar = new g();
                gVar.aEM = 0L;
                gVar.cover = this.ofd.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.ofd.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.ohA.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.ohA.fp(0);
            this.ohA.Vq();
            if (this.ohA != null) {
                this.ohA.c(iVar);
                g dXZ = iVar.dXZ();
                dXZ.br(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        dXZ.aK(iVar.getList().get(i).aER);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.ohA.setDatas(new ArrayList<>());
                    this.ohA.dI(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.ohA.setDatas(arrayList);
                }
                this.ohA.wu(0);
                this.ohA.wt(0);
                if (this.ohA != null) {
                    this.ohA.b(dXZ);
                }
                if (iVar.getList().size() < iVar.dYa()) {
                    this.ohA.VL(this.ofd.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.ohA.VL(this.ofd.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.ohA.getView();
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
        if (this.ohz != null) {
            this.ohz.destory();
        }
        if (this.ohA != null) {
            this.ohA.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
