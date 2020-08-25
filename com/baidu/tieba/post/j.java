package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes17.dex */
public class j implements com.baidu.tieba.k.h {
    private String khp;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> zK;

    /* loaded from: classes17.dex */
    private static class a {
        private static final com.baidu.tieba.k.h lxf = new j();
    }

    public static com.baidu.tieba.k.h dle() {
        return a.lxf;
    }

    private j() {
        this.zK = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cRc() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bn(int i, String str) {
        dlf().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bo(int i, String str) {
        dlf().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bp(int i, String str) {
        dlf().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cRd() {
        dlf().MA(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        dlf().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cRe() {
        dlf().MB(this.mUuid);
        iq(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bq(int i, String str) {
        dlf().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void ME(String str) {
        if (!StringUtils.isNull(this.khp)) {
            if (MC(this.khp) || MD(this.khp)) {
                iq(this.khp);
            } else {
                com.baidu.tieba.k.d.Mz(this.khp);
                this.zK.remove(this.mUuid);
            }
            cRc();
            dlf().fi(this.khp, str);
            this.khp = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cRf() {
        this.khp = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void MF(String str) {
        dlf().fj(this.mUuid, str);
        if (MC(this.mUuid) || MD(this.mUuid)) {
            iq(this.mUuid);
        } else {
            com.baidu.tieba.k.d.Mz(this.mUuid);
            this.zK.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean MC(String str) {
        return dlf().MC(str);
    }

    public boolean MD(String str) {
        return dlf().MD(str);
    }

    public void iq(String str) {
        com.baidu.tieba.k.f fVar = this.zK.get(str);
        if (fVar != null) {
            fVar.iq(str);
            this.zK.remove(str);
        }
    }

    private com.baidu.tieba.k.f dlf() {
        com.baidu.tieba.k.f fVar = this.zK.get(this.mUuid);
        if (fVar == null) {
            return dlg();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f dlg() {
        i iVar = new i(this.mUuid);
        this.zK.put(this.mUuid, iVar);
        return iVar;
    }
}
