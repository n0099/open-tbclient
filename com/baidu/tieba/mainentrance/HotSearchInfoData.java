package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HotForum.HotSearch;
/* loaded from: classes3.dex */
public class HotSearchInfoData extends OrmObject {
    public static final int FORUM_TYPE = 0;
    public static final int TOPIC_TYPE = 1;
    private String doW;
    private long doX;
    private long mId;
    private String mName;

    public String aqm() {
        return this.doW;
    }

    public long aRs() {
        return this.doX;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.doW = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.doX = hotSearch.search_value.type.longValue();
        }
    }

    public void oE(String str) {
        this.doW = str;
    }

    public void cl(long j) {
        this.doX = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
