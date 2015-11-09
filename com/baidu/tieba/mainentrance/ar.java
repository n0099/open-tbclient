package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.mainentrance.SquareSearchActivity;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SquareSearchActivity.a aVar;
        SquareSearchActivity.a aVar2;
        try {
            if (this.bWd.bVw != null && this.bWd.bVw.length() > 0) {
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.bWd.bVw.trim());
                this.bWd.abw();
                this.bWd.bVu = new SquareSearchActivity.a(stringBuffer.toString(), basicNameValuePair, true);
                aVar = this.bWd.bVu;
                aVar.setPriority(3);
                aVar2 = this.bWd.bVu;
                aVar2.execute(stringBuffer.toString(), basicNameValuePair);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
