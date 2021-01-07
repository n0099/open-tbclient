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
/* loaded from: classes11.dex */
public class b {
    private AlaLastLiveroomInfo gtp;
    private br hso;
    private boolean hsz;
    private short htw = 0;
    private com.baidu.live.liveroom.f.a htx;
    private com.baidu.live.liveroom.a.c hty;
    private com.baidu.tieba.yuyinala.liveroom.data.a onG;
    private String otherParams;

    public void e(short s) {
        if (this.htx != null && (this.htx instanceof a)) {
            this.htx.cA(true);
            this.htx = null;
        }
        if (this.htx == null) {
            this.htx = com.baidu.live.liveroom.f.c.Px().Py().c(s);
            if (this.htx != null) {
                this.htx.setActivity(this.onG.pageContext.getPageActivity());
                this.htx.a(this.hty);
                this.htx.b(this.onG.ooR);
                if (this.onG.ooR.getParent() != null && (this.onG.ooR.getParent() instanceof ViewGroup)) {
                    this.htx.o((ViewGroup) this.onG.ooR.getParent());
                }
                this.htx.a(this.onG.hBO, this.onG.bsZ);
                this.htw = (short) 0;
                this.onG.hBU = false;
                this.htx.init();
                return;
            }
            return;
        }
        this.htx.b(this.onG.ooR);
        if (this.onG.ooR.getParent() != null && (this.onG.ooR.getParent() instanceof ViewGroup)) {
            this.htx.o((ViewGroup) this.onG.ooR.getParent());
        }
        this.htx.a(this.onG.hBO, this.onG.bsZ);
    }

    public void ecl() {
        if (this.htx != null && !(this.htx instanceof c)) {
            this.htx.cA(true);
            this.htx = null;
        }
        if (this.htx == null) {
            c cVar = new c();
            this.htw = (short) 0;
            cVar.a(this.onG);
            cVar.a(this.hty);
            cVar.setActivity(this.onG.pageContext.getPageActivity());
            this.onG.hBU = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.htx = cVar;
        }
        a aVar = (a) this.htx;
        aVar.cdH();
        aVar.nH(this.hsz);
        aVar.a(this.hso);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.k.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, br brVar) {
        if (this.onG == null) {
            this.onG = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.onG.pageContext = tbPageContext;
        this.onG.ooR = alaLiveView;
        this.onG.bsZ = fVar;
        this.onG.hBO = eVar;
        this.onG.ooQ = aVar;
        this.onG.fromType = str;
        this.onG.enterTime = j;
        this.onG.hBS = z;
        this.onG.hBV = arrayList;
        this.onG.hBW = false;
        this.hso = brVar;
    }

    public void nH(boolean z) {
        this.hsz = z;
        if (this.htx != null && (this.htx instanceof a)) {
            ((a) this.htx).nH(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.hty = cVar;
        if (this.htx != null) {
            this.htx.a(this.hty);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.onG != null) {
            this.onG.hBO = alaLiveRoomBlurPageLayout;
        }
    }

    public void aF(boolean z, boolean z2) {
        if (this.onG != null) {
            this.onG.hBU = false;
        }
        try {
            if (this.htx != null) {
                if (this.onG != null) {
                    if (this.htx instanceof c) {
                        ((c) this.htx).b(this.gtp);
                    }
                    this.htx.m(this.onG.ooQ.HR());
                }
                if (this.htx instanceof c) {
                    if (z) {
                        ((c) this.htx).nO(true);
                    } else if (z2) {
                        ((c) this.htx).cdX();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.htw = (short) 1;
    }

    public void a(x xVar, String str, String str2) {
        if (this.onG != null) {
            this.onG.hBU = false;
        }
        try {
            if (this.htx != null && this.onG != null && (this.htx instanceof c)) {
                ((c) this.htx).a(xVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.htw = (short) 1;
    }

    public void ceL() {
        if (this.onG != null) {
            this.onG.hBT = true;
        }
    }

    public void a(x xVar) {
        if (this.htx != null) {
            this.htx.k(xVar);
        }
    }

    public void c(r rVar) {
        if (this.htx != null) {
            this.htx.b(rVar);
        }
    }

    public void nN(boolean z) {
        if (this.htw != 3) {
            try {
                if (this.onG != null) {
                    this.onG.hBU = false;
                }
                if (this.htx != null) {
                    this.htx.cC(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.htw = (short) 3;
        }
    }

    public void ceM() {
        if (this.htw != 4) {
            try {
                if (this.onG != null) {
                    this.onG.hBU = true;
                    if (this.htx != null) {
                        this.htx.n(this.onG.ooQ.HR());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hso = null;
            this.htw = (short) 4;
        }
    }

    public boolean ceN() {
        if (this.htx == null || !(this.htx instanceof a)) {
            return false;
        }
        return ((a) this.htx).cdA();
    }

    public boolean ceO() {
        if (this.htx != null && (this.htx instanceof a) && ((a) this.htx).hsJ) {
            return false;
        }
        if (this.htw != 5) {
            if (this.onG != null) {
                this.onG.hBU = false;
            }
            try {
                if (this.htx != null) {
                    boolean Pv = this.htx.Pv();
                    if (Pv && (this.htx instanceof a)) {
                        ((a) this.htx).hsI = true;
                    }
                    return Pv;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.htw = (short) 5;
        }
        if (this.htx != null && (this.htx instanceof a)) {
            ((a) this.htx).hsI = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.htx != null) {
            this.htx.cA(false);
        }
    }

    public void enterBackground() {
        if (this.htx != null) {
            this.htx.onPause();
        }
    }

    public void enterForeground() {
        if (this.htx != null) {
            this.htx.onResume();
        }
    }

    public void ceP() {
        if (this.htx != null) {
            this.htx.onStop();
        }
    }

    public void ceQ() {
        if (this.htx != null) {
            this.htx.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.htx != null) {
            this.htx.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.htx != null) {
            this.htx.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.htx != null) {
            this.htx.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a eck() {
        return this.onG;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a ceR() {
        return this.htx;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.htx != null) {
            return this.htx.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gtp = alaLastLiveroomInfo;
    }

    public void a(d dVar) {
        try {
            if (this.htx != null && (this.htx instanceof c)) {
                ((c) this.htx).a(dVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
