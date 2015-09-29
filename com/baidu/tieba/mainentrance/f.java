package com.baidu.tieba.mainentrance;

import tbclient.HotForum.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String aLj;
    private long aLk;
    private long mId;
    private String mName;

    public String Ia() {
        return this.aLj;
    }

    public long getType() {
        return this.aLk;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aLj = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aLk = hotSearch.search_value.type.longValue();
        }
    }

    public void iV(String str) {
        this.aLj = str;
    }

    public void aF(long j) {
        this.aLk = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
