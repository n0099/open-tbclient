package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.mainentrance.SquareSearchActivity;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SquareSearchActivity.a aVar;
        SquareSearchActivity.a aVar2;
        if (!this.cMQ.aoZ()) {
            try {
                if (this.cMQ.cMj != null && this.cMQ.cMj.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append("c/f/forum/search");
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.cMQ.cMj.trim());
                    this.cMQ.aoD();
                    this.cMQ.cMg = new SquareSearchActivity.a(stringBuffer.toString(), basicNameValuePair, true);
                    aVar = this.cMQ.cMg;
                    aVar.setPriority(3);
                    aVar2 = this.cMQ.cMg;
                    aVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
