package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class g {
    protected h mIU = new h();
    protected i mIV = new i();
    private LinkedList<e> MZ = new LinkedList<>();
    private e mIW = null;

    public h dFv() {
        return this.mIU;
    }

    public i dFw() {
        return this.mIV;
    }

    public List<e> mz() {
        return Collections.unmodifiableList(this.MZ);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.MZ.add(eVar);
        }
    }

    public void b(e eVar) {
        this.mIW = eVar;
    }
}
