package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HotForum.HotSearch;
/* loaded from: classes3.dex */
public class HotSearchInfoData extends OrmObject {
    public static final int FORUM_TYPE = 0;
    public static final int TOPIC_TYPE = 1;
    private String dpi;
    private long dpj;
    private long mId;
    private String mName;

    public String aqn() {
        return this.dpi;
    }

    public long aRt() {
        return this.dpj;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.dpi = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dpj = hotSearch.search_value.type.longValue();
        }
    }

    public void oE(String str) {
        this.dpi = str;
    }

    public void cl(long j) {
        this.dpj = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
