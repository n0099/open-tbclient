package com.baidu.tieba.mainentrance;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        ai aiVar;
        ai aiVar2;
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
                    this.a.A = new ai(this.a, stringBuffer.toString(), basicNameValuePair, true);
                    aiVar = this.a.A;
                    aiVar.setPriority(3);
                    aiVar2 = this.a.A;
                    aiVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
