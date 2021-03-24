package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FilterWord {

    /* renamed from: a  reason: collision with root package name */
    public String f27261a;

    /* renamed from: b  reason: collision with root package name */
    public String f27262b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27263c;

    /* renamed from: d  reason: collision with root package name */
    public List<FilterWord> f27264d;

    public FilterWord(String str, String str2) {
        this.f27261a = str;
        this.f27262b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f27264d == null) {
            this.f27264d = new ArrayList();
        }
        this.f27264d.add(filterWord);
    }

    public String getId() {
        return this.f27261a;
    }

    public boolean getIsSelected() {
        return this.f27263c;
    }

    public String getName() {
        return this.f27262b;
    }

    public List<FilterWord> getOptions() {
        return this.f27264d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f27264d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f27261a) || TextUtils.isEmpty(this.f27262b)) ? false : true;
    }

    public void setId(String str) {
        this.f27261a = str;
    }

    public void setIsSelected(boolean z) {
        this.f27263c = z;
    }

    public void setName(String str) {
        this.f27262b = str;
    }

    public FilterWord() {
    }
}
