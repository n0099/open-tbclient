package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String hpm;
    private String hpn;
    private HashMap<String, com.baidu.tieba.j.f> iuv;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h iuw = new j();
    }

    public static com.baidu.tieba.j.h ccK() {
        return a.iuw;
    }

    private j() {
        this.iuv = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bLO() {
        this.hpm = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        ccL().o(this.hpm, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aw(int i, String str) {
        ccL().p(this.hpm, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ax(int i, String str) {
        ccL().q(this.hpm, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bLP() {
        ccL().Ah(this.hpm);
    }

    @Override // com.baidu.tieba.j.h
    public void h(int i, int i2, String str) {
        ccL().e(this.hpm, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bLQ() {
        ccL().Ai(this.hpm);
        cU(this.hpm);
    }

    @Override // com.baidu.tieba.j.h
    public void ay(int i, String str) {
        ccL().r(this.hpm, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void Al(String str) {
        if (!StringUtils.isNull(this.hpn)) {
            if (Aj(this.hpn) || Ak(this.hpn)) {
                cU(this.hpn);
            } else {
                com.baidu.tieba.j.d.Ag(this.hpn);
                this.iuv.remove(this.hpm);
            }
            bLO();
            ccL().dC(this.hpn, str);
            this.hpn = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bLR() {
        this.hpn = this.hpm;
    }

    @Override // com.baidu.tieba.j.h
    public void Am(String str) {
        ccL().dD(this.hpm, str);
        if (Aj(this.hpm) || Ak(this.hpm)) {
            cU(this.hpm);
        } else {
            com.baidu.tieba.j.d.Ag(this.hpm);
            this.iuv.remove(this.hpm);
        }
        this.hpm = null;
    }

    public boolean Aj(String str) {
        return ccL().Aj(str);
    }

    public boolean Ak(String str) {
        return ccL().Ak(str);
    }

    public void cU(String str) {
        com.baidu.tieba.j.f fVar = this.iuv.get(str);
        if (fVar != null) {
            fVar.cU(str);
            this.iuv.remove(str);
        }
    }

    private com.baidu.tieba.j.f ccL() {
        com.baidu.tieba.j.f fVar = this.iuv.get(this.hpm);
        if (fVar == null) {
            return ccM();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f ccM() {
        i iVar = new i(this.hpm);
        this.iuv.put(this.hpm, iVar);
        return iVar;
    }
}
