package com.baidu.ufosdk.ui;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class r implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22874a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f22875b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22876c;

    public r(FeedbackEditActivity feedbackEditActivity, int i2, j jVar) {
        this.f22876c = feedbackEditActivity;
        this.f22874a = i2;
        this.f22875b = jVar;
    }

    @Override // com.baidu.ufosdk.ui.l
    public final void a() {
        HashMap hashMap;
        List list;
        List list2;
        HashMap hashMap2;
        List list3;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        List list4;
        HashMap hashMap6;
        List list5;
        HashMap hashMap7;
        HashMap hashMap8;
        HashMap hashMap9;
        HashMap hashMap10;
        HashMap hashMap11;
        HashMap hashMap12;
        HashMap hashMap13;
        HashMap hashMap14;
        com.baidu.ufosdk.f.c.a("DeleteConfirmDialog --> confirm clicked!");
        int i2 = this.f22874a;
        if (i2 == 1) {
            list4 = this.f22876c.q;
            int size = list4.size();
            if (size == 1) {
                hashMap6 = this.f22876c.r;
                hashMap6.remove("0");
            } else if (size == 2) {
                hashMap7 = this.f22876c.r;
                hashMap8 = this.f22876c.r;
                hashMap7.put("0", hashMap8.get("1"));
                hashMap9 = this.f22876c.r;
                hashMap9.remove("1");
            } else if (size == 3) {
                hashMap10 = this.f22876c.r;
                hashMap11 = this.f22876c.r;
                hashMap10.put("0", hashMap11.get("1"));
                hashMap12 = this.f22876c.r;
                hashMap13 = this.f22876c.r;
                hashMap12.put("1", hashMap13.get("2"));
                hashMap14 = this.f22876c.r;
                hashMap14.remove("2");
            }
            list5 = this.f22876c.q;
            list5.remove(0);
        } else if (i2 == 2) {
            list2 = this.f22876c.q;
            int size2 = list2.size();
            if (size2 == 2) {
                hashMap2 = this.f22876c.r;
                hashMap2.remove("1");
            } else if (size2 == 3) {
                hashMap3 = this.f22876c.r;
                hashMap4 = this.f22876c.r;
                hashMap3.put("1", hashMap4.get("2"));
                hashMap5 = this.f22876c.r;
                hashMap5.remove("2");
            }
            list3 = this.f22876c.q;
            list3.remove(1);
        } else {
            hashMap = this.f22876c.r;
            hashMap.remove("2");
            list = this.f22876c.q;
            list.remove(2);
        }
        this.f22876c.b();
        this.f22875b.dismiss();
    }

    @Override // com.baidu.ufosdk.ui.l
    public final void b() {
        com.baidu.ufosdk.f.c.a("DeleteConfirmDialog --> cancel clicked!");
        this.f22875b.dismiss();
    }
}
