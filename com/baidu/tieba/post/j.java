package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes23.dex */
public class j implements com.baidu.tieba.k.h {
    private HashMap<String, com.baidu.tieba.k.f> Ab;
    private String kXB;
    private String mUuid;

    /* loaded from: classes23.dex */
    private static class a {
        private static final com.baidu.tieba.k.h mnS = new j();
    }

    public static com.baidu.tieba.k.h dyi() {
        return a.mnS;
    }

    private j() {
        this.Ab = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void dec() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bF(int i, String str) {
        dyj().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bG(int i, String str) {
        dyj().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bH(int i, String str) {
        dyj().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void ded() {
        dyj().OH(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void o(int i, int i2, String str) {
        dyj().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void dee() {
        dyj().OI(this.mUuid);
        jS(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bI(int i, String str) {
        dyj().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void OL(String str) {
        if (!StringUtils.isNull(this.kXB)) {
            if (OJ(this.kXB) || OK(this.kXB)) {
                jS(this.kXB);
            } else {
                com.baidu.tieba.k.d.OG(this.kXB);
                this.Ab.remove(this.mUuid);
            }
            dec();
            dyj().fI(this.kXB, str);
            this.kXB = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void def() {
        this.kXB = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void OM(String str) {
        dyj().fJ(this.mUuid, str);
        if (OJ(this.mUuid) || OK(this.mUuid)) {
            jS(this.mUuid);
        } else {
            com.baidu.tieba.k.d.OG(this.mUuid);
            this.Ab.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean OJ(String str) {
        return dyj().OJ(str);
    }

    public boolean OK(String str) {
        return dyj().OK(str);
    }

    public void jS(String str) {
        com.baidu.tieba.k.f fVar = this.Ab.get(str);
        if (fVar != null) {
            fVar.jS(str);
            this.Ab.remove(str);
        }
    }

    private com.baidu.tieba.k.f dyj() {
        com.baidu.tieba.k.f fVar = this.Ab.get(this.mUuid);
        if (fVar == null) {
            return dyk();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f dyk() {
        i iVar = new i(this.mUuid);
        this.Ab.put(this.mUuid, iVar);
        return iVar;
    }
}
