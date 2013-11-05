package com.baidu.tieba.square;

import com.baidu.tieba.util.be;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SquareSearchActivity squareSearchActivity) {
        this.f2343a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        as asVar;
        as asVar2;
        try {
            str = this.f2343a.E;
            if (str != null) {
                str2 = this.f2343a.E;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.f1165a);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.f2343a.E;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.f2343a.b();
                    this.f2343a.C = new as(this.f2343a, stringBuffer.toString(), basicNameValuePair, true);
                    asVar = this.f2343a.C;
                    asVar.setPriority(3);
                    asVar2 = this.f2343a.C;
                    asVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
