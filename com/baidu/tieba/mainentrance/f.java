package com.baidu.tieba.mainentrance;

import tbclient.HotForum.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String aLu;
    private long aLv;
    private long mId;
    private String mName;

    public String Ia() {
        return this.aLu;
    }

    public long getType() {
        return this.aLv;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aLu = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aLv = hotSearch.search_value.type.longValue();
        }
    }

    public void iV(String str) {
        this.aLu = str;
    }

    public void aP(long j) {
        this.aLv = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
