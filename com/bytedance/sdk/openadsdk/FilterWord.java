package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FilterWord {

    /* renamed from: a  reason: collision with root package name */
    public String f27018a;

    /* renamed from: b  reason: collision with root package name */
    public String f27019b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27020c;

    /* renamed from: d  reason: collision with root package name */
    public List<FilterWord> f27021d;

    public FilterWord(String str, String str2) {
        this.f27018a = str;
        this.f27019b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f27021d == null) {
            this.f27021d = new ArrayList();
        }
        this.f27021d.add(filterWord);
    }

    public String getId() {
        return this.f27018a;
    }

    public boolean getIsSelected() {
        return this.f27020c;
    }

    public String getName() {
        return this.f27019b;
    }

    public List<FilterWord> getOptions() {
        return this.f27021d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f27021d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f27018a) || TextUtils.isEmpty(this.f27019b)) ? false : true;
    }

    public void setId(String str) {
        this.f27018a = str;
    }

    public void setIsSelected(boolean z) {
        this.f27020c = z;
    }

    public void setName(String str) {
        this.f27019b = str;
    }

    public FilterWord() {
    }
}
