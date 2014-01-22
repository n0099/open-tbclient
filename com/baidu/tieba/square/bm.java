package com.baidu.tieba.square;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class bm implements Runnable {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        bu buVar;
        bu buVar2;
        try {
            str = this.a.C;
            if (str != null) {
                str2 = this.a.C;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.a);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.a.C;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.a.a();
                    this.a.A = new bu(this.a, stringBuffer.toString(), basicNameValuePair, true);
                    buVar = this.a.A;
                    buVar.setPriority(3);
                    buVar2 = this.a.A;
                    buVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
