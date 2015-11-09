package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> bKL = new HashMap<>();

    public void a(String str, a aVar) {
        this.bKL.put(str, aVar);
    }

    public boolean iw(String str) {
        a aVar;
        return (this.bKL == null || (aVar = this.bKL.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.HB()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b ix(String str) {
        if (this.bKL.get(str) != null) {
            return this.bKL.get(str).Yk();
        }
        return null;
    }
}
