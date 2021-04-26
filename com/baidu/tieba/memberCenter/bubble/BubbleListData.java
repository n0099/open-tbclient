package com.baidu.tieba.memberCenter.bubble;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BubbleListData extends OrmObject implements Serializable, Cloneable {
    public static final long serialVersionUID = -4612117445868668894L;
    public List<BubbleData> b_info = new ArrayList();
    public String error_code;
    public String error_msg;

    /* loaded from: classes3.dex */
    public static class BubbleData extends OrmObject implements Serializable {
        public static final long serialVersionUID = 1540726255641451917L;
        public String b_url;
        public int bcode;
        public String bg_url;
        public String bname;
        public int can_use;
        public String icon_url;
        public int is_def;
        public int is_free;
        public String level_name;
        public int time_interval;

        public boolean canUse() {
            return this.can_use == 1;
        }

        public String getB_url() {
            return this.b_url;
        }

        public int getBcode() {
            return this.bcode;
        }

        public String getBg_url() {
            return this.bg_url;
        }

        public String getBname() {
            return this.bname;
        }

        public int getCan_use() {
            return this.can_use;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public int getIs_def() {
            return this.is_def;
        }

        public int getIs_free() {
            return this.is_free;
        }

        public String getLevel_name() {
            return this.level_name;
        }

        public int getTime_interval() {
            return this.time_interval;
        }

        public boolean isDef() {
            return this.is_def == 1;
        }

        public boolean isFree() {
            return this.is_free == 1;
        }

        public void setBcode(int i2) {
            this.bcode = i2;
        }

        public void setCan_use(int i2) {
            this.can_use = i2;
        }

        public void setIs_def(int i2) {
            this.is_def = i2;
        }
    }

    public List<BubbleData> getB_info() {
        return this.b_info;
    }

    public String getError_code() {
        return this.error_code;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BubbleListData m27clone() {
        try {
            Object clone = super.clone();
            return clone instanceof BubbleListData ? (BubbleListData) clone : this;
        } catch (Exception e2) {
            e2.printStackTrace();
            return this;
        }
    }
}
