package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.mainentrance.SquareSearchActivity;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SquareSearchActivity.a aVar;
        SquareSearchActivity.a aVar2;
        try {
            if (this.cmr.clJ != null && this.cmr.clJ.length() > 0) {
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.cmr.clJ.trim());
                this.cmr.afc();
                this.cmr.clG = new SquareSearchActivity.a(stringBuffer.toString(), basicNameValuePair, true);
                aVar = this.cmr.clG;
                aVar.setPriority(3);
                aVar2 = this.cmr.clG;
                aVar2.execute(stringBuffer.toString(), basicNameValuePair);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
