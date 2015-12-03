package com.baidu.tieba.themeCenter.bubble.all;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SetBubbleResultData extends i implements Serializable {
    private static final long serialVersionUID = -4612117445868668894L;
    private ResultInfo b_info = new ResultInfo();
    private String error_code;
    private String error_msg;

    public ResultInfo getB_info() {
        return this.b_info;
    }

    public String getError_code() {
        return this.error_code;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    /* loaded from: classes.dex */
    public static class ResultInfo extends i implements Serializable {
        private static final long serialVersionUID = 1818506758727291395L;
        private String b_url;
        private int can_use;
        private int is_free;
        private String t_msg;

        public int getCan_use() {
            return this.can_use;
        }

        public int getIs_free() {
            return this.is_free;
        }

        public String getT_msg() {
            return this.t_msg;
        }

        public boolean canUser() {
            return this.can_use == 1;
        }

        public boolean isFree() {
            return this.is_free == 1;
        }

        public String getB_url() {
            return this.b_url;
        }
    }
}
