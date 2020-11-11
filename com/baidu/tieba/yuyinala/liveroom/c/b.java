package com.baidu.tieba.yuyinala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.bo;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.s.e;
import com.baidu.live.s.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    private bo gXn;
    private boolean gXx;
    private short gYq = 0;
    private com.baidu.live.liveroom.f.a gYr;
    private com.baidu.live.liveroom.a.c gYs;
    private AlaLastLiveroomInfo gaY;
    private com.baidu.tieba.yuyinala.liveroom.data.a nUo;
    private String otherParams;

    public void e(short s) {
        if (this.gYr != null && (this.gYr instanceof a)) {
            this.gYr.ch(true);
            this.gYr = null;
        }
        if (this.gYr == null) {
            this.gYr = com.baidu.live.liveroom.f.c.NY().NZ().c(s);
            if (this.gYr != null) {
                this.gYr.setActivity(this.nUo.pageContext.getPageActivity());
                this.gYr.a(this.gYs);
                this.gYr.b(this.nUo.nVt);
                if (this.nUo.nVt.getParent() != null && (this.nUo.nVt.getParent() instanceof ViewGroup)) {
                    this.gYr.p((ViewGroup) this.nUo.nVt.getParent());
                }
                this.gYr.a(this.nUo.hgC, this.nUo.bnJ);
                this.gYq = (short) 0;
                this.nUo.hgI = false;
                this.gYr.init();
                return;
            }
            return;
        }
        this.gYr.b(this.nUo.nVt);
        if (this.nUo.nVt.getParent() != null && (this.nUo.nVt.getParent() instanceof ViewGroup)) {
            this.gYr.p((ViewGroup) this.nUo.nVt.getParent());
        }
        this.gYr.a(this.nUo.hgC, this.nUo.bnJ);
    }

    public void dXy() {
        if (this.gYr != null && !(this.gYr instanceof c)) {
            this.gYr.ch(true);
            this.gYr = null;
        }
        if (this.gYr == null) {
            c cVar = new c();
            this.gYq = (short) 0;
            cVar.a(this.nUo);
            cVar.a(this.gYs);
            cVar.setActivity(this.nUo.pageContext.getPageActivity());
            this.nUo.hgI = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.gYr = cVar;
        }
        a aVar = (a) this.gYr;
        aVar.bXP();
        aVar.mM(this.gXx);
        aVar.a(this.gXn);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.i.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bo boVar) {
        if (this.nUo == null) {
            this.nUo = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.nUo.pageContext = tbPageContext;
        this.nUo.nVt = alaLiveView;
        this.nUo.bnJ = fVar;
        this.nUo.hgC = eVar;
        this.nUo.nVs = aVar;
        this.nUo.fromType = str;
        this.nUo.enterTime = j;
        this.nUo.hgG = z;
        this.nUo.hgJ = arrayList;
        this.nUo.hgK = false;
        this.gXn = boVar;
    }

    public void mM(boolean z) {
        this.gXx = z;
        if (this.gYr != null && (this.gYr instanceof a)) {
            ((a) this.gYr).mM(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gYs = cVar;
        if (this.gYr != null) {
            this.gYr.a(this.gYs);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.nUo != null) {
            this.nUo.hgC = alaLiveRoomBlurPageLayout;
        }
    }

    public void mQ(boolean z) {
        if (this.nUo != null) {
            this.nUo.hgI = false;
        }
        try {
            if (this.gYr != null) {
                if (this.nUo != null) {
                    if (this.gYr instanceof c) {
                        ((c) this.gYr).b(this.gaY);
                    }
                    this.gYr.l(this.nUo.nVs.Hi());
                }
                if ((this.gYr instanceof c) && z) {
                    ((c) this.gYr).mS(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gYq = (short) 1;
    }

    public void a(w wVar, String str, String str2) {
        if (this.nUo != null) {
            this.nUo.hgI = false;
        }
        try {
            if (this.gYr != null && this.nUo != null && (this.gYr instanceof c)) {
                ((c) this.gYr).a(wVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gYq = (short) 1;
    }

    public void bYO() {
        if (this.nUo != null) {
            this.nUo.hgH = true;
        }
    }

    public void a(w wVar) {
        if (this.gYr != null) {
            this.gYr.j(wVar);
        }
    }

    public void c(q qVar) {
        if (this.gYr != null) {
            this.gYr.b(qVar);
        }
    }

    public void mR(boolean z) {
        if (this.gYq != 3) {
            try {
                if (this.nUo != null) {
                    this.nUo.hgI = false;
                }
                if (this.gYr != null) {
                    this.gYr.cj(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gYq = (short) 3;
        }
    }

    public void bYP() {
        if (this.gYq != 4) {
            try {
                if (this.nUo != null) {
                    this.nUo.hgI = true;
                    if (this.gYr != null) {
                        this.gYr.m(this.nUo.nVs.Hi());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gXn = null;
            this.gYq = (short) 4;
        }
    }

    public boolean bYQ() {
        if (this.gYr == null || !(this.gYr instanceof a)) {
            return false;
        }
        return ((a) this.gYr).bXI();
    }

    public boolean bYR() {
        if (this.gYr != null && (this.gYr instanceof a) && ((a) this.gYr).gXH) {
            return false;
        }
        if (this.gYq != 5) {
            if (this.nUo != null) {
                this.nUo.hgI = false;
            }
            try {
                if (this.gYr != null) {
                    boolean NW = this.gYr.NW();
                    if (NW && (this.gYr instanceof a)) {
                        ((a) this.gYr).gXG = true;
                    }
                    return NW;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gYq = (short) 5;
        }
        if (this.gYr != null && (this.gYr instanceof a)) {
            ((a) this.gYr).gXG = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gYr != null) {
            this.gYr.ch(false);
        }
    }

    public void enterBackground() {
        if (this.gYr != null) {
            this.gYr.onPause();
        }
    }

    public void enterForeground() {
        if (this.gYr != null) {
            this.gYr.onResume();
        }
    }

    public void bYS() {
        if (this.gYr != null) {
            this.gYr.onStop();
        }
    }

    public void bYT() {
        if (this.gYr != null) {
            this.gYr.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gYr != null) {
            this.gYr.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gYr != null) {
            this.gYr.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gYr != null) {
            this.gYr.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a dXx() {
        return this.nUo;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bYU() {
        return this.gYr;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gYr != null) {
            return this.gYr.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gaY = alaLastLiveroomInfo;
    }
}
