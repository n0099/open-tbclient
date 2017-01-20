package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> dhi = new HashMap<>();

    public void a(String str, a aVar) {
        this.dhi.put(str, aVar);
    }

    public boolean lr(String str) {
        a aVar;
        return (this.dhi == null || (aVar = this.dhi.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.ava()) >= ReportUserInfoModel.TIME_INTERVAL) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b ls(String str) {
        if (this.dhi.get(str) != null) {
            return this.dhi.get(str).auZ();
        }
        return null;
    }
}
