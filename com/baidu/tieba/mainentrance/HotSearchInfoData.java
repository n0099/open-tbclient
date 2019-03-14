package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HotForum.HotSearch;
/* loaded from: classes6.dex */
public class HotSearchInfoData extends OrmObject {
    public static final int DIRECT_SEARCH_TYPE = 2;
    public static final int FORUM_TYPE = 0;
    public static final int TOPIC_TYPE = 1;
    private String eBN;
    private long eBO;
    private long mId;
    private String mName;

    public String aWi() {
        return this.eBN;
    }

    public long bBw() {
        return this.eBO;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.eBN = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.eBO = hotSearch.search_value.type.longValue();
        }
    }

    public void yk(String str) {
        this.eBN = str;
    }

    public void dr(long j) {
        this.eBO = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
