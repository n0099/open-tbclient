package com.baidu.tieba.mainentrance;

import tbclient.HotForum.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String aQb;
    private long aQc;
    private long mId;
    private String mName;

    public String JE() {
        return this.aQb;
    }

    public long getType() {
        return this.aQc;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aQb = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aQc = hotSearch.search_value.type.longValue();
        }
    }

    public void js(String str) {
        this.aQb = str;
    }

    public void bb(long j) {
        this.aQc = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
