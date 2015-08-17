package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.mainentrance.SquareSearchActivity;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SquareSearchActivity.a aVar;
        SquareSearchActivity.a aVar2;
        try {
            if (this.bQZ.bQt != null && this.bQZ.bQt.length() > 0) {
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.bQZ.bQt.trim());
                this.bQZ.Gt();
                this.bQZ.bQr = new SquareSearchActivity.a(stringBuffer.toString(), basicNameValuePair, true);
                aVar = this.bQZ.bQr;
                aVar.setPriority(3);
                aVar2 = this.bQZ.bQr;
                aVar2.execute(stringBuffer.toString(), basicNameValuePair);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
