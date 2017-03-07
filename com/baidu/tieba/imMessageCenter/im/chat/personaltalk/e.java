package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> djA = new HashMap<>();

    public void a(String str, a aVar) {
        this.djA.put(str, aVar);
    }

    public boolean kS(String str) {
        a aVar;
        return (this.djA == null || (aVar = this.djA.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.auv()) >= ReportUserInfoModel.TIME_INTERVAL) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b kT(String str) {
        if (this.djA.get(str) != null) {
            return this.djA.get(str).auu();
        }
        return null;
    }
}
