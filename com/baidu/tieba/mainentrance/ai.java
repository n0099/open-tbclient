package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ SquareSearchActivity bta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.bta = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        ak akVar;
        ak akVar2;
        try {
            str = this.bta.bsN;
            if (str != null) {
                str2 = this.bta.bsN;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.bta.bsN;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.bta.ru();
                    this.bta.bsL = new ak(this.bta, stringBuffer.toString(), basicNameValuePair, true);
                    akVar = this.bta.bsL;
                    akVar.setPriority(3);
                    akVar2 = this.bta.bsL;
                    akVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
