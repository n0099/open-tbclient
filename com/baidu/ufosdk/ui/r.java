package com.baidu.ufosdk.ui;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class r implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23293a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f23294b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23295c;

    public r(FeedbackEditActivity feedbackEditActivity, int i, j jVar) {
        this.f23295c = feedbackEditActivity;
        this.f23293a = i;
        this.f23294b = jVar;
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
        int i = this.f23293a;
        if (i == 1) {
            list4 = this.f23295c.q;
            int size = list4.size();
            if (size == 1) {
                hashMap6 = this.f23295c.r;
                hashMap6.remove("0");
            } else if (size == 2) {
                hashMap7 = this.f23295c.r;
                hashMap8 = this.f23295c.r;
                hashMap7.put("0", hashMap8.get("1"));
                hashMap9 = this.f23295c.r;
                hashMap9.remove("1");
            } else if (size == 3) {
                hashMap10 = this.f23295c.r;
                hashMap11 = this.f23295c.r;
                hashMap10.put("0", hashMap11.get("1"));
                hashMap12 = this.f23295c.r;
                hashMap13 = this.f23295c.r;
                hashMap12.put("1", hashMap13.get("2"));
                hashMap14 = this.f23295c.r;
                hashMap14.remove("2");
            }
            list5 = this.f23295c.q;
            list5.remove(0);
        } else if (i == 2) {
            list2 = this.f23295c.q;
            int size2 = list2.size();
            if (size2 == 2) {
                hashMap2 = this.f23295c.r;
                hashMap2.remove("1");
            } else if (size2 == 3) {
                hashMap3 = this.f23295c.r;
                hashMap4 = this.f23295c.r;
                hashMap3.put("1", hashMap4.get("2"));
                hashMap5 = this.f23295c.r;
                hashMap5.remove("2");
            }
            list3 = this.f23295c.q;
            list3.remove(1);
        } else {
            hashMap = this.f23295c.r;
            hashMap.remove("2");
            list = this.f23295c.q;
            list.remove(2);
        }
        this.f23295c.b();
        this.f23294b.dismiss();
    }

    @Override // com.baidu.ufosdk.ui.l
    public final void b() {
        com.baidu.ufosdk.f.c.a("DeleteConfirmDialog --> cancel clicked!");
        this.f23294b.dismiss();
    }
}
