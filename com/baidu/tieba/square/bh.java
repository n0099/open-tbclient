package com.baidu.tieba.square;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class bh implements Runnable {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        bp bpVar;
        bp bpVar2;
        try {
            str = this.a.B;
            if (str != null) {
                str2 = this.a.B;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.a);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.a.B;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.a.a();
                    this.a.z = new bp(this.a, stringBuffer.toString(), basicNameValuePair, true);
                    bpVar = this.a.z;
                    bpVar.setPriority(3);
                    bpVar2 = this.a.z;
                    bpVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
