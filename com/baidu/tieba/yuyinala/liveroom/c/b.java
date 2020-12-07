package com.baidu.tieba.yuyinala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.bp;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.u.e;
import com.baidu.live.u.f;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    private AlaLastLiveroomInfo giQ;
    private boolean hgH;
    private bp hgw;
    private short hhB = 0;
    private com.baidu.live.liveroom.f.a hhC;
    private com.baidu.live.liveroom.a.c hhD;
    private com.baidu.tieba.yuyinala.liveroom.data.a okP;
    private String otherParams;

    public void e(short s) {
        if (this.hhC != null && (this.hhC instanceof a)) {
            this.hhC.cx(true);
            this.hhC = null;
        }
        if (this.hhC == null) {
            this.hhC = com.baidu.live.liveroom.f.c.PI().PJ().c(s);
            if (this.hhC != null) {
                this.hhC.setActivity(this.okP.pageContext.getPageActivity());
                this.hhC.a(this.hhD);
                this.hhC.b(this.okP.olU);
                if (this.okP.olU.getParent() != null && (this.okP.olU.getParent() instanceof ViewGroup)) {
                    this.hhC.l((ViewGroup) this.okP.olU.getParent());
                }
                this.hhC.a(this.okP.hpQ, this.okP.brf);
                this.hhB = (short) 0;
                this.okP.hpW = false;
                this.hhC.init();
                return;
            }
            return;
        }
        this.hhC.b(this.okP.olU);
        if (this.okP.olU.getParent() != null && (this.okP.olU.getParent() instanceof ViewGroup)) {
            this.hhC.l((ViewGroup) this.okP.olU.getParent());
        }
        this.hhC.a(this.okP.hpQ, this.okP.brf);
    }

    public void edb() {
        if (this.hhC != null && !(this.hhC instanceof c)) {
            this.hhC.cx(true);
            this.hhC = null;
        }
        if (this.hhC == null) {
            c cVar = new c();
            this.hhB = (short) 0;
            cVar.a(this.okP);
            cVar.a(this.hhD);
            cVar.setActivity(this.okP.pageContext.getPageActivity());
            this.okP.hpW = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.hhC = cVar;
        }
        a aVar = (a) this.hhC;
        aVar.caZ();
        aVar.nh(this.hgH);
        aVar.a(this.hgw);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.i.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bp bpVar) {
        if (this.okP == null) {
            this.okP = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.okP.pageContext = tbPageContext;
        this.okP.olU = alaLiveView;
        this.okP.brf = fVar;
        this.okP.hpQ = eVar;
        this.okP.olT = aVar;
        this.okP.fromType = str;
        this.okP.enterTime = j;
        this.okP.hpU = z;
        this.okP.hpX = arrayList;
        this.okP.hpY = false;
        this.hgw = bpVar;
    }

    public void nh(boolean z) {
        this.hgH = z;
        if (this.hhC != null && (this.hhC instanceof a)) {
            ((a) this.hhC).nh(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.hhD = cVar;
        if (this.hhC != null) {
            this.hhC.a(this.hhD);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.okP != null) {
            this.okP.hpQ = alaLiveRoomBlurPageLayout;
        }
    }

    public void nm(boolean z) {
        if (this.okP != null) {
            this.okP.hpW = false;
        }
        try {
            if (this.hhC != null) {
                if (this.okP != null) {
                    if (this.hhC instanceof c) {
                        ((c) this.hhC).b(this.giQ);
                    }
                    this.hhC.l(this.okP.olT.Iq());
                }
                if ((this.hhC instanceof c) && z) {
                    ((c) this.hhC).no(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hhB = (short) 1;
    }

    public void a(w wVar, String str, String str2) {
        if (this.okP != null) {
            this.okP.hpW = false;
        }
        try {
            if (this.hhC != null && this.okP != null && (this.hhC instanceof c)) {
                ((c) this.hhC).a(wVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hhB = (short) 1;
    }

    public void cca() {
        if (this.okP != null) {
            this.okP.hpV = true;
        }
    }

    public void a(w wVar) {
        if (this.hhC != null) {
            this.hhC.j(wVar);
        }
    }

    public void c(q qVar) {
        if (this.hhC != null) {
            this.hhC.b(qVar);
        }
    }

    public void nn(boolean z) {
        if (this.hhB != 3) {
            try {
                if (this.okP != null) {
                    this.okP.hpW = false;
                }
                if (this.hhC != null) {
                    this.hhC.cz(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhB = (short) 3;
        }
    }

    public void ccb() {
        if (this.hhB != 4) {
            try {
                if (this.okP != null) {
                    this.okP.hpW = true;
                    if (this.hhC != null) {
                        this.hhC.m(this.okP.olT.Iq());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hgw = null;
            this.hhB = (short) 4;
        }
    }

    public boolean ccc() {
        if (this.hhC == null || !(this.hhC instanceof a)) {
            return false;
        }
        return ((a) this.hhC).caS();
    }

    public boolean ccd() {
        if (this.hhC != null && (this.hhC instanceof a) && ((a) this.hhC).hgR) {
            return false;
        }
        if (this.hhB != 5) {
            if (this.okP != null) {
                this.okP.hpW = false;
            }
            try {
                if (this.hhC != null) {
                    boolean PG = this.hhC.PG();
                    if (PG && (this.hhC instanceof a)) {
                        ((a) this.hhC).hgQ = true;
                    }
                    return PG;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhB = (short) 5;
        }
        if (this.hhC != null && (this.hhC instanceof a)) {
            ((a) this.hhC).hgQ = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.hhC != null) {
            this.hhC.cx(false);
        }
    }

    public void enterBackground() {
        if (this.hhC != null) {
            this.hhC.onPause();
        }
    }

    public void enterForeground() {
        if (this.hhC != null) {
            this.hhC.onResume();
        }
    }

    public void cce() {
        if (this.hhC != null) {
            this.hhC.onStop();
        }
    }

    public void ccf() {
        if (this.hhC != null) {
            this.hhC.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hhC != null) {
            this.hhC.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hhC != null) {
            this.hhC.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hhC != null) {
            this.hhC.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a eda() {
        return this.okP;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a ccg() {
        return this.hhC;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hhC != null) {
            return this.hhC.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.giQ = alaLastLiveroomInfo;
    }
}
