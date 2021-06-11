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
    public String f18141e;

    /* renamed from: f  reason: collision with root package name */
    public long f18142f;

    /* renamed from: g  reason: collision with root package name */
    public long f18143g;

    /* renamed from: h  reason: collision with root package name */
    public String f18144h;

    public void A(long j) {
        this.f18142f = j;
    }

    public long getId() {
        return this.f18143g;
    }

    public String getName() {
        return this.f18144h;
    }

    public void setId(long j) {
        this.f18143g = j;
    }

    public void setName(String str) {
        this.f18144h = str;
    }

    public String w() {
        return this.f18141e;
    }

    public long x() {
        return this.f18142f;
    }

    public void y(HotSearch hotSearch) {
        SearchValue searchValue;
        if (hotSearch == null || (searchValue = hotSearch.search_value) == null) {
            return;
        }
        this.f18141e = hotSearch.search_title;
        this.f18143g = searchValue.id.longValue();
        SearchValue searchValue2 = hotSearch.search_value;
        this.f18144h = searchValue2.name;
        this.f18142f = searchValue2.type.longValue();
    }

    public void z(String str) {
        this.f18141e = str;
    }
}
