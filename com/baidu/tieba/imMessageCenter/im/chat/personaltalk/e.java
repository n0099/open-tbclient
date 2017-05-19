package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e {
    private HashMap<String, a> det = new HashMap<>();

    public void a(String str, a aVar) {
        this.det.put(str, aVar);
    }

    public boolean ld(String str) {
        a aVar;
        return (this.det == null || (aVar = this.det.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.ask()) >= ReportUserInfoModel.TIME_INTERVAL) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b le(String str) {
        if (this.det.get(str) != null) {
            return this.det.get(str).asj();
        }
        return null;
    }
}
