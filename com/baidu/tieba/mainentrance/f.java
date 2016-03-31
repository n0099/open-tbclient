package com.baidu.tieba.mainentrance;

import tbclient.HotForum.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String baJ;
    private long baK;
    private long mId;
    private String mName;

    public String Nz() {
        return this.baJ;
    }

    public long NA() {
        return this.baK;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.baJ = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.baK = hotSearch.search_value.type.longValue();
        }
    }

    public void ky(String str) {
        this.baJ = str;
    }

    public void bq(long j) {
        this.baK = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
