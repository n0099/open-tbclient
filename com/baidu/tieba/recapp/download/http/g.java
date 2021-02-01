package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class g {
    protected h mSF = new h();
    protected i mSG = new i();
    private LinkedList<e> Ms = new LinkedList<>();
    private e mSH = null;

    public h dDC() {
        return this.mSF;
    }

    public i dDD() {
        return this.mSG;
    }

    public List<e> lW() {
        return Collections.unmodifiableList(this.Ms);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Ms.add(eVar);
        }
    }

    public void b(e eVar) {
        this.mSH = eVar;
    }
}
