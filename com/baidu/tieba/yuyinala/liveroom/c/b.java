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
    private bo gWU;
    private short gXX = 0;
    private com.baidu.live.liveroom.f.a gXY;
    private com.baidu.live.liveroom.a.c gXZ;
    private boolean gXe;
    private AlaLastLiveroomInfo gaF;
    private com.baidu.tieba.yuyinala.liveroom.data.a nVR;
    private String otherParams;

    public void e(short s) {
        if (this.gXY != null && (this.gXY instanceof a)) {
            this.gXY.cj(true);
            this.gXY = null;
        }
        if (this.gXY == null) {
            this.gXY = com.baidu.live.liveroom.f.c.Np().Nq().c(s);
            if (this.gXY != null) {
                this.gXY.setActivity(this.nVR.pageContext.getPageActivity());
                this.gXY.a(this.gXZ);
                this.gXY.b(this.nVR.nWW);
                if (this.nVR.nWW.getParent() != null && (this.nVR.nWW.getParent() instanceof ViewGroup)) {
                    this.gXY.l((ViewGroup) this.nVR.nWW.getParent());
                }
                this.gXY.a(this.nVR.hgj, this.nVR.blY);
                this.gXX = (short) 0;
                this.nVR.hgp = false;
                this.gXY.init();
                return;
            }
            return;
        }
        this.gXY.b(this.nVR.nWW);
        if (this.nVR.nWW.getParent() != null && (this.nVR.nWW.getParent() instanceof ViewGroup)) {
            this.gXY.l((ViewGroup) this.nVR.nWW.getParent());
        }
        this.gXY.a(this.nVR.hgj, this.nVR.blY);
    }

    public void dXx() {
        if (this.gXY != null && !(this.gXY instanceof c)) {
            this.gXY.cj(true);
            this.gXY = null;
        }
        if (this.gXY == null) {
            c cVar = new c();
            this.gXX = (short) 0;
            cVar.a(this.nVR);
            cVar.a(this.gXZ);
            cVar.setActivity(this.nVR.pageContext.getPageActivity());
            this.nVR.hgp = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.gXY = cVar;
        }
        a aVar = (a) this.gXY;
        aVar.bXi();
        aVar.mN(this.gXe);
        aVar.a(this.gWU);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.i.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bo boVar) {
        if (this.nVR == null) {
            this.nVR = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.nVR.pageContext = tbPageContext;
        this.nVR.nWW = alaLiveView;
        this.nVR.blY = fVar;
        this.nVR.hgj = eVar;
        this.nVR.nWV = aVar;
        this.nVR.fromType = str;
        this.nVR.enterTime = j;
        this.nVR.hgn = z;
        this.nVR.hgq = arrayList;
        this.nVR.hgr = false;
        this.gWU = boVar;
    }

    public void mN(boolean z) {
        this.gXe = z;
        if (this.gXY != null && (this.gXY instanceof a)) {
            ((a) this.gXY).mN(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gXZ = cVar;
        if (this.gXY != null) {
            this.gXY.a(this.gXZ);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.nVR != null) {
            this.nVR.hgj = alaLiveRoomBlurPageLayout;
        }
    }

    public void mR(boolean z) {
        if (this.nVR != null) {
            this.nVR.hgp = false;
        }
        try {
            if (this.gXY != null) {
                if (this.nVR != null) {
                    if (this.gXY instanceof c) {
                        ((c) this.gXY).b(this.gaF);
                    }
                    this.gXY.l(this.nVR.nWV.Gz());
                }
                if ((this.gXY instanceof c) && z) {
                    ((c) this.gXY).mT(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gXX = (short) 1;
    }

    public void a(w wVar, String str, String str2) {
        if (this.nVR != null) {
            this.nVR.hgp = false;
        }
        try {
            if (this.gXY != null && this.nVR != null && (this.gXY instanceof c)) {
                ((c) this.gXY).a(wVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gXX = (short) 1;
    }

    public void bYh() {
        if (this.nVR != null) {
            this.nVR.hgo = true;
        }
    }

    public void a(w wVar) {
        if (this.gXY != null) {
            this.gXY.j(wVar);
        }
    }

    public void c(q qVar) {
        if (this.gXY != null) {
            this.gXY.b(qVar);
        }
    }

    public void mS(boolean z) {
        if (this.gXX != 3) {
            try {
                if (this.nVR != null) {
                    this.nVR.hgp = false;
                }
                if (this.gXY != null) {
                    this.gXY.cl(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gXX = (short) 3;
        }
    }

    public void bYi() {
        if (this.gXX != 4) {
            try {
                if (this.nVR != null) {
                    this.nVR.hgp = true;
                    if (this.gXY != null) {
                        this.gXY.m(this.nVR.nWV.Gz());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gWU = null;
            this.gXX = (short) 4;
        }
    }

    public boolean bYj() {
        if (this.gXY == null || !(this.gXY instanceof a)) {
            return false;
        }
        return ((a) this.gXY).bXb();
    }

    public boolean bYk() {
        if (this.gXY != null && (this.gXY instanceof a) && ((a) this.gXY).gXo) {
            return false;
        }
        if (this.gXX != 5) {
            if (this.nVR != null) {
                this.nVR.hgp = false;
            }
            try {
                if (this.gXY != null) {
                    boolean Nn = this.gXY.Nn();
                    if (Nn && (this.gXY instanceof a)) {
                        ((a) this.gXY).gXn = true;
                    }
                    return Nn;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gXX = (short) 5;
        }
        if (this.gXY != null && (this.gXY instanceof a)) {
            ((a) this.gXY).gXn = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gXY != null) {
            this.gXY.cj(false);
        }
    }

    public void enterBackground() {
        if (this.gXY != null) {
            this.gXY.onPause();
        }
    }

    public void enterForeground() {
        if (this.gXY != null) {
            this.gXY.onResume();
        }
    }

    public void bYl() {
        if (this.gXY != null) {
            this.gXY.onStop();
        }
    }

    public void bYm() {
        if (this.gXY != null) {
            this.gXY.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gXY != null) {
            this.gXY.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gXY != null) {
            this.gXY.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gXY != null) {
            this.gXY.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a dXw() {
        return this.nVR;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bYn() {
        return this.gXY;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gXY != null) {
            return this.gXY.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gaF = alaLastLiveroomInfo;
    }
}
