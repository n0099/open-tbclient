package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(r rVar, int i) {
        super(i);
        this.cpq = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity ais;
        PersonBarActivity ais2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            this.cpq.cpk = true;
            z = this.cpq.mIsHost;
            if (z) {
                q personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                ais = this.cpq.ais();
                if (ais != null) {
                    ais2 = this.cpq.ais();
                    if (ais2.getRequestCode() != 23011) {
                        view3 = this.cpq.cph;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.cpq.cpl;
                        if (!z2) {
                            this.cpq.cpl = true;
                            BdListView bdListView = this.cpq.mListView;
                            view2 = this.cpq.cph;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.cpq.cph;
                        view.setVisibility(0);
                    }
                    this.cpq.a(personBarData, true);
                }
            }
        }
    }
}
