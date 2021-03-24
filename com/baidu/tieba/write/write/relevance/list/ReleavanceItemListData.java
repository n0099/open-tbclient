package com.baidu.tieba.write.write.relevance.list;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes5.dex */
public class ReleavanceItemListData implements Serializable {
    public int ctime;
    public String error_code;
    public List<ItemListBean> item_list;
    public String logid;
    public String server_time;
    public List<String> tab_option;
    public int time;

    /* loaded from: classes5.dex */
    public static class ItemListBean implements Serializable {
        public String icon_size;
        public String icon_url;
        public String item_id;
        public String item_name;
        public String score;
        public String star;
        public List<String> tags;

        public String getIcon_size() {
            return this.icon_size;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public String getItem_id() {
            return this.item_id;
        }

        public String getItem_name() {
            return this.item_name;
        }

        public String getScore() {
            return this.score;
        }

        public String getStar() {
            return this.star;
        }

        public List<String> getTags() {
            return this.tags;
        }

        public void setIcon_size(String str) {
            this.icon_size = str;
        }

        public void setIcon_url(String str) {
            this.icon_url = str;
        }

        public void setItem_id(String str) {
            this.item_id = str;
        }

        public void setItem_name(String str) {
            this.item_name = str;
        }

        public void setScore(String str) {
            this.score = str;
        }

        public void setStar(String str) {
            this.star = str;
        }

        public void setTags(List<String> list) {
            this.tags = list;
        }
    }

    public int getCtime() {
        return this.ctime;
    }

    public String getError_code() {
        return this.error_code;
    }

    public List<ItemListBean> getItem_list() {
        return this.item_list;
    }

    public String getLogid() {
        return this.logid;
    }

    public String getServer_time() {
        return this.server_time;
    }

    public List<String> getTab_option() {
        return this.tab_option;
    }

    public int getTime() {
        return this.time;
    }

    public void setCtime(int i) {
        this.ctime = i;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }

    public void setItem_list(List<ItemListBean> list) {
        this.item_list = list;
    }

    public void setLogid(String str) {
        this.logid = str;
    }

    public void setServer_time(String str) {
        this.server_time = str;
    }

    public void setTab_option(List<String> list) {
        this.tab_option = list;
    }

    public void setTime(int i) {
        this.time = i;
    }
}
