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
    public String f18155e;

    /* renamed from: f  reason: collision with root package name */
    public long f18156f;

    /* renamed from: g  reason: collision with root package name */
    public long f18157g;

    /* renamed from: h  reason: collision with root package name */
    public String f18158h;

    public long getId() {
        return this.f18157g;
    }

    public String getName() {
        return this.f18158h;
    }

    public String s() {
        return this.f18155e;
    }

    public void setId(long j) {
        this.f18157g = j;
    }

    public void setName(String str) {
        this.f18158h = str;
    }

    public long t() {
        return this.f18156f;
    }

    public void u(HotSearch hotSearch) {
        SearchValue searchValue;
        if (hotSearch == null || (searchValue = hotSearch.search_value) == null) {
            return;
        }
        this.f18155e = hotSearch.search_title;
        this.f18157g = searchValue.id.longValue();
        SearchValue searchValue2 = hotSearch.search_value;
        this.f18158h = searchValue2.name;
        this.f18156f = searchValue2.type.longValue();
    }

    public void v(String str) {
        this.f18155e = str;
    }

    public void w(long j) {
        this.f18156f = j;
    }
}
