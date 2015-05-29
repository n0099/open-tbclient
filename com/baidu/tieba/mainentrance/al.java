package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        ao aoVar;
        ao aoVar2;
        try {
            str = this.bCE.bCf;
            if (str != null) {
                str2 = this.bCE.bCf;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append("c/f/forum/search");
                    str3 = this.bCE.bCf;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", str3.trim());
                    this.bCE.FG();
                    this.bCE.bCd = new ao(this.bCE, stringBuffer.toString(), basicNameValuePair, true);
                    aoVar = this.bCE.bCd;
                    aoVar.setPriority(3);
                    aoVar2 = this.bCE.bCd;
                    aoVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
