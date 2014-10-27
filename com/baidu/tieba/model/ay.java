package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.e {
    private az bpF;
    private String mForumId;
    private String mForumName;

    public ay(Context context) {
        super(context);
        this.mForumName = null;
        this.mForumId = null;
        this.bpF = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void TF() {
        if (this.bpF != null) {
            this.bpF.cancel();
            this.bpF = null;
        }
    }

    public void az(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bpF == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bpF = new az(this, null);
            this.bpF.setPriority(2);
            this.bpF.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkApplication.m251getInst().getApplicationContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }
}
