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
    private AlaRankListActivity ojI;
    private String ojl;
    private b omd;
    private com.baidu.tieba.yuyinala.view.b ome;
    private i omf;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ojI = alaRankListActivity;
        this.ojl = str;
        bYn();
    }

    private View bYn() {
        this.ome = new com.baidu.tieba.yuyinala.view.b(this.ojI, this.ojl);
        ne(true);
        return this.ome.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(final boolean z) {
        if (this.omd == null) {
            this.omd = new b(this.ojI.getUniqueId());
            this.omd.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i egY = alaGetRoomRankListResponseMessage.egY();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.omf = egY;
                                a.this.ome.Zj();
                                a.this.a(a.this.omf);
                            } else if (a.this.ome != null) {
                                a.this.ome.dM(false);
                                a.this.ome.csn();
                                a.this.ome.Zj();
                                a.this.ome.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
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
                this.omd.WQ(this.ojl);
            }
        } else if (this.ome != null) {
            this.ome.Zj();
            this.ome.dM(false);
            this.ome.csn();
            this.ome.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.ne(z);
                    } else {
                        a.this.ojI.getPageContext().showToast(a.this.ojI.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.ome != null) {
                this.ome.csn();
                this.ome.Zj();
                this.ome.setDatas(new ArrayList<>());
                this.ome.ya(0);
                this.ome.dM(false);
                this.ome.xZ(8);
                this.ome.gW(8);
                this.ome.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ne(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.ome.Zj();
            this.ome.gW(0);
            this.ome.setDatas(new ArrayList<>());
            this.ome.ya(0);
            this.ome.dM(true);
            this.ome.xZ(8);
            if (this.ome != null) {
                g gVar = new g();
                gVar.aJz = 0L;
                gVar.cover = this.ojI.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.ojI.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.ome.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.ome.gW(0);
            this.ome.Zj();
            if (this.ome != null) {
                this.ome.c(iVar);
                g ebR = iVar.ebR();
                ebR.bv(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        ebR.aK(iVar.getList().get(i).aJE);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.ome.setDatas(new ArrayList<>());
                    this.ome.dM(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.ome.setDatas(arrayList);
                }
                this.ome.ya(0);
                this.ome.xZ(0);
                if (this.ome != null) {
                    this.ome.b(ebR);
                }
                if (iVar.getList().size() < iVar.ebS()) {
                    this.ome.WS(this.ojI.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.ome.WS(this.ojI.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.ome.getView();
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
        if (this.omd != null) {
            this.omd.destory();
        }
        if (this.ome != null) {
            this.ome.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
