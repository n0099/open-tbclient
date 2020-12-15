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
    private AlaLastLiveroomInfo giS;
    private boolean hgJ;
    private bp hgy;
    private short hhD = 0;
    private com.baidu.live.liveroom.f.a hhE;
    private com.baidu.live.liveroom.a.c hhF;
    private com.baidu.tieba.yuyinala.liveroom.data.a okR;
    private String otherParams;

    public void e(short s) {
        if (this.hhE != null && (this.hhE instanceof a)) {
            this.hhE.cx(true);
            this.hhE = null;
        }
        if (this.hhE == null) {
            this.hhE = com.baidu.live.liveroom.f.c.PI().PJ().c(s);
            if (this.hhE != null) {
                this.hhE.setActivity(this.okR.pageContext.getPageActivity());
                this.hhE.a(this.hhF);
                this.hhE.b(this.okR.olW);
                if (this.okR.olW.getParent() != null && (this.okR.olW.getParent() instanceof ViewGroup)) {
                    this.hhE.l((ViewGroup) this.okR.olW.getParent());
                }
                this.hhE.a(this.okR.hpS, this.okR.brf);
                this.hhD = (short) 0;
                this.okR.hpY = false;
                this.hhE.init();
                return;
            }
            return;
        }
        this.hhE.b(this.okR.olW);
        if (this.okR.olW.getParent() != null && (this.okR.olW.getParent() instanceof ViewGroup)) {
            this.hhE.l((ViewGroup) this.okR.olW.getParent());
        }
        this.hhE.a(this.okR.hpS, this.okR.brf);
    }

    public void edc() {
        if (this.hhE != null && !(this.hhE instanceof c)) {
            this.hhE.cx(true);
            this.hhE = null;
        }
        if (this.hhE == null) {
            c cVar = new c();
            this.hhD = (short) 0;
            cVar.a(this.okR);
            cVar.a(this.hhF);
            cVar.setActivity(this.okR.pageContext.getPageActivity());
            this.okR.hpY = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.hhE = cVar;
        }
        a aVar = (a) this.hhE;
        aVar.cba();
        aVar.nh(this.hgJ);
        aVar.a(this.hgy);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.i.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bp bpVar) {
        if (this.okR == null) {
            this.okR = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.okR.pageContext = tbPageContext;
        this.okR.olW = alaLiveView;
        this.okR.brf = fVar;
        this.okR.hpS = eVar;
        this.okR.olV = aVar;
        this.okR.fromType = str;
        this.okR.enterTime = j;
        this.okR.hpW = z;
        this.okR.hpZ = arrayList;
        this.okR.hqa = false;
        this.hgy = bpVar;
    }

    public void nh(boolean z) {
        this.hgJ = z;
        if (this.hhE != null && (this.hhE instanceof a)) {
            ((a) this.hhE).nh(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.hhF = cVar;
        if (this.hhE != null) {
            this.hhE.a(this.hhF);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.okR != null) {
            this.okR.hpS = alaLiveRoomBlurPageLayout;
        }
    }

    public void nm(boolean z) {
        if (this.okR != null) {
            this.okR.hpY = false;
        }
        try {
            if (this.hhE != null) {
                if (this.okR != null) {
                    if (this.hhE instanceof c) {
                        ((c) this.hhE).b(this.giS);
                    }
                    this.hhE.l(this.okR.olV.Iq());
                }
                if ((this.hhE instanceof c) && z) {
                    ((c) this.hhE).no(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hhD = (short) 1;
    }

    public void a(w wVar, String str, String str2) {
        if (this.okR != null) {
            this.okR.hpY = false;
        }
        try {
            if (this.hhE != null && this.okR != null && (this.hhE instanceof c)) {
                ((c) this.hhE).a(wVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hhD = (short) 1;
    }

    public void ccb() {
        if (this.okR != null) {
            this.okR.hpX = true;
        }
    }

    public void a(w wVar) {
        if (this.hhE != null) {
            this.hhE.j(wVar);
        }
    }

    public void c(q qVar) {
        if (this.hhE != null) {
            this.hhE.b(qVar);
        }
    }

    public void nn(boolean z) {
        if (this.hhD != 3) {
            try {
                if (this.okR != null) {
                    this.okR.hpY = false;
                }
                if (this.hhE != null) {
                    this.hhE.cz(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhD = (short) 3;
        }
    }

    public void ccc() {
        if (this.hhD != 4) {
            try {
                if (this.okR != null) {
                    this.okR.hpY = true;
                    if (this.hhE != null) {
                        this.hhE.m(this.okR.olV.Iq());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hgy = null;
            this.hhD = (short) 4;
        }
    }

    public boolean ccd() {
        if (this.hhE == null || !(this.hhE instanceof a)) {
            return false;
        }
        return ((a) this.hhE).caT();
    }

    public boolean cce() {
        if (this.hhE != null && (this.hhE instanceof a) && ((a) this.hhE).hgT) {
            return false;
        }
        if (this.hhD != 5) {
            if (this.okR != null) {
                this.okR.hpY = false;
            }
            try {
                if (this.hhE != null) {
                    boolean PG = this.hhE.PG();
                    if (PG && (this.hhE instanceof a)) {
                        ((a) this.hhE).hgS = true;
                    }
                    return PG;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhD = (short) 5;
        }
        if (this.hhE != null && (this.hhE instanceof a)) {
            ((a) this.hhE).hgS = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.hhE != null) {
            this.hhE.cx(false);
        }
    }

    public void enterBackground() {
        if (this.hhE != null) {
            this.hhE.onPause();
        }
    }

    public void enterForeground() {
        if (this.hhE != null) {
            this.hhE.onResume();
        }
    }

    public void ccf() {
        if (this.hhE != null) {
            this.hhE.onStop();
        }
    }

    public void ccg() {
        if (this.hhE != null) {
            this.hhE.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hhE != null) {
            this.hhE.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hhE != null) {
            this.hhE.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hhE != null) {
            this.hhE.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a edb() {
        return this.okR;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a cch() {
        return this.hhE;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hhE != null) {
            return this.hhE.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.giS = alaLastLiveroomInfo;
    }
}
