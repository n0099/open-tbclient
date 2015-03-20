package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, a> bpG = new HashMap<>();

    public void a(String str, a aVar) {
        this.bpG.put(str, aVar);
    }

    public boolean gY(String str) {
        a aVar;
        return (this.bpG == null || (aVar = this.bpG.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.Gb()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b gZ(String str) {
        if (this.bpG.get(str) != null) {
            return this.bpG.get(str).TX();
        }
        return null;
    }
}
