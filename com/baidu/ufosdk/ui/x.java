package com.baidu.ufosdk.ui;

import android.graphics.BitmapFactory;
import android.os.Handler;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23301a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f23302b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23303c;

    public x(FeedbackEditActivity feedbackEditActivity, String str, int i) {
        this.f23303c = feedbackEditActivity;
        this.f23301a = str;
        this.f23302b = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0055: IGET  (r2v0 int A[REMOVE]) = (r3v0 'this' com.baidu.ufosdk.ui.x A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.x.b int)] */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] b2;
        HashMap hashMap;
        HashMap hashMap2;
        Handler handler;
        List list;
        List list2;
        List list3;
        com.baidu.ufosdk.f.c.c(" --*^o^*-- return : " + this.f23301a);
        b2 = FeedbackEditActivity.b(BitmapFactory.decodeFile(this.f23301a));
        if (b2 == null || b2.length == 0) {
            return;
        }
        try {
            list = this.f23303c.q;
            if (list.size() == 0) {
                list3 = this.f23303c.q;
                list3.add(b2);
            } else {
                list2 = this.f23303c.q;
                list2.set(this.f23302b, b2);
            }
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.a("arrayList error in readBitmapFromFile!", e2);
        }
        hashMap = this.f23303c.r;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23302b);
        hashMap.put(sb.toString(), this.f23301a);
        StringBuilder sb2 = new StringBuilder("*^o^*-- picPathMap.size : ");
        hashMap2 = this.f23303c.r;
        sb2.append(hashMap2.size());
        com.baidu.ufosdk.f.c.c(sb2.toString());
        handler = this.f23303c.af;
        handler.obtainMessage(17).sendToTarget();
    }
}
