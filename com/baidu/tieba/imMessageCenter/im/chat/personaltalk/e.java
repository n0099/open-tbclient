package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> cdQ = new HashMap<>();

    public void a(String str, a aVar) {
        this.cdQ.put(str, aVar);
    }

    public boolean jd(String str) {
        a aVar;
        return (this.cdQ == null || (aVar = this.cdQ.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.Jl()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b je(String str) {
        if (this.cdQ.get(str) != null) {
            return this.cdQ.get(str).acz();
        }
        return null;
    }
}
