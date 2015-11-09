package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(r rVar, int i) {
        super(i);
        this.cqM = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity aiU;
        PersonBarActivity aiU2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            this.cqM.cqG = true;
            z = this.cqM.mIsHost;
            if (z) {
                q personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                aiU = this.cqM.aiU();
                if (aiU != null) {
                    aiU2 = this.cqM.aiU();
                    if (aiU2.getRequestCode() != 23011) {
                        view3 = this.cqM.cqD;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.cqM.cqH;
                        if (!z2) {
                            this.cqM.cqH = true;
                            BdListView bdListView = this.cqM.mListView;
                            view2 = this.cqM.cqD;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.cqM.cqD;
                        view.setVisibility(0);
                    }
                    this.cqM.a(personBarData, true);
                }
            }
        }
    }
}
