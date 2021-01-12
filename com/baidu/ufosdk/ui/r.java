package com.baidu.ufosdk.ui;

import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class r implements l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f5609a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j f5610b;
    final /* synthetic */ FeedbackEditActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FeedbackEditActivity feedbackEditActivity, int i, j jVar) {
        this.c = feedbackEditActivity;
        this.f5609a = i;
        this.f5610b = jVar;
    }

    @Override // com.baidu.ufosdk.ui.l
    public final void a() {
        HashMap hashMap;
        List list;
        List list2;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        List list3;
        List list4;
        HashMap hashMap6;
        HashMap hashMap7;
        HashMap hashMap8;
        HashMap hashMap9;
        HashMap hashMap10;
        HashMap hashMap11;
        HashMap hashMap12;
        HashMap hashMap13;
        HashMap hashMap14;
        List list5;
        com.baidu.ufosdk.f.c.a("DeleteConfirmDialog --> confirm clicked!");
        if (this.f5609a == 1) {
            list4 = this.c.q;
            switch (list4.size()) {
                case 1:
                    hashMap14 = this.c.r;
                    hashMap14.remove("0");
                    break;
                case 2:
                    hashMap11 = this.c.r;
                    hashMap12 = this.c.r;
                    hashMap11.put("0", hashMap12.get("1"));
                    hashMap13 = this.c.r;
                    hashMap13.remove("1");
                    break;
                case 3:
                    hashMap6 = this.c.r;
                    hashMap7 = this.c.r;
                    hashMap6.put("0", hashMap7.get("1"));
                    hashMap8 = this.c.r;
                    hashMap9 = this.c.r;
                    hashMap8.put("1", hashMap9.get("2"));
                    hashMap10 = this.c.r;
                    hashMap10.remove("2");
                    break;
            }
            list5 = this.c.q;
            list5.remove(0);
        } else if (this.f5609a == 2) {
            list2 = this.c.q;
            switch (list2.size()) {
                case 2:
                    hashMap5 = this.c.r;
                    hashMap5.remove("1");
                    break;
                case 3:
                    hashMap2 = this.c.r;
                    hashMap3 = this.c.r;
                    hashMap2.put("1", hashMap3.get("2"));
                    hashMap4 = this.c.r;
                    hashMap4.remove("2");
                    break;
            }
            list3 = this.c.q;
            list3.remove(1);
        } else {
            hashMap = this.c.r;
            hashMap.remove("2");
            list = this.c.q;
            list.remove(2);
        }
        this.c.b();
        this.f5610b.dismiss();
    }

    @Override // com.baidu.ufosdk.ui.l
    public final void b() {
        com.baidu.ufosdk.f.c.a("DeleteConfirmDialog --> cancel clicked!");
        this.f5610b.dismiss();
    }
}
