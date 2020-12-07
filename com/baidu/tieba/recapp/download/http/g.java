package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class g {
    protected h mIS = new h();
    protected i mIT = new i();
    private LinkedList<e> MZ = new LinkedList<>();
    private e mIU = null;

    public h dFu() {
        return this.mIS;
    }

    public i dFv() {
        return this.mIT;
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
        this.mIU = eVar;
    }
}
