package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TRForumListData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 1389613226337298253L;
    Error error;
    int error_code;
    String error_msg;
    TRForum[] forum_list = new TRForum[0];

    /* loaded from: classes.dex */
    public static class Error extends OrmObject implements Serializable {
        private static final long serialVersionUID = -2899384495007355886L;
        public String errmsg;
        public int errno = 0;
        public String usermsg;
    }

    /* loaded from: classes.dex */
    public static class TRForum extends OrmObject implements Serializable {
        private static final long serialVersionUID = 1594316485025812834L;
        public String forum_name = "";
        public int forum_id = 0;
        public String avatar = "";
        public String slogan = "";
        public int member_count = 0;
        public int thread_count = 0;
        public int is_like = 0;
    }
}
