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
    private String ooZ;
    private AlaRankListActivity opx;
    private b orT;
    private com.baidu.tieba.yuyinala.view.b orU;
    private i orV;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.opx = alaRankListActivity;
        this.ooZ = str;
        bVr();
    }

    private View bVr() {
        this.orU = new com.baidu.tieba.yuyinala.view.b(this.opx, this.ooZ);
        nf(true);
        return this.orU.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(final boolean z) {
        if (this.orT == null) {
            this.orT = new b(this.opx.getUniqueId());
            this.orT.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i efF = alaGetRoomRankListResponseMessage.efF();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.orV = efF;
                                a.this.orU.WZ();
                                a.this.a(a.this.orV);
                            } else if (a.this.orU != null) {
                                a.this.orU.dQ(false);
                                a.this.orU.cpH();
                                a.this.orU.WZ();
                                a.this.orU.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
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
                this.orT.WU(this.ooZ);
            }
        } else if (this.orU != null) {
            this.orU.WZ();
            this.orU.dQ(false);
            this.orU.cpH();
            this.orU.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.nf(z);
                    } else {
                        a.this.opx.getPageContext().showToast(a.this.opx.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.orU != null) {
                this.orU.cpH();
                this.orU.WZ();
                this.orU.setDatas(new ArrayList<>());
                this.orU.wF(0);
                this.orU.dQ(false);
                this.orU.wE(8);
                this.orU.fv(8);
                this.orU.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.nf(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.orU.WZ();
            this.orU.fv(0);
            this.orU.setDatas(new ArrayList<>());
            this.orU.wF(0);
            this.orU.dQ(true);
            this.orU.wE(8);
            if (this.orU != null) {
                g gVar = new g();
                gVar.aGz = 0L;
                gVar.cover = this.opx.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.opx.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.orU.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.orU.fv(0);
            this.orU.WZ();
            if (this.orU != null) {
                this.orU.c(iVar);
                g eas = iVar.eas();
                eas.bt(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        eas.aM(iVar.getList().get(i).aGE);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.orU.setDatas(new ArrayList<>());
                    this.orU.dQ(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.orU.setDatas(arrayList);
                }
                this.orU.wF(0);
                this.orU.wE(0);
                if (this.orU != null) {
                    this.orU.b(eas);
                }
                if (iVar.getList().size() < iVar.eat()) {
                    this.orU.WW(this.opx.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.orU.WW(this.opx.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.orU.getView();
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
        if (this.orT != null) {
            this.orT.destory();
        }
        if (this.orU != null) {
            this.orU.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
