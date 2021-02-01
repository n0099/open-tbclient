package com.baidu.ufosdk.ui;

import android.graphics.BitmapFactory;
import android.os.Handler;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5618a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5619b;
    final /* synthetic */ FeedbackEditActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FeedbackEditActivity feedbackEditActivity, String str, int i) {
        this.c = feedbackEditActivity;
        this.f5618a = str;
        this.f5619b = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0044: IGET  (r2v0 int A[REMOVE]) = (r3v0 'this' com.baidu.ufosdk.ui.x A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.x.b int)] */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] b2;
        HashMap hashMap;
        HashMap hashMap2;
        Handler handler;
        List list;
        List list2;
        List list3;
        com.baidu.ufosdk.f.c.c(" --*^o^*-- return : " + this.f5618a);
        b2 = FeedbackEditActivity.b(BitmapFactory.decodeFile(this.f5618a));
        if (b2 == null || b2.length == 0) {
            return;
        }
        try {
            list = this.c.q;
            if (list.size() == 0) {
                list3 = this.c.q;
                list3.add(b2);
            } else {
                list2 = this.c.q;
                list2.set(this.f5619b, b2);
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("arrayList error in readBitmapFromFile!", e);
        }
        hashMap = this.c.r;
        hashMap.put(new StringBuilder().append(this.f5619b).toString(), this.f5618a);
        StringBuilder sb = new StringBuilder("*^o^*-- picPathMap.size : ");
        hashMap2 = this.c.r;
        com.baidu.ufosdk.f.c.c(sb.append(hashMap2.size()).toString());
        handler = this.c.af;
        handler.obtainMessage(17).sendToTarget();
    }
}
