package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.btb = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        ak akVar;
        ak akVar2;
        try {
            str = this.btb.bsO;
            if (str != null) {
                str2 = this.btb.bsO;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.btb.bsO;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.btb.rA();
                    this.btb.bsM = new ak(this.btb, stringBuffer.toString(), basicNameValuePair, true);
                    akVar = this.btb.bsM;
                    akVar.setPriority(3);
                    akVar2 = this.btb.bsM;
                    akVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
