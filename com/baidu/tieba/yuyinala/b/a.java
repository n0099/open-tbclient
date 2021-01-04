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
    private AlaRankListActivity ojJ;
    private String ojm;
    private b ome;
    private com.baidu.tieba.yuyinala.view.b omf;
    private i omg;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ojJ = alaRankListActivity;
        this.ojm = str;
        bYm();
    }

    private View bYm() {
        this.omf = new com.baidu.tieba.yuyinala.view.b(this.ojJ, this.ojm);
        ne(true);
        return this.omf.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(final boolean z) {
        if (this.ome == null) {
            this.ome = new b(this.ojJ.getUniqueId());
            this.ome.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i egX = alaGetRoomRankListResponseMessage.egX();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.omg = egX;
                                a.this.omf.Zi();
                                a.this.a(a.this.omg);
                            } else if (a.this.omf != null) {
                                a.this.omf.dM(false);
                                a.this.omf.csm();
                                a.this.omf.Zi();
                                a.this.omf.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.ne(true);
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
                this.ome.WR(this.ojm);
            }
        } else if (this.omf != null) {
            this.omf.Zi();
            this.omf.dM(false);
            this.omf.csm();
            this.omf.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.ne(z);
                    } else {
                        a.this.ojJ.getPageContext().showToast(a.this.ojJ.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.omf != null) {
                this.omf.csm();
                this.omf.Zi();
                this.omf.setDatas(new ArrayList<>());
                this.omf.ya(0);
                this.omf.dM(false);
                this.omf.xZ(8);
                this.omf.gW(8);
                this.omf.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ne(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.omf.Zi();
            this.omf.gW(0);
            this.omf.setDatas(new ArrayList<>());
            this.omf.ya(0);
            this.omf.dM(true);
            this.omf.xZ(8);
            if (this.omf != null) {
                g gVar = new g();
                gVar.aJz = 0L;
                gVar.cover = this.ojJ.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.ojJ.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.omf.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.omf.gW(0);
            this.omf.Zi();
            if (this.omf != null) {
                this.omf.c(iVar);
                g ebQ = iVar.ebQ();
                ebQ.bv(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        ebQ.aK(iVar.getList().get(i).aJE);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.omf.setDatas(new ArrayList<>());
                    this.omf.dM(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.omf.setDatas(arrayList);
                }
                this.omf.ya(0);
                this.omf.xZ(0);
                if (this.omf != null) {
                    this.omf.b(ebQ);
                }
                if (iVar.getList().size() < iVar.ebR()) {
                    this.omf.WT(this.ojJ.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.omf.WT(this.ojJ.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.omf.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return "交友房日榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
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
        if (this.ome != null) {
            this.ome.destory();
        }
        if (this.omf != null) {
            this.omf.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
