package com.baidu.tieba.yuyinala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.br;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.v.e;
import com.baidu.live.v.f;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b {
    private AlaLastLiveroomInfo goI;
    private br hnH;
    private boolean hnS;
    private short hoQ = 0;
    private com.baidu.live.liveroom.f.a hoR;
    private com.baidu.live.liveroom.a.c hoS;
    private com.baidu.tieba.yuyinala.liveroom.data.a oja;
    private String otherParams;

    public void e(short s) {
        if (this.hoR != null && (this.hoR instanceof a)) {
            this.hoR.cw(true);
            this.hoR = null;
        }
        if (this.hoR == null) {
            this.hoR = com.baidu.live.liveroom.f.c.LC().LD().c(s);
            if (this.hoR != null) {
                this.hoR.setActivity(this.oja.pageContext.getPageActivity());
                this.hoR.a(this.hoS);
                this.hoR.b(this.oja.okl);
                if (this.oja.okl.getParent() != null && (this.oja.okl.getParent() instanceof ViewGroup)) {
                    this.hoR.o((ViewGroup) this.oja.okl.getParent());
                }
                this.hoR.a(this.oja.hxi, this.oja.bon);
                this.hoQ = (short) 0;
                this.oja.hxo = false;
                this.hoR.init();
                return;
            }
            return;
        }
        this.hoR.b(this.oja.okl);
        if (this.oja.okl.getParent() != null && (this.oja.okl.getParent() instanceof ViewGroup)) {
            this.hoR.o((ViewGroup) this.oja.okl.getParent());
        }
        this.hoR.a(this.oja.hxi, this.oja.bon);
    }

    public void dYt() {
        if (this.hoR != null && !(this.hoR instanceof c)) {
            this.hoR.cw(true);
            this.hoR = null;
        }
        if (this.hoR == null) {
            c cVar = new c();
            this.hoQ = (short) 0;
            cVar.a(this.oja);
            cVar.a(this.hoS);
            cVar.setActivity(this.oja.pageContext.getPageActivity());
            this.oja.hxo = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.hoR = cVar;
        }
        a aVar = (a) this.hoR;
        aVar.bZP();
        aVar.nD(this.hnS);
        aVar.a(this.hnH);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.k.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, br brVar) {
        if (this.oja == null) {
            this.oja = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.oja.pageContext = tbPageContext;
        this.oja.okl = alaLiveView;
        this.oja.bon = fVar;
        this.oja.hxi = eVar;
        this.oja.okk = aVar;
        this.oja.fromType = str;
        this.oja.enterTime = j;
        this.oja.hxm = z;
        this.oja.hxp = arrayList;
        this.oja.hxq = false;
        this.hnH = brVar;
    }

    public void nD(boolean z) {
        this.hnS = z;
        if (this.hoR != null && (this.hoR instanceof a)) {
            ((a) this.hoR).nD(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.hoS = cVar;
        if (this.hoR != null) {
            this.hoR.a(this.hoS);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.oja != null) {
            this.oja.hxi = alaLiveRoomBlurPageLayout;
        }
    }

    public void aF(boolean z, boolean z2) {
        if (this.oja != null) {
            this.oja.hxo = false;
        }
        try {
            if (this.hoR != null) {
                if (this.oja != null) {
                    if (this.hoR instanceof c) {
                        ((c) this.hoR).b(this.goI);
                    }
                    this.hoR.m(this.oja.okk.DW());
                }
                if (this.hoR instanceof c) {
                    if (z) {
                        ((c) this.hoR).nK(true);
                    } else if (z2) {
                        ((c) this.hoR).caf();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hoQ = (short) 1;
    }

    public void a(x xVar, String str, String str2) {
        if (this.oja != null) {
            this.oja.hxo = false;
        }
        try {
            if (this.hoR != null && this.oja != null && (this.hoR instanceof c)) {
                ((c) this.hoR).a(xVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hoQ = (short) 1;
    }

    public void caT() {
        if (this.oja != null) {
            this.oja.hxn = true;
        }
    }

    public void a(x xVar) {
        if (this.hoR != null) {
            this.hoR.k(xVar);
        }
    }

    public void c(r rVar) {
        if (this.hoR != null) {
            this.hoR.b(rVar);
        }
    }

    public void nJ(boolean z) {
        if (this.hoQ != 3) {
            try {
                if (this.oja != null) {
                    this.oja.hxo = false;
                }
                if (this.hoR != null) {
                    this.hoR.cy(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hoQ = (short) 3;
        }
    }

    public void caU() {
        if (this.hoQ != 4) {
            try {
                if (this.oja != null) {
                    this.oja.hxo = true;
                    if (this.hoR != null) {
                        this.hoR.n(this.oja.okk.DW());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hnH = null;
            this.hoQ = (short) 4;
        }
    }

    public boolean caV() {
        if (this.hoR == null || !(this.hoR instanceof a)) {
            return false;
        }
        return ((a) this.hoR).bZI();
    }

    public boolean caW() {
        if (this.hoR != null && (this.hoR instanceof a) && ((a) this.hoR).hoc) {
            return false;
        }
        if (this.hoQ != 5) {
            if (this.oja != null) {
                this.oja.hxo = false;
            }
            try {
                if (this.hoR != null) {
                    boolean LA = this.hoR.LA();
                    if (LA && (this.hoR instanceof a)) {
                        ((a) this.hoR).hob = true;
                    }
                    return LA;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hoQ = (short) 5;
        }
        if (this.hoR != null && (this.hoR instanceof a)) {
            ((a) this.hoR).hob = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.hoR != null) {
            this.hoR.cw(false);
        }
    }

    public void enterBackground() {
        if (this.hoR != null) {
            this.hoR.onPause();
        }
    }

    public void enterForeground() {
        if (this.hoR != null) {
            this.hoR.onResume();
        }
    }

    public void caX() {
        if (this.hoR != null) {
            this.hoR.onStop();
        }
    }

    public void caY() {
        if (this.hoR != null) {
            this.hoR.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hoR != null) {
            this.hoR.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hoR != null) {
            this.hoR.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hoR != null) {
            this.hoR.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a dYs() {
        return this.oja;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a caZ() {
        return this.hoR;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hoR != null) {
            return this.hoR.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.goI = alaLastLiveroomInfo;
    }

    public void a(d dVar) {
        try {
            if (this.hoR != null && (this.hoR instanceof c)) {
                ((c) this.hoR).a(dVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
