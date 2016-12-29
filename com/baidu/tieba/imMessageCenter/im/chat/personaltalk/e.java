package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> cZT = new HashMap<>();

    public void a(String str, a aVar) {
        this.cZT.put(str, aVar);
    }

    public boolean le(String str) {
        a aVar;
        return (this.cZT == null || (aVar = this.cZT.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.atU()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b lf(String str) {
        if (this.cZT.get(str) != null) {
            return this.cZT.get(str).atT();
        }
        return null;
    }
}
