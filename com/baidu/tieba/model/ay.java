package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.e {
    private az bpT;
    private String mForumId;
    private String mForumName;

    public ay(Context context) {
        super(context);
        this.mForumName = null;
        this.mForumId = null;
        this.bpT = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void TI() {
        if (this.bpT != null) {
            this.bpT.cancel();
            this.bpT = null;
        }
    }

    public void az(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bpT == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bpT = new az(this, null);
            this.bpT.setPriority(2);
            this.bpT.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkApplication.m251getInst().getApplicationContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }
}
