package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class an implements Runnable {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        aq aqVar;
        aq aqVar2;
        try {
            str = this.bzG.bzm;
            if (str != null) {
                str2 = this.bzG.bzm;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.bzG.bzm;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.bzG.EI();
                    this.bzG.bzk = new aq(this.bzG, stringBuffer.toString(), basicNameValuePair, true);
                    aqVar = this.bzG.bzk;
                    aqVar.setPriority(3);
                    aqVar2 = this.bzG.bzk;
                    aqVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
