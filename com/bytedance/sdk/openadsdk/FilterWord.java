package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FilterWord {

    /* renamed from: a  reason: collision with root package name */
    public String f26947a;

    /* renamed from: b  reason: collision with root package name */
    public String f26948b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26949c;

    /* renamed from: d  reason: collision with root package name */
    public List<FilterWord> f26950d;

    public FilterWord(String str, String str2) {
        this.f26947a = str;
        this.f26948b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f26950d == null) {
            this.f26950d = new ArrayList();
        }
        this.f26950d.add(filterWord);
    }

    public String getId() {
        return this.f26947a;
    }

    public boolean getIsSelected() {
        return this.f26949c;
    }

    public String getName() {
        return this.f26948b;
    }

    public List<FilterWord> getOptions() {
        return this.f26950d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f26950d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f26947a) || TextUtils.isEmpty(this.f26948b)) ? false : true;
    }

    public void setId(String str) {
        this.f26947a = str;
    }

    public void setIsSelected(boolean z) {
        this.f26949c = z;
    }

    public void setName(String str) {
        this.f26948b = str;
    }

    public FilterWord() {
    }
}
