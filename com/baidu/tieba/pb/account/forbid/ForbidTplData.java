package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbidTplData extends i implements Serializable {
    private static final long serialVersionUID = -2159666579341742989L;
    public a error;
    public String[] reason = new String[0];
    public int type = 0;

    /* loaded from: classes.dex */
    public static class a extends i {
        public int errno = 0;
        public String errMsg = "";
        public String userMsg = "";
    }

    public ForbidTplData() {
        this.error = null;
        this.error = new a();
    }
}
