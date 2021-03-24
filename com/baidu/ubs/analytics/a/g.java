package com.baidu.ubs.analytics.a;

import java.io.Serializable;
/* loaded from: classes5.dex */
public final class g implements Serializable {
    public String S;
    public String group;
    public String id;

    public final String L() {
        return this.S;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getId() {
        return this.id;
    }

    public final void setGroup(String str) {
        this.group = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void y(String str) {
        this.S = str;
    }
}
