package com.baidu.tieba.voice.a;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<String> f2610a = new LinkedList<>();
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    public String a(String str, String str2, c cVar) {
        if (!this.f2610a.contains(str)) {
            this.f2610a.add(str);
        }
        d a2 = f.a().a(this.b, str, str2, new b(this, cVar));
        if (a2 == null) {
            return null;
        }
        return a2.b;
    }

    public void a() {
        if (this.f2610a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f2610a.size()) {
                    String str = this.f2610a.get(i2);
                    if (str != null) {
                        f.a().a(this.b, str);
                    }
                    i = i2 + 1;
                } else {
                    this.f2610a.clear();
                    return;
                }
            }
        }
    }
}
