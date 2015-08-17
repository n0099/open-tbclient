package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(r rVar, int i) {
        super(i);
        this.ciI = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity agd;
        PersonBarActivity agd2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            this.ciI.ciC = true;
            z = this.ciI.mIsHost;
            if (z) {
                q personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                agd = this.ciI.agd();
                if (agd != null) {
                    agd2 = this.ciI.agd();
                    if (agd2.getRequestCode() != 23011) {
                        view3 = this.ciI.ciz;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.ciI.ciD;
                        if (!z2) {
                            this.ciI.ciD = true;
                            BdListView bdListView = this.ciI.mListView;
                            view2 = this.ciI.ciz;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.ciI.ciz;
                        view.setVisibility(0);
                    }
                    this.ciI.a(personBarData, true);
                }
            }
        }
    }
}
