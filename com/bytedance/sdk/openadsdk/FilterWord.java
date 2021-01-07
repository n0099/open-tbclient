package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FilterWord {

    /* renamed from: a  reason: collision with root package name */
    private String f6369a;

    /* renamed from: b  reason: collision with root package name */
    private String f6370b;
    private boolean c;
    private List<FilterWord> d;

    public FilterWord(String str, String str2) {
        this.f6369a = str;
        this.f6370b = str2;
    }

    public FilterWord() {
    }

    public String getId() {
        return this.f6369a;
    }

    public void setId(String str) {
        this.f6369a = str;
    }

    public String getName() {
        return this.f6370b;
    }

    public void setName(String str) {
        this.f6370b = str;
    }

    public boolean getIsSelected() {
        return this.c;
    }

    public void setIsSelected(boolean z) {
        this.c = z;
    }

    public List<FilterWord> getOptions() {
        return this.d;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord != null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(filterWord);
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f6369a) || TextUtils.isEmpty(this.f6370b)) ? false : true;
    }

    public boolean hasSecondOptions() {
        return (this.d == null || this.d.isEmpty()) ? false : true;
    }
}
