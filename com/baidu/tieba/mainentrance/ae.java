package com.baidu.tieba.mainentrance;

import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
class ae extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(SquareSearchActivity squareSearchActivity, int i, boolean z) {
        super(i, z);
        this.btb = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        TextView textView;
        TextView textView2;
        textView = this.btb.bsy;
        if (textView != null) {
            textView2 = this.btb.bsy;
            textView2.setClickable(true);
        }
        if (httpResponsedMessage instanceof FrsPageHttpResponseMessage) {
            this.btb.a(httpResponsedMessage, !((FrsPageHttpResponseMessage) httpResponsedMessage).hasNetworkError());
        }
    }
}
