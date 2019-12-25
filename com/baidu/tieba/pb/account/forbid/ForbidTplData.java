package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class ForbidTplData extends OrmObject implements Serializable {
    private static final long serialVersionUID = -2159666579341742989L;
    public ErrorInfo error;
    public String[] reason = new String[0];
    public int type = 0;

    /* loaded from: classes6.dex */
    public static class ErrorInfo extends OrmObject {
        public int errno = 0;
        public String errMsg = "";
        public String userMsg = "";
    }

    public ForbidTplData() {
        this.error = null;
        this.error = new ErrorInfo();
    }
}
