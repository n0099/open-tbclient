package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FilterWord {

    /* renamed from: a  reason: collision with root package name */
    public String f27050a;

    /* renamed from: b  reason: collision with root package name */
    public String f27051b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27052c;

    /* renamed from: d  reason: collision with root package name */
    public List<FilterWord> f27053d;

    public FilterWord(String str, String str2) {
        this.f27050a = str;
        this.f27051b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f27053d == null) {
            this.f27053d = new ArrayList();
        }
        this.f27053d.add(filterWord);
    }

    public String getId() {
        return this.f27050a;
    }

    public boolean getIsSelected() {
        return this.f27052c;
    }

    public String getName() {
        return this.f27051b;
    }

    public List<FilterWord> getOptions() {
        return this.f27053d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f27053d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f27050a) || TextUtils.isEmpty(this.f27051b)) ? false : true;
    }

    public void setId(String str) {
        this.f27050a = str;
    }

    public void setIsSelected(boolean z) {
        this.f27052c = z;
    }

    public void setName(String str) {
        this.f27051b = str;
    }

    public FilterWord() {
    }
}
