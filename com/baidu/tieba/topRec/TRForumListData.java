package com.baidu.tieba.topRec;

import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class TRForumListData implements Serializable {
    private static final long serialVersionUID = 1389613226337298253L;
    Error error;
    int error_code;
    String error_msg;
    TRForum[] forum_list;

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

        public String toString() {
            return "{forum_id='" + this.forum_id + "', forum_name=" + this.forum_name + ", avatar='" + this.avatar + "', slogan='" + this.slogan + "', member_count=" + this.member_count + ", thread_count=" + this.thread_count + '}';
        }
    }

    /* loaded from: classes.dex */
    public class Error implements Serializable {
        private static final long serialVersionUID = -2899384495007355886L;
        public String errmsg;
        public int errno = 0;
        public String usermsg;

        public String toString() {
            return "error:{errno=" + this.errno + ", errmsg='" + this.errmsg + "' , usermsg='" + this.usermsg + "'}";
        }
    }

    public String toString() {
        return "TRForumListData{" + this.error + ", " + Arrays.toString(this.forum_list) + "}";
    }
}
