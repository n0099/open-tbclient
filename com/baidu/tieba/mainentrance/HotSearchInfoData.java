package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HotForum.HotSearch;
import tbclient.HotForum.SearchValue;
/* loaded from: classes3.dex */
public class HotSearchInfoData extends OrmObject {
    public static final int DIRECT_SEARCH_TYPE = 2;
    public static final int FORUM_TYPE = 0;
    public static final int TOPIC_TYPE = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f18474e;

    /* renamed from: f  reason: collision with root package name */
    public long f18475f;

    /* renamed from: g  reason: collision with root package name */
    public long f18476g;

    /* renamed from: h  reason: collision with root package name */
    public String f18477h;

    public long getId() {
        return this.f18476g;
    }

    public String getName() {
        return this.f18477h;
    }

    public String s() {
        return this.f18474e;
    }

    public void setId(long j) {
        this.f18476g = j;
    }

    public void setName(String str) {
        this.f18477h = str;
    }

    public long t() {
        return this.f18475f;
    }

    public void u(HotSearch hotSearch) {
        SearchValue searchValue;
        if (hotSearch == null || (searchValue = hotSearch.search_value) == null) {
            return;
        }
        this.f18474e = hotSearch.search_title;
        this.f18476g = searchValue.id.longValue();
        SearchValue searchValue2 = hotSearch.search_value;
        this.f18477h = searchValue2.name;
        this.f18475f = searchValue2.type.longValue();
    }

    public void v(String str) {
        this.f18474e = str;
    }

    public void w(long j) {
        this.f18475f = j;
    }
}
