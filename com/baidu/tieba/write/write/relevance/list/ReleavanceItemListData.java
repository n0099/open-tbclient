package com.baidu.tieba.write.write.relevance.list;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class ReleavanceItemListData implements Serializable {
    private int ctime;
    private String error_code;
    private List<ItemListBean> item_list;
    private String logid;
    private String server_time;
    private List<String> tab_option;
    private int time;

    public String getServer_time() {
        return this.server_time;
    }

    public void setServer_time(String str) {
        this.server_time = str;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getCtime() {
        return this.ctime;
    }

    public void setCtime(int i) {
        this.ctime = i;
    }

    public String getLogid() {
        return this.logid;
    }

    public void setLogid(String str) {
        this.logid = str;
    }

    public String getError_code() {
        return this.error_code;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }

    public List<String> getTab_option() {
        return this.tab_option;
    }

    public void setTab_option(List<String> list) {
        this.tab_option = list;
    }

    public List<ItemListBean> getItem_list() {
        return this.item_list;
    }

    public void setItem_list(List<ItemListBean> list) {
        this.item_list = list;
    }

    /* loaded from: classes3.dex */
    public static class ItemListBean implements Serializable {
        private String icon_size;
        private String icon_url;
        private String item_id;
        private String item_name;
        private String score;
        private String star;
        private List<String> tags;

        public String getItem_id() {
            return this.item_id;
        }

        public void setItem_id(String str) {
            this.item_id = str;
        }

        public String getItem_name() {
            return this.item_name;
        }

        public void setItem_name(String str) {
            this.item_name = str;
        }

        public String getIcon_size() {
            return this.icon_size;
        }

        public void setIcon_size(String str) {
            this.icon_size = str;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public void setIcon_url(String str) {
            this.icon_url = str;
        }

        public String getScore() {
            return this.score;
        }

        public void setScore(String str) {
            this.score = str;
        }

        public String getStar() {
            return this.star;
        }

        public void setStar(String str) {
            this.star = str;
        }

        public List<String> getTags() {
            return this.tags;
        }

        public void setTags(List<String> list) {
            this.tags = list;
        }
    }
}
