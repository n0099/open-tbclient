package com.baidu.tieba.pb.account.forbid;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbidTplData extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = -2159666579341742989L;
    public k error;
    public String[] reason = new String[0];
    public int type = 0;

    public ForbidTplData() {
        this.error = null;
        this.error = new k();
    }
}
