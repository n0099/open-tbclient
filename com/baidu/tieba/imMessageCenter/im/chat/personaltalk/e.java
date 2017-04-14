package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> dhZ = new HashMap<>();

    public void a(String str, a aVar) {
        this.dhZ.put(str, aVar);
    }

    public boolean kY(String str) {
        a aVar;
        return (this.dhZ == null || (aVar = this.dhZ.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.auo()) >= ReportUserInfoModel.TIME_INTERVAL) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b kZ(String str) {
        if (this.dhZ.get(str) != null) {
            return this.dhZ.get(str).aun();
        }
        return null;
    }
}
