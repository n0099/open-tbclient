package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.mainentrance.SquareSearchActivity;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ SquareSearchActivity bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SquareSearchActivity squareSearchActivity) {
        this.bRF = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SquareSearchActivity.a aVar;
        SquareSearchActivity.a aVar2;
        try {
            if (this.bRF.bQZ != null && this.bRF.bQZ.length() > 0) {
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.bRF.bQZ.trim());
                this.bRF.ZV();
                this.bRF.bQX = new SquareSearchActivity.a(stringBuffer.toString(), basicNameValuePair, true);
                aVar = this.bRF.bQX;
                aVar.setPriority(3);
                aVar2 = this.bRF.bQX;
                aVar2.execute(stringBuffer.toString(), basicNameValuePair);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
