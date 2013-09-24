package com.baidu.tieba.square;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f1822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SquareSearchActivity squareSearchActivity) {
        this.f1822a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        as asVar;
        as asVar2;
        try {
            str = this.f1822a.E;
            if (str != null) {
                str2 = this.f1822a.E;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.g.f1032a);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.f1822a.E;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.f1822a.b();
                    this.f1822a.C = new as(this.f1822a, stringBuffer.toString(), basicNameValuePair, true);
                    asVar = this.f1822a.C;
                    asVar.setPriority(3);
                    asVar2 = this.f1822a.C;
                    asVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
