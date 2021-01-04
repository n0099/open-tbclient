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
    private com.baidu.tieba.yuyinala.liveroom.data.a onH;
    private String otherParams;

    public void e(short s) {
        if (this.htx != null && (this.htx instanceof a)) {
            this.htx.cA(true);
            this.htx = null;
        }
        if (this.htx == null) {
            this.htx = com.baidu.live.liveroom.f.c.Px().Py().c(s);
            if (this.htx != null) {
                this.htx.setActivity(this.onH.pageContext.getPageActivity());
                this.htx.a(this.hty);
                this.htx.b(this.onH.ooS);
                if (this.onH.ooS.getParent() != null && (this.onH.ooS.getParent() instanceof ViewGroup)) {
                    this.htx.o((ViewGroup) this.onH.ooS.getParent());
                }
                this.htx.a(this.onH.hBO, this.onH.bsZ);
                this.htw = (short) 0;
                this.onH.hBU = false;
                this.htx.init();
                return;
            }
            return;
        }
        this.htx.b(this.onH.ooS);
        if (this.onH.ooS.getParent() != null && (this.onH.ooS.getParent() instanceof ViewGroup)) {
            this.htx.o((ViewGroup) this.onH.ooS.getParent());
        }
        this.htx.a(this.onH.hBO, this.onH.bsZ);
    }

    public void eck() {
        if (this.htx != null && !(this.htx instanceof c)) {
            this.htx.cA(true);
            this.htx = null;
        }
        if (this.htx == null) {
            c cVar = new c();
            this.htw = (short) 0;
            cVar.a(this.onH);
            cVar.a(this.hty);
            cVar.setActivity(this.onH.pageContext.getPageActivity());
            this.onH.hBU = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.htx = cVar;
        }
        a aVar = (a) this.htx;
        aVar.cdG();
        aVar.nH(this.hsz);
        aVar.a(this.hso);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.k.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, br brVar) {
        if (this.onH == null) {
            this.onH = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.onH.pageContext = tbPageContext;
        this.onH.ooS = alaLiveView;
        this.onH.bsZ = fVar;
        this.onH.hBO = eVar;
        this.onH.ooR = aVar;
        this.onH.fromType = str;
        this.onH.enterTime = j;
        this.onH.hBS = z;
        this.onH.hBV = arrayList;
        this.onH.hBW = false;
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
        if (this.onH != null) {
            this.onH.hBO = alaLiveRoomBlurPageLayout;
        }
    }

    public void aF(boolean z, boolean z2) {
        if (this.onH != null) {
            this.onH.hBU = false;
        }
        try {
            if (this.htx != null) {
                if (this.onH != null) {
                    if (this.htx instanceof c) {
                        ((c) this.htx).b(this.gtp);
                    }
                    this.htx.m(this.onH.ooR.HR());
                }
                if (this.htx instanceof c) {
                    if (z) {
                        ((c) this.htx).nO(true);
                    } else if (z2) {
                        ((c) this.htx).cdW();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.htw = (short) 1;
    }

    public void a(x xVar, String str, String str2) {
        if (this.onH != null) {
            this.onH.hBU = false;
        }
        try {
            if (this.htx != null && this.onH != null && (this.htx instanceof c)) {
                ((c) this.htx).a(xVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.htw = (short) 1;
    }

    public void ceK() {
        if (this.onH != null) {
            this.onH.hBT = true;
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
                if (this.onH != null) {
                    this.onH.hBU = false;
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

    public void ceL() {
        if (this.htw != 4) {
            try {
                if (this.onH != null) {
                    this.onH.hBU = true;
                    if (this.htx != null) {
                        this.htx.n(this.onH.ooR.HR());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hso = null;
            this.htw = (short) 4;
        }
    }

    public boolean ceM() {
        if (this.htx == null || !(this.htx instanceof a)) {
            return false;
        }
        return ((a) this.htx).cdz();
    }

    public boolean ceN() {
        if (this.htx != null && (this.htx instanceof a) && ((a) this.htx).hsJ) {
            return false;
        }
        if (this.htw != 5) {
            if (this.onH != null) {
                this.onH.hBU = false;
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

    public void ceO() {
        if (this.htx != null) {
            this.htx.onStop();
        }
    }

    public void ceP() {
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

    public com.baidu.tieba.yuyinala.liveroom.data.a ecj() {
        return this.onH;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a ceQ() {
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
