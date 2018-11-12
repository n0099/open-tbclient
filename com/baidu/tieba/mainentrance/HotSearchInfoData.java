package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HotForum.HotSearch;
/* loaded from: classes3.dex */
public class HotSearchInfoData extends OrmObject {
    public static final int DIRECT_SEARCH_TYPE = 2;
    public static final int FORUM_TYPE = 0;
    public static final int TOPIC_TYPE = 1;
    private String dhp;
    private long dhq;
    private long mId;
    private String mName;

    public String atg() {
        return this.dhp;
    }

    public long aXO() {
        return this.dhq;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.dhp = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dhq = hotSearch.search_value.type.longValue();
        }
    }

    public void qM(String str) {
        this.dhp = str;
    }

    public void cA(long j) {
        this.dhq = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
