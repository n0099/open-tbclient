package com.baidu.tieba.mainentrance;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
final class x implements Runnable {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        af afVar;
        af afVar2;
        try {
            str = this.a.C;
            if (str != null) {
                str2 = this.a.C;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.i.a);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.a.C;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.a.a();
                    this.a.A = new af(this.a, stringBuffer.toString(), basicNameValuePair);
                    afVar = this.a.A;
                    afVar.setPriority(3);
                    afVar2 = this.a.A;
                    afVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
