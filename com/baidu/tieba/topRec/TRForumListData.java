package com.baidu.tieba.topRec;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TRForumListData implements Serializable {
    private static final long serialVersionUID = 1389613226337298253L;
    Error error;
    int error_code;
    String error_msg;
    TRForum[] forum_list;

    /* loaded from: classes.dex */
    public class Error implements Serializable {
        private static final long serialVersionUID = -2899384495007355886L;
        public String errmsg;
        public int errno = 0;
        public String usermsg;
    }

    /* loaded from: classes.dex */
    public class TRForum implements Serializable {
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
