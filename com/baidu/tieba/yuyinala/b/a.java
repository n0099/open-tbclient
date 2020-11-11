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
    private String nRc;
    private AlaRankListActivity nRy;
    private b nTN;
    private com.baidu.tieba.yuyinala.view.b nTO;
    private i nTP;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.nRy = alaRankListActivity;
        this.nRc = str;
        bSD();
    }

    private View bSD() {
        this.nTO = new com.baidu.tieba.yuyinala.view.b(this.nRy, this.nRc);
        mi(true);
        return this.nTO.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(final boolean z) {
        if (this.nTN == null) {
            this.nTN = new b(this.nRy.getUniqueId());
            this.nTN.a(new com.baidu.tieba.yuyinala.c.d() { // from class: com.baidu.tieba.yuyinala.b.a.1
                @Override // com.baidu.tieba.yuyinala.c.d
                public void a(int i, String str, Object obj) {
                    if (obj != null && (obj instanceof AlaGetRoomRankListResponseMessage)) {
                        AlaGetRoomRankListResponseMessage alaGetRoomRankListResponseMessage = (AlaGetRoomRankListResponseMessage) obj;
                        i eaN = alaGetRoomRankListResponseMessage.eaN();
                        if (alaGetRoomRankListResponseMessage.getOrginalMessage() != null) {
                            if (i == 0 || StringUtils.isNull(str)) {
                                a.this.nTP = eaN;
                                a.this.nTO.Wk();
                                a.this.a(a.this.nTP);
                            } else if (a.this.nTO != null) {
                                a.this.nTO.dq(false);
                                a.this.nTO.clK();
                                a.this.nTO.Wk();
                                a.this.nTO.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.mi(true);
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
                this.nTN.Wf(this.nRc);
            }
        } else if (this.nTO != null) {
            this.nTO.Wk();
            this.nTO.dq(false);
            this.nTO.clK();
            this.nTO.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.mi(z);
                    } else {
                        a.this.nRy.getPageContext().showToast(a.this.nRy.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar == null) {
            if (this.nTO != null) {
                this.nTO.clK();
                this.nTO.Wk();
                this.nTO.setDatas(new ArrayList<>());
                this.nTO.wJ(0);
                this.nTO.dq(false);
                this.nTO.wI(8);
                this.nTO.gB(8);
                this.nTO.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.b.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.mi(true);
                    }
                });
            }
        } else if (iVar.getList() == null || iVar.getList().size() <= 0) {
            this.nTO.Wk();
            this.nTO.gB(0);
            this.nTO.setDatas(new ArrayList<>());
            this.nTO.wJ(0);
            this.nTO.dq(true);
            this.nTO.wI(8);
            if (this.nTO != null) {
                g gVar = new g();
                gVar.aId = 0L;
                gVar.cover = this.nRy.getIntent().getStringExtra("room_cover");
                gVar.room_name = this.nRy.getIntent().getStringExtra(DpStatConstants.KEY_ROOM_NAME);
                this.nTO.b(gVar);
            }
        } else if (iVar.getList() != null && iVar.getList().size() > 0) {
            this.nTO.gB(0);
            this.nTO.Wk();
            if (this.nTO != null) {
                this.nTO.c(iVar);
                g dXq = iVar.dXq();
                dXq.bo(iVar.getList().size() == 1);
                for (int i = 0; i < iVar.getList().size(); i++) {
                    if (iVar.getList().get(i).rank == 10) {
                        dXq.an(iVar.getList().get(i).point);
                    }
                }
                if (iVar.getList().size() == 1) {
                    this.nTO.setDatas(new ArrayList<>());
                    this.nTO.dq(false);
                } else if (iVar.getList().size() > 1) {
                    int size = iVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList.add(iVar.getList().get(i2));
                    }
                    this.nTO.setDatas(arrayList);
                }
                this.nTO.wJ(0);
                this.nTO.wI(0);
                if (this.nTO != null) {
                    this.nTO.b(dXq);
                }
                if (iVar.getList().size() < iVar.dXr()) {
                    this.nTO.Wg(this.nRy.getPageContext().getResources().getString(a.h.rank_nomore_text));
                } else {
                    this.nTO.Wg(this.nRy.getPageContext().getResources().getString(a.h.rank_ten_text));
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.nTO.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return "交友房日榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        if (this.nTN != null) {
            this.nTN.destory();
        }
        if (this.nTO != null) {
            this.nTO.release();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
