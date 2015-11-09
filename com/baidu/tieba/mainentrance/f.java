package com.baidu.tieba.mainentrance;

import tbclient.HotForum.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String aLC;
    private long aLD;
    private long mId;
    private String mName;

    public String Im() {
        return this.aLC;
    }

    public long getType() {
        return this.aLD;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aLC = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aLD = hotSearch.search_value.type.longValue();
        }
    }

    public void iX(String str) {
        this.aLC = str;
    }

    public void aN(long j) {
        this.aLD = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
