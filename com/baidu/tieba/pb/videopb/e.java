package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes9.dex */
public class e extends w {
    private d jLn = new d();
    private int jLo = 0;
    private PbModel jqg;

    public void init(Intent intent) {
        this.jLn.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.jLn.se(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.jqg = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.jLo) {
            this.jLo = i;
            this.jLn.I(eVar);
            if (eVar != null) {
                d dVar = this.jLn;
                if (eVar.getIsNewUrl() != 1 && !eVar.cvQ()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e cEe() {
        return this.jLn.cEe();
    }

    public boolean isFromCDN() {
        return this.jLn.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e cEf() {
        return this.jLn.cEf();
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.jLn.setData(eVar);
        }
    }

    public p<bj> cEg() {
        return this.jLn.cEg();
    }

    public Rect cEh() {
        if (this.jLn.cEh() == null || this.jLn.cEh().isEmpty()) {
            return null;
        }
        return this.jLn.cEh();
    }

    public void sh(boolean z) {
        if (this.jLn.cEl().getValue() != null) {
            com.baidu.tieba.pb.data.e aI = this.jqg.aI(this.jLn.cEl().getValue());
            if (aI != null) {
                this.jLn.cEj().addLast(this.jLn.cEf());
                this.jLn.setData(aI);
                this.jLn.aQ(!v.isEmpty(aI.cvP()) ? aI.cvP().get(0) : null);
                this.jLn.aP(this.jLn.cEj().getLast() != null ? this.jLn.cEj().getLast().cvs() : null);
                this.jqg.zH(z ? 21 : 22);
                this.jqg.h(aI);
                this.jLn.setIsLoading(true);
            }
        }
    }

    public void aR(bj bjVar) {
        com.baidu.tieba.pb.data.e aI;
        if (bjVar != null && (aI = this.jqg.aI(bjVar)) != null) {
            this.jLn.cEj().addLast(this.jLn.cEf());
            this.jLn.setData(aI);
            this.jLn.aQ(!v.isEmpty(aI.cvP()) ? aI.cvP().get(0) : null);
            this.jLn.aP(this.jLn.cEj().getLast() != null ? this.jLn.cEj().getLast().cvs() : null);
            this.jqg.zH(20);
            this.jqg.h(aI);
            this.jLn.setIsLoading(true);
        }
    }

    public void cEq() {
        com.baidu.tieba.pb.data.e pollLast = this.jLn.cEj().pollLast();
        if (pollLast != null) {
            this.jLn.setData(pollLast);
            this.jLn.aQ(!v.isEmpty(pollLast.cvP()) ? pollLast.cvP().get(0) : null);
            this.jLn.aP(this.jLn.cEj().peekLast() != null ? this.jLn.cEj().peekLast().cvs() : null);
            this.jqg.h(pollLast);
            this.jLn.setIsLoading(true);
        }
    }

    public p<bj> cEk() {
        return this.jLn.cEk();
    }

    public p<bj> cEl() {
        return this.jLn.cEl();
    }

    public p<Boolean> cEm() {
        return this.jLn.cEm();
    }

    public void sf(boolean z) {
        this.jLn.sf(z);
    }

    public p<Boolean> cEn() {
        return this.jLn.cEn();
    }

    public void sg(boolean z) {
        this.jLn.sg(z);
    }

    public void setIsLoading(boolean z) {
        this.jLn.setIsLoading(z);
    }

    public p<Boolean> cEo() {
        return this.jLn.cEo();
    }

    public boolean cEi() {
        return this.jLn.cEi();
    }

    public void setCurrentTab(int i) {
        this.jLn.setCurrentTab(i);
    }

    public p<Integer> cEp() {
        return this.jLn.cEp();
    }
}
