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
    private AlaLastLiveroomInfo grF;
    private bw hsg;
    private boolean hsr;
    private short hto = 0;
    private com.baidu.live.liveroom.f.a htp;
    private com.baidu.live.liveroom.a.c htq;
    private String otherParams;
    private com.baidu.tieba.yuyinala.liveroom.data.a otu;

    public void e(short s) {
        if (this.htp != null && (this.htp instanceof a)) {
            this.htp.cF(true);
            this.htp = null;
        }
        if (this.htp == null) {
            this.htp = com.baidu.live.liveroom.f.c.Na().Nb().c(s);
            if (this.htp != null) {
                this.htp.setActivity(this.otu.pageContext.getPageActivity());
                this.htp.a(this.htq);
                this.htp.b(this.otu.ouF);
                if (this.otu.ouF.getParent() != null && (this.otu.ouF.getParent() instanceof ViewGroup)) {
                    this.htp.o((ViewGroup) this.otu.ouF.getParent());
                }
                this.htp.a(this.otu.hBG, this.otu.brO);
                this.hto = (short) 0;
                this.otu.hBM = false;
                this.htp.init();
                return;
            }
            return;
        }
        this.htp.b(this.otu.ouF);
        if (this.otu.ouF.getParent() != null && (this.otu.ouF.getParent() instanceof ViewGroup)) {
            this.htp.o((ViewGroup) this.otu.ouF.getParent());
        }
        this.htp.a(this.otu.hBG, this.otu.brO);
    }

    public void eaO() {
        if (this.htp != null && !(this.htp instanceof c)) {
            this.htp.cF(true);
            this.htp = null;
        }
        if (this.htp == null) {
            c cVar = new c();
            this.hto = (short) 0;
            cVar.a(this.otu);
            cVar.a(this.htq);
            cVar.setActivity(this.otu.pageContext.getPageActivity());
            this.otu.hBM = false;
            cVar.setOtherParams(this.otherParams);
            cVar.init();
            this.htp = cVar;
        }
        a aVar = (a) this.htp;
        aVar.caS();
        aVar.nO(this.hsr);
        aVar.a(this.hsg);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.yuyinala.liveroom.k.a aVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bw bwVar) {
        if (this.otu == null) {
            this.otu = new com.baidu.tieba.yuyinala.liveroom.data.a();
        }
        this.otu.pageContext = tbPageContext;
        this.otu.ouF = alaLiveView;
        this.otu.brO = fVar;
        this.otu.hBG = eVar;
        this.otu.ouE = aVar;
        this.otu.fromType = str;
        this.otu.enterTime = j;
        this.otu.hBK = z;
        this.otu.hBN = arrayList;
        this.otu.hBO = false;
        this.hsg = bwVar;
    }

    public void nO(boolean z) {
        this.hsr = z;
        if (this.htp != null && (this.htp instanceof a)) {
            ((a) this.htp).nO(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.htq = cVar;
        if (this.htp != null) {
            this.htp.a(this.htq);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.otu != null) {
            this.otu.hBG = alaLiveRoomBlurPageLayout;
        }
    }

    public void aF(boolean z, boolean z2) {
        if (this.otu != null) {
            this.otu.hBM = false;
        }
        try {
            if (this.htp != null) {
                if (this.otu != null) {
                    if (this.htp instanceof c) {
                        ((c) this.htp).b(this.grF);
                    }
                    this.htp.m(this.otu.ouE.Fm());
                }
                if (this.htp instanceof c) {
                    if (z) {
                        ((c) this.htp).nV(true);
                    } else if (z2) {
                        ((c) this.htp).cbg();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hto = (short) 1;
    }

    public void a(ab abVar, String str, String str2) {
        if (this.otu != null) {
            this.otu.hBM = false;
        }
        try {
            if (this.htp != null && this.otu != null && (this.htp instanceof c)) {
                ((c) this.htp).a(abVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hto = (short) 1;
    }

    public void cbU() {
        if (this.otu != null) {
            this.otu.hBL = true;
        }
    }

    public void a(ab abVar) {
        if (this.htp != null) {
            this.htp.k(abVar);
        }
    }

    public void c(v vVar) {
        if (this.htp != null) {
            this.htp.b(vVar);
        }
    }

    public void nU(boolean z) {
        if (this.hto != 3) {
            try {
                if (this.otu != null) {
                    this.otu.hBM = false;
                }
                if (this.htp != null) {
                    this.htp.cH(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hto = (short) 3;
        }
    }

    public void cbV() {
        if (this.hto != 4) {
            try {
                if (this.otu != null) {
                    this.otu.hBM = true;
                    if (this.htp != null) {
                        this.htp.n(this.otu.ouE.Fm());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hsg = null;
            this.hto = (short) 4;
        }
    }

    public boolean cbW() {
        if (this.htp == null || !(this.htp instanceof a)) {
            return false;
        }
        return ((a) this.htp).caL();
    }

    public boolean cbX() {
        if (this.htp != null && (this.htp instanceof a) && ((a) this.htp).hsB) {
            return false;
        }
        if (this.hto != 5) {
            if (this.otu != null) {
                this.otu.hBM = false;
            }
            try {
                if (this.htp != null) {
                    boolean MY = this.htp.MY();
                    if (MY && (this.htp instanceof a)) {
                        ((a) this.htp).hsA = true;
                    }
                    return MY;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hto = (short) 5;
        }
        if (this.htp != null && (this.htp instanceof a)) {
            ((a) this.htp).hsA = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.htp != null) {
            this.htp.cF(false);
        }
    }

    public void enterBackground() {
        if (this.htp != null) {
            this.htp.onPause();
        }
    }

    public void enterForeground() {
        if (this.htp != null) {
            this.htp.onResume();
        }
    }

    public void cbY() {
        if (this.htp != null) {
            this.htp.onStop();
        }
    }

    public void cbZ() {
        if (this.htp != null) {
            this.htp.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.htp != null) {
            this.htp.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.htp != null) {
            this.htp.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.htp != null) {
            this.htp.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a eaN() {
        return this.otu;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a cca() {
        return this.htp;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.htp != null) {
            return this.htp.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.grF = alaLastLiveroomInfo;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        try {
            if (this.htp != null && (this.htp instanceof c)) {
                ((c) this.htp).b(cVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
