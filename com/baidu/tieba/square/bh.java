package com.baidu.tieba.square;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(SquareSearchActivity squareSearchActivity) {
        this.f2504a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        bp bpVar;
        bp bpVar2;
        try {
            str = this.f2504a.B;
            if (str != null) {
                str2 = this.f2504a.B;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.f1248a);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.f2504a.B;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.f2504a.a();
                    this.f2504a.z = new bp(this.f2504a, stringBuffer.toString(), basicNameValuePair, true);
                    bpVar = this.f2504a.z;
                    bpVar.setPriority(3);
                    bpVar2 = this.f2504a.z;
                    bpVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
