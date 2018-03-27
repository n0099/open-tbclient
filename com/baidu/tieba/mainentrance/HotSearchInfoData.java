package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HotForum.HotSearch;
/* loaded from: classes3.dex */
public class HotSearchInfoData extends OrmObject {
    public static final int DIRECT_SEARCH_TYPE = 2;
    public static final int FORUM_TYPE = 0;
    public static final int TOPIC_TYPE = 1;
    private String doZ;
    private long dpa;
    private long mId;
    private String mName;

    public String aqn() {
        return this.doZ;
    }

    public long aRt() {
        return this.dpa;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.doZ = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dpa = hotSearch.search_value.type.longValue();
        }
    }

    public void oE(String str) {
        this.doZ = str;
    }

    public void cl(long j) {
        this.dpa = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
