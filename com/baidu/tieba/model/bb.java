package com.baidu.tieba.model;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.e {
    private String a = null;
    private String b = null;
    private bc c = null;

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.c == null) {
            this.a = str;
            this.b = str2;
            this.c = new bc(this, null);
            this.c.setPriority(2);
            this.c.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }
}
