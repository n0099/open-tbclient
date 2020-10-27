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
    private AlaRankListActivity nLE;
    private String nLi;
    private b nNR;
    private com.baidu.tieba.yuyinala.view.b nNS;
    private i nNT;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.nLE = alaRankListActivity;
        this.nLi = str;
        bQd();
    }

    private View bQd() {
        this.nNS = new com.baidu.tieba.yuyinala.view.b(this.nLE, this.nLi);
        lZ(true);
        return this.nNS.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(final boolean z) {
        if (this.nNR == null) {
            this.nNR = new b(this.nLE.getUniqueId());
            this.nNR.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i dXh = alaGetRoomRankListResponseMessage.dXh();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.nNT = dXh;
                                a.this.nNS.TK();
                                a.this.a(a.this.nNT);
                            } else if (a.this.nNS != null) {
                                a.this.nNS.dj(false);
                                a.this.nNS.cji();
                                a.this.nNS.TK();
                                a.this.nNS.l(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.lZ(true);
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
                this.nNR.VC(this.nLi);
            }
        } else if (this.nNS != null) {
            this.nNS.TK();
            this.nNS.dj(false);
            this.nNS.cji();
            this.nNS.l(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.lZ(z);
                    } else {
                        a.this.nLE.getPageContext().showToast(a.this.nLE.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.nNS != null) {
                this.nNS.cji();
                this.nNS.TK();
                this.nNS.setDatas(new ArrayList<>());
                this.nNS.ww(0);
                this.nNS.dj(false);
                this.nNS.wv(8);
                this.nNS.gr(8);
                this.nNS.l(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.lZ(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.nNS.TK();
            this.nNS.gr(0);
            this.nNS.setDatas(new ArrayList<>());
            this.nNS.ww(0);
            this.nNS.dj(true);
            this.nNS.wv(8);
            if (this.nNS != null) {
                g gVar = new g();
                gVar.aHm = 0L;
                gVar.cover = this.nLE.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.nLE.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.nNS.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.nNS.gr(0);
            this.nNS.TK();
            if (this.nNS != null) {
                this.nNS.c(iVar);
                g dUQ = iVar.dUQ();
                dUQ.bn(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        dUQ.ab(iVar.getList().get(i).point);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.nNS.setDatas(new ArrayList<>());
                    this.nNS.dj(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.nNS.setDatas(arrayList);
                }
                this.nNS.ww(0);
                this.nNS.wv(0);
                if (this.nNS != null) {
                    this.nNS.b(dUQ);
                }
                if (iVar.getList().size() < iVar.dUR()) {
                    this.nNS.VD(this.nLE.getPageContext().getResources().getString(a.i.rank_nomore_text));
                } else {
                    this.nNS.VD(this.nLE.getPageContext().getResources().getString(a.i.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.nNS.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return "交友房日榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        if (this.nNR != null) {
            this.nNR.destory();
        }
        if (this.nNS != null) {
            this.nNS.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
