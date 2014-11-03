package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        aj ajVar;
        aj ajVar2;
        try {
            str = this.bnc.bmO;
            if (str != null) {
                str2 = this.bnc.bmO;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.bnc.bmO;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.bnc.oo();
                    this.bnc.bmM = new aj(this.bnc, stringBuffer.toString(), basicNameValuePair, true);
                    ajVar = this.bnc.bmM;
                    ajVar.setPriority(3);
                    ajVar2 = this.bnc.bmM;
                    ajVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
