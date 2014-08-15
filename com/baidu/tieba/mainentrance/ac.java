package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        ag agVar;
        ag agVar2;
        try {
            str = this.a.y;
            if (str != null) {
                str2 = this.a.y;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.a.y;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.a.a();
                    this.a.w = new ag(this.a, stringBuffer.toString(), basicNameValuePair, true);
                    agVar = this.a.w;
                    agVar.setPriority(3);
                    agVar2 = this.a.w;
                    agVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
