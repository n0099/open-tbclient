package com.baidu.tieba.mainentrance;

import tbclient.HotForum.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String aTT;
    private long aTU;
    private long mId;
    private String mName;

    public String JV() {
        return this.aTT;
    }

    public long getType() {
        return this.aTU;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aTT = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aTU = hotSearch.search_value.type.longValue();
        }
    }

    public void jG(String str) {
        this.aTT = str;
    }

    public void bg(long j) {
        this.aTU = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
