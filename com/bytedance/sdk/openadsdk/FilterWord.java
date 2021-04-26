package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FilterWord {

    /* renamed from: a  reason: collision with root package name */
    public String f27773a;

    /* renamed from: b  reason: collision with root package name */
    public String f27774b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27775c;

    /* renamed from: d  reason: collision with root package name */
    public List<FilterWord> f27776d;

    public FilterWord(String str, String str2) {
        this.f27773a = str;
        this.f27774b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f27776d == null) {
            this.f27776d = new ArrayList();
        }
        this.f27776d.add(filterWord);
    }

    public String getId() {
        return this.f27773a;
    }

    public boolean getIsSelected() {
        return this.f27775c;
    }

    public String getName() {
        return this.f27774b;
    }

    public List<FilterWord> getOptions() {
        return this.f27776d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f27776d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f27773a) || TextUtils.isEmpty(this.f27774b)) ? false : true;
    }

    public void setId(String str) {
        this.f27773a = str;
    }

    public void setIsSelected(boolean z) {
        this.f27775c = z;
    }

    public void setName(String str) {
        this.f27774b = str;
    }

    public FilterWord() {
    }
}
