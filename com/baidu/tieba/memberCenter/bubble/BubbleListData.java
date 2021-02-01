package com.baidu.tieba.memberCenter.bubble;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class BubbleListData extends OrmObject implements Serializable, Cloneable {
    private static final long serialVersionUID = -4612117445868668894L;
    private List<BubbleData> b_info = new ArrayList();
    private String error_code;
    private String error_msg;

    public String getError_code() {
        return this.error_code;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public List<BubbleData> getB_info() {
        return this.b_info;
    }

    /* loaded from: classes9.dex */
    public static class BubbleData extends OrmObject implements Serializable {
        private static final long serialVersionUID = 1540726255641451917L;
        private String b_url;
        private int bcode;
        private String bg_url;
        private String bname;
        private int can_use;
        private String icon_url;
        private int is_def;
        private int is_free;
        private String level_name;
        private int time_interval;

        public int getBcode() {
            return this.bcode;
        }

        public void setBcode(int i) {
            this.bcode = i;
        }

        public String getB_url() {
            return this.b_url;
        }

        public String getBg_url() {
            return this.bg_url;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public int getCan_use() {
            return this.can_use;
        }

        public void setCan_use(int i) {
            this.can_use = i;
        }

        public int getIs_def() {
            return this.is_def;
        }

        public void setIs_def(int i) {
            this.is_def = i;
        }

        public int getIs_free() {
            return this.is_free;
        }

        public boolean canUse() {
            return this.can_use == 1;
        }

        public boolean isDef() {
            return this.is_def == 1;
        }

        public boolean isFree() {
            return this.is_free == 1;
        }

        public String getBname() {
            return this.bname;
        }

        public String getLevel_name() {
            return this.level_name;
        }

        public int getTime_interval() {
            return this.time_interval;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BubbleListData m35clone() {
        try {
            Object clone = super.clone();
            if (clone instanceof BubbleListData) {
                return (BubbleListData) clone;
            }
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }
}
