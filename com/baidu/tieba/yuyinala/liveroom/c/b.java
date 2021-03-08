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
/* loaded from: classes10.dex */
public class b {
    private AlaLastLiveroomInfo gto;
    private bw htP;
    private short huX = 0;
    private com.baidu.live.liveroom.f.a huY;
    private com.baidu.live.liveroom.a.c huZ;
    private boolean hua;
    private String otherParams;
    private com.baidu.tieba.yuyinala.liveroom.data.a ovA;

    public void e(short s) {
        if (this.huY != null && (this.huY instanceof a)) {
            this.huY.cF(true);
            this.huY = null;
        }
        if (this.huY == null) {
            this.huY = com.baidu.live.liveroom.f.c.Nd().Ne().c(s);
            if (this.huY != null) {
                this.huY.setActivity(this.ovA.pageContext.getPageActivity());
                this.huY.a(this.huZ);
                this.huY.b(this.ovA.owK);
                if (this.ovA.owK.getParent() != null && (this.ovA.owK.getParent() instanceof ViewGroup)) {
                    this.huY.o((ViewGroup) this.ovA.owK.getParent());
                }
                this.huY.a(this.ovA.hDp, this.ovA.btp);
                this.huX = (short) 0;
                this.ovA.hDv = false;
                this.huY.init();
                return;
            }
            return;
        }
        this.huY.b(this.ovA.owK);
        if (this.ovA.owK.getParent() != null && (this.ovA.owK.getParent() instanceof ViewGroup)) {
            this.huY.o((ViewGroup) this.ovA.owK.getParent());
        }
        this.huY.a(this.ovA.hDp, this.ovA.btp);
    }

    public void eaW() {
        if (this.huY != null && !(this.huY instanceof c)) {
            this.huY.cF(true);
            this.huY = null;
        }
        if (this.huY == null) {
            c cVar = new c();
            this.huX = (short) 0;
            cVar.a(this.ovA);
            cVar.a(this.huZ);
            cVar.setActivity(this.ovA.pageContext.getPageActivity());
            this.ovA.hDv = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.huY = cVar;
        }
        a aVar = (a) this.huY;
        aVar.caY();
        aVar.nO(this.hua);
        aVar.a(this.htP);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.k.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bw bwVar) {
        if (this.ovA == null) {
            this.ovA = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.ovA.pageContext = tbPageContext;
        this.ovA.owK = alaLiveView;
        this.ovA.btp = fVar;
        this.ovA.hDp = eVar;
        this.ovA.owJ = aVar;
        this.ovA.fromType = str;
        this.ovA.enterTime = j;
        this.ovA.hDt = z;
        this.ovA.hDw = arrayList;
        this.ovA.hDx = false;
        this.htP = bwVar;
    }

    public void nO(boolean z) {
        this.hua = z;
        if (this.huY != null && (this.huY instanceof a)) {
            ((a) this.huY).nO(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.huZ = cVar;
        if (this.huY != null) {
            this.huY.a(this.huZ);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.ovA != null) {
            this.ovA.hDp = alaLiveRoomBlurPageLayout;
        }
    }

    public void aF(boolean z, boolean z2) {
        if (this.ovA != null) {
            this.ovA.hDv = false;
        }
        try {
            if (this.huY != null) {
                if (this.ovA != null) {
                    if (this.huY instanceof c) {
                        ((c) this.huY).b(this.gto);
                    }
                    this.huY.m(this.ovA.owJ.Fp());
                }
                if (this.huY instanceof c) {
                    if (z) {
                        ((c) this.huY).nV(true);
                    } else if (z2) {
                        ((c) this.huY).cbm();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.huX = (short) 1;
    }

    public void a(ab abVar, String str, String str2) {
        if (this.ovA != null) {
            this.ovA.hDv = false;
        }
        try {
            if (this.huY != null && this.ovA != null && (this.huY instanceof c)) {
                ((c) this.huY).a(abVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.huX = (short) 1;
    }

    public void cca() {
        if (this.ovA != null) {
            this.ovA.hDu = true;
        }
    }

    public void a(ab abVar) {
        if (this.huY != null) {
            this.huY.k(abVar);
        }
    }

    public void c(v vVar) {
        if (this.huY != null) {
            this.huY.b(vVar);
        }
    }

    public void nU(boolean z) {
        if (this.huX != 3) {
            try {
                if (this.ovA != null) {
                    this.ovA.hDv = false;
                }
                if (this.huY != null) {
                    this.huY.cH(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.huX = (short) 3;
        }
    }

    public void ccb() {
        if (this.huX != 4) {
            try {
                if (this.ovA != null) {
                    this.ovA.hDv = true;
                    if (this.huY != null) {
                        this.huY.n(this.ovA.owJ.Fp());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.htP = null;
            this.huX = (short) 4;
        }
    }

    public boolean ccc() {
        if (this.huY == null || !(this.huY instanceof a)) {
            return false;
        }
        return ((a) this.huY).caR();
    }

    public boolean ccd() {
        if (this.huY != null && (this.huY instanceof a) && ((a) this.huY).huk) {
            return false;
        }
        if (this.huX != 5) {
            if (this.ovA != null) {
                this.ovA.hDv = false;
            }
            try {
                if (this.huY != null) {
                    boolean Nb = this.huY.Nb();
                    if (Nb && (this.huY instanceof a)) {
                        ((a) this.huY).huj = true;
                    }
                    return Nb;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.huX = (short) 5;
        }
        if (this.huY != null && (this.huY instanceof a)) {
            ((a) this.huY).huj = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.huY != null) {
            this.huY.cF(false);
        }
    }

    public void enterBackground() {
        if (this.huY != null) {
            this.huY.onPause();
        }
    }

    public void enterForeground() {
        if (this.huY != null) {
            this.huY.onResume();
        }
    }

    public void cce() {
        if (this.huY != null) {
            this.huY.onStop();
        }
    }

    public void ccf() {
        if (this.huY != null) {
            this.huY.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.huY != null) {
            this.huY.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.huY != null) {
            this.huY.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.huY != null) {
            this.huY.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a eaV() {
        return this.ovA;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a ccg() {
        return this.huY;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.huY != null) {
            return this.huY.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gto = alaLastLiveroomInfo;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        try {
            if (this.huY != null && (this.huY instanceof c)) {
                ((c) this.huY).b(cVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
