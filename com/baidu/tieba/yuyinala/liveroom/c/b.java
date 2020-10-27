package com.baidu.tieba.yuyinala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.bn;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.r.e;
import com.baidu.live.r.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    private AlaLastLiveroomInfo fVh;
    private bn gRj;
    private boolean gRr;
    private short gSl = 0;
    private com.baidu.live.liveroom.f.a gSm;
    private com.baidu.live.liveroom.a.c gSn;
    private com.baidu.tieba.yuyinala.liveroom.data.a nOr;
    private String otherParams;

    public void e(short s) {
        if (this.gSm != null && (this.gSm instanceof a)) {
            this.gSm.cg(true);
            this.gSm = null;
        }
        if (this.gSm == null) {
            this.gSm = com.baidu.live.liveroom.f.c.Ny().Nz().c(s);
            if (this.gSm != null) {
                this.gSm.setActivity(this.nOr.pageContext.getPageActivity());
                this.gSm.a(this.gSn);
                this.gSm.b(this.nOr.nPl);
                if (this.nOr.nPl.getParent() != null && (this.nOr.nPl.getParent() instanceof ViewGroup)) {
                    this.gSm.p((ViewGroup) this.nOr.nPl.getParent());
                }
                this.gSm.a(this.nOr.haA, this.nOr.bmp);
                this.gSl = (short) 0;
                this.nOr.haF = false;
                this.gSm.init();
                return;
            }
            return;
        }
        this.gSm.b(this.nOr.nPl);
        if (this.nOr.nPl.getParent() != null && (this.nOr.nPl.getParent() instanceof ViewGroup)) {
            this.gSm.p((ViewGroup) this.nOr.nPl.getParent());
        }
        this.gSm.a(this.nOr.haA, this.nOr.bmp);
    }

    public void dUY() {
        if (this.gSm != null && !(this.gSm instanceof c)) {
            this.gSm.cg(true);
            this.gSm = null;
        }
        if (this.gSm == null) {
            c cVar = new c();
            this.gSl = (short) 0;
            cVar.a(this.nOr);
            cVar.a(this.gSn);
            cVar.setActivity(this.nOr.pageContext.getPageActivity());
            this.nOr.haF = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.gSm = cVar;
        }
        a aVar = (a) this.gSm;
        aVar.bVp();
        aVar.mD(this.gRr);
        aVar.a(this.gRj);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.i.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bn bnVar) {
        if (this.nOr == null) {
            this.nOr = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.nOr.pageContext = tbPageContext;
        this.nOr.nPl = alaLiveView;
        this.nOr.bmp = fVar;
        this.nOr.haA = eVar;
        this.nOr.nPk = aVar;
        this.nOr.fromType = str;
        this.nOr.enterTime = j;
        this.nOr.haD = z;
        this.nOr.haG = arrayList;
        this.nOr.haH = false;
        this.gRj = bnVar;
    }

    public void mD(boolean z) {
        this.gRr = z;
        if (this.gSm != null && (this.gSm instanceof a)) {
            ((a) this.gSm).mD(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gSn = cVar;
        if (this.gSm != null) {
            this.gSm.a(this.gSn);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.nOr != null) {
            this.nOr.haA = alaLiveRoomBlurPageLayout;
        }
    }

    public void mH(boolean z) {
        if (this.nOr != null) {
            this.nOr.haF = false;
        }
        try {
            if (this.gSm != null) {
                if (this.nOr != null) {
                    if (this.gSm instanceof c) {
                        ((c) this.gSm).b(this.fVh);
                    }
                    this.gSm.m(this.nOr.nPk.GH());
                }
                if ((this.gSm instanceof c) && z) {
                    ((c) this.gSm).mJ(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gSl = (short) 1;
    }

    public void a(w wVar, String str, String str2) {
        if (this.nOr != null) {
            this.nOr.haF = false;
        }
        try {
            if (this.gSm != null && this.nOr != null && (this.gSm instanceof c)) {
                ((c) this.gSm).a(wVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gSl = (short) 1;
    }

    public void bWn() {
        if (this.nOr != null) {
            this.nOr.haE = true;
        }
    }

    public void a(w wVar) {
        if (this.gSm != null) {
            this.gSm.k(wVar);
        }
    }

    public void c(q qVar) {
        if (this.gSm != null) {
            this.gSm.b(qVar);
        }
    }

    public void mI(boolean z) {
        if (this.gSl != 3) {
            try {
                if (this.nOr != null) {
                    this.nOr.haF = false;
                }
                if (this.gSm != null) {
                    this.gSm.ci(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gSl = (short) 3;
        }
    }

    public void bWo() {
        if (this.gSl != 4) {
            try {
                if (this.nOr != null) {
                    this.nOr.haF = true;
                    if (this.gSm != null) {
                        this.gSm.n(this.nOr.nPk.GH());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gRj = null;
            this.gSl = (short) 4;
        }
    }

    public boolean bWp() {
        if (this.gSm == null || !(this.gSm instanceof a)) {
            return false;
        }
        return ((a) this.gSm).bVi();
    }

    public boolean bWq() {
        if (this.gSm != null && (this.gSm instanceof a) && ((a) this.gSm).gRB) {
            return false;
        }
        if (this.gSl != 5) {
            if (this.nOr != null) {
                this.nOr.haF = false;
            }
            try {
                if (this.gSm != null) {
                    boolean Nw = this.gSm.Nw();
                    if (Nw && (this.gSm instanceof a)) {
                        ((a) this.gSm).gRA = true;
                    }
                    return Nw;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gSl = (short) 5;
        }
        if (this.gSm != null && (this.gSm instanceof a)) {
            ((a) this.gSm).gRA = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gSm != null) {
            this.gSm.cg(false);
        }
    }

    public void enterBackground() {
        if (this.gSm != null) {
            this.gSm.onPause();
        }
    }

    public void enterForeground() {
        if (this.gSm != null) {
            this.gSm.onResume();
        }
    }

    public void bWr() {
        if (this.gSm != null) {
            this.gSm.onStop();
        }
    }

    public void bWs() {
        if (this.gSm != null) {
            this.gSm.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gSm != null) {
            this.gSm.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gSm != null) {
            this.gSm.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gSm != null) {
            this.gSm.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a dUX() {
        return this.nOr;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bWt() {
        return this.gSm;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gSm != null) {
            return this.gSm.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fVh = alaLastLiveroomInfo;
    }
}
