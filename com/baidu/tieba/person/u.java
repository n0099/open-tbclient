package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(r rVar, int i) {
        super(i);
        this.cjC = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity agt;
        PersonBarActivity agt2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            this.cjC.cjw = true;
            z = this.cjC.mIsHost;
            if (z) {
                q personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                agt = this.cjC.agt();
                if (agt != null) {
                    agt2 = this.cjC.agt();
                    if (agt2.getRequestCode() != 23011) {
                        view3 = this.cjC.cjt;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.cjC.cjx;
                        if (!z2) {
                            this.cjC.cjx = true;
                            BdListView bdListView = this.cjC.mListView;
                            view2 = this.cjC.cjt;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.cjC.cjt;
                        view.setVisibility(0);
                    }
                    this.cjC.a(personBarData, true);
                }
            }
        }
    }
}
