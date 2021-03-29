package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FilterWord {

    /* renamed from: a  reason: collision with root package name */
    public String f27262a;

    /* renamed from: b  reason: collision with root package name */
    public String f27263b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27264c;

    /* renamed from: d  reason: collision with root package name */
    public List<FilterWord> f27265d;

    public FilterWord(String str, String str2) {
        this.f27262a = str;
        this.f27263b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f27265d == null) {
            this.f27265d = new ArrayList();
        }
        this.f27265d.add(filterWord);
    }

    public String getId() {
        return this.f27262a;
    }

    public boolean getIsSelected() {
        return this.f27264c;
    }

    public String getName() {
        return this.f27263b;
    }

    public List<FilterWord> getOptions() {
        return this.f27265d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f27265d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f27262a) || TextUtils.isEmpty(this.f27263b)) ? false : true;
    }

    public void setId(String str) {
        this.f27262a = str;
    }

    public void setIsSelected(boolean z) {
        this.f27264c = z;
    }

    public void setName(String str) {
        this.f27263b = str;
    }

    public FilterWord() {
    }
}
