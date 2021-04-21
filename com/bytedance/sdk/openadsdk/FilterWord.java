package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FilterWord {

    /* renamed from: a  reason: collision with root package name */
    public String f26955a;

    /* renamed from: b  reason: collision with root package name */
    public String f26956b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26957c;

    /* renamed from: d  reason: collision with root package name */
    public List<FilterWord> f26958d;

    public FilterWord(String str, String str2) {
        this.f26955a = str;
        this.f26956b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f26958d == null) {
            this.f26958d = new ArrayList();
        }
        this.f26958d.add(filterWord);
    }

    public String getId() {
        return this.f26955a;
    }

    public boolean getIsSelected() {
        return this.f26957c;
    }

    public String getName() {
        return this.f26956b;
    }

    public List<FilterWord> getOptions() {
        return this.f26958d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f26958d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f26955a) || TextUtils.isEmpty(this.f26956b)) ? false : true;
    }

    public void setId(String str) {
        this.f26955a = str;
    }

    public void setIsSelected(boolean z) {
        this.f26957c = z;
    }

    public void setName(String str) {
        this.f26956b = str;
    }

    public FilterWord() {
    }
}
