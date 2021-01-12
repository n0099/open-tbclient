package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {
    protected h mJx = new h();
    protected i mJy = new i();
    private LinkedList<e> Mu = new LinkedList<>();
    private e mJz = null;

    public h dBt() {
        return this.mJx;
    }

    public i dBu() {
        return this.mJy;
    }

    public List<e> lX() {
        return Collections.unmodifiableList(this.Mu);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Mu.add(eVar);
        }
    }

    public void b(e eVar) {
        this.mJz = eVar;
    }
}
