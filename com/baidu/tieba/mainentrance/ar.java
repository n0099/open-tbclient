package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.mainentrance.SquareSearchActivity;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SquareSearchActivity.a aVar;
        SquareSearchActivity.a aVar2;
        try {
            if (this.bVC.bUV != null && this.bVC.bUV.length() > 0) {
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.bVC.bUV.trim());
                this.bVC.abb();
                this.bVC.bUT = new SquareSearchActivity.a(stringBuffer.toString(), basicNameValuePair, true);
                aVar = this.bVC.bUT;
                aVar.setPriority(3);
                aVar2 = this.bVC.bUT;
                aVar2.execute(stringBuffer.toString(), basicNameValuePair);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
