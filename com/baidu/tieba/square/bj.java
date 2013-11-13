package com.baidu.tieba.square;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2404a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(SquareSearchActivity squareSearchActivity) {
        this.f2404a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        br brVar;
        br brVar2;
        try {
            str = this.f2404a.B;
            if (str != null) {
                str2 = this.f2404a.B;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.f1196a);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.f2404a.B;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.f2404a.a();
                    this.f2404a.z = new br(this.f2404a, stringBuffer.toString(), basicNameValuePair, true);
                    brVar = this.f2404a.z;
                    brVar.setPriority(3);
                    brVar2 = this.f2404a.z;
                    brVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
