package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, a> bpW = new HashMap<>();

    public void a(String str, a aVar) {
        this.bpW.put(str, aVar);
    }

    public boolean hb(String str) {
        a aVar;
        return (this.bpW == null || (aVar = this.bpW.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.Gh()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b hc(String str) {
        if (this.bpW.get(str) != null) {
            return this.bpW.get(str).Uk();
        }
        return null;
    }
}
