package com.baidu.tieba.yuyinala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.data.bw;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.u.e;
import com.baidu.live.u.f;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b {
    private AlaLastLiveroomInfo grr;
    private bw hrS;
    private boolean hsd;
    private short hta = 0;
    private com.baidu.live.liveroom.f.a htb;
    private com.baidu.live.liveroom.a.c htc;
    private com.baidu.tieba.yuyinala.liveroom.data.a osU;
    private String otherParams;

    public void e(short s) {
        if (this.htb != null && (this.htb instanceof a)) {
            this.htb.cF(true);
            this.htb = null;
        }
        if (this.htb == null) {
            this.htb = com.baidu.live.liveroom.f.c.Na().Nb().c(s);
            if (this.htb != null) {
                this.htb.setActivity(this.osU.pageContext.getPageActivity());
                this.htb.a(this.htc);
                this.htb.b(this.osU.oue);
                if (this.osU.oue.getParent() != null && (this.osU.oue.getParent() instanceof ViewGroup)) {
                    this.htb.o((ViewGroup) this.osU.oue.getParent());
                }
                this.htb.a(this.osU.hBs, this.osU.brO);
                this.hta = (short) 0;
                this.osU.hBy = false;
                this.htb.init();
                return;
            }
            return;
        }
        this.htb.b(this.osU.oue);
        if (this.osU.oue.getParent() != null && (this.osU.oue.getParent() instanceof ViewGroup)) {
            this.htb.o((ViewGroup) this.osU.oue.getParent());
        }
        this.htb.a(this.osU.hBs, this.osU.brO);
    }

    public void eaG() {
        if (this.htb != null && !(this.htb instanceof c)) {
            this.htb.cF(true);
            this.htb = null;
        }
        if (this.htb == null) {
            c cVar = new c();
            this.hta = (short) 0;
            cVar.a(this.osU);
            cVar.a(this.htc);
            cVar.setActivity(this.osU.pageContext.getPageActivity());
            this.osU.hBy = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.htb = cVar;
        }
        a aVar = (a) this.htb;
        aVar.caL();
        aVar.nO(this.hsd);
        aVar.a(this.hrS);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.k.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bw bwVar) {
        if (this.osU == null) {
            this.osU = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.osU.pageContext = tbPageContext;
        this.osU.oue = alaLiveView;
        this.osU.brO = fVar;
        this.osU.hBs = eVar;
        this.osU.oud = aVar;
        this.osU.fromType = str;
        this.osU.enterTime = j;
        this.osU.hBw = z;
        this.osU.hBz = arrayList;
        this.osU.hBA = false;
        this.hrS = bwVar;
    }

    public void nO(boolean z) {
        this.hsd = z;
        if (this.htb != null && (this.htb instanceof a)) {
            ((a) this.htb).nO(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.htc = cVar;
        if (this.htb != null) {
            this.htb.a(this.htc);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.osU != null) {
            this.osU.hBs = alaLiveRoomBlurPageLayout;
        }
    }

    public void aF(boolean z, boolean z2) {
        if (this.osU != null) {
            this.osU.hBy = false;
        }
        try {
            if (this.htb != null) {
                if (this.osU != null) {
                    if (this.htb instanceof c) {
                        ((c) this.htb).b(this.grr);
                    }
                    this.htb.m(this.osU.oud.Fm());
                }
                if (this.htb instanceof c) {
                    if (z) {
                        ((c) this.htb).nV(true);
                    } else if (z2) {
                        ((c) this.htb).caZ();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hta = (short) 1;
    }

    public void a(ab abVar, String str, String str2) {
        if (this.osU != null) {
            this.osU.hBy = false;
        }
        try {
            if (this.htb != null && this.osU != null && (this.htb instanceof c)) {
                ((c) this.htb).a(abVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hta = (short) 1;
    }

    public void cbN() {
        if (this.osU != null) {
            this.osU.hBx = true;
        }
    }

    public void a(ab abVar) {
        if (this.htb != null) {
            this.htb.k(abVar);
        }
    }

    public void c(v vVar) {
        if (this.htb != null) {
            this.htb.b(vVar);
        }
    }

    public void nU(boolean z) {
        if (this.hta != 3) {
            try {
                if (this.osU != null) {
                    this.osU.hBy = false;
                }
                if (this.htb != null) {
                    this.htb.cH(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hta = (short) 3;
        }
    }

    public void cbO() {
        if (this.hta != 4) {
            try {
                if (this.osU != null) {
                    this.osU.hBy = true;
                    if (this.htb != null) {
                        this.htb.n(this.osU.oud.Fm());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hrS = null;
            this.hta = (short) 4;
        }
    }

    public boolean cbP() {
        if (this.htb == null || !(this.htb instanceof a)) {
            return false;
        }
        return ((a) this.htb).caE();
    }

    public boolean cbQ() {
        if (this.htb != null && (this.htb instanceof a) && ((a) this.htb).hsn) {
            return false;
        }
        if (this.hta != 5) {
            if (this.osU != null) {
                this.osU.hBy = false;
            }
            try {
                if (this.htb != null) {
                    boolean MY = this.htb.MY();
                    if (MY && (this.htb instanceof a)) {
                        ((a) this.htb).hsm = true;
                    }
                    return MY;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hta = (short) 5;
        }
        if (this.htb != null && (this.htb instanceof a)) {
            ((a) this.htb).hsm = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.htb != null) {
            this.htb.cF(false);
        }
    }

    public void enterBackground() {
        if (this.htb != null) {
            this.htb.onPause();
        }
    }

    public void enterForeground() {
        if (this.htb != null) {
            this.htb.onResume();
        }
    }

    public void cbR() {
        if (this.htb != null) {
            this.htb.onStop();
        }
    }

    public void cbS() {
        if (this.htb != null) {
            this.htb.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.htb != null) {
            this.htb.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.htb != null) {
            this.htb.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.htb != null) {
            this.htb.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a eaF() {
        return this.osU;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a cbT() {
        return this.htb;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.htb != null) {
            return this.htb.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.grr = alaLastLiveroomInfo;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        try {
            if (this.htb != null && (this.htb instanceof c)) {
                ((c) this.htb).b(cVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
