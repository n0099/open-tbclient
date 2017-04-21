package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> dkq = new HashMap<>();

    public void a(String str, a aVar) {
        this.dkq.put(str, aVar);
    }

    public boolean kZ(String str) {
        a aVar;
        return (this.dkq == null || (aVar = this.dkq.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.avp()) >= ReportUserInfoModel.TIME_INTERVAL) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b la(String str) {
        if (this.dkq.get(str) != null) {
            return this.dkq.get(str).avo();
        }
        return null;
    }
}
