package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e {
    private HashMap<String, a> djN = new HashMap<>();

    public void a(String str, a aVar) {
        this.djN.put(str, aVar);
    }

    public boolean ln(String str) {
        a aVar;
        return (this.djN == null || (aVar = this.djN.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.ath()) >= ReportUserInfoModel.TIME_INTERVAL) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b lo(String str) {
        if (this.djN.get(str) != null) {
            return this.djN.get(str).atg();
        }
        return null;
    }
}
