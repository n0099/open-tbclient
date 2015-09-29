package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ r cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(r rVar, int i) {
        super(i);
        this.cpf = rVar;
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
            this.cpf.coZ = true;
            z = this.cpf.mIsHost;
            if (z) {
                q personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                ais = this.cpf.ais();
                if (ais != null) {
                    ais2 = this.cpf.ais();
                    if (ais2.getRequestCode() != 23011) {
                        view3 = this.cpf.coW;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.cpf.cpa;
                        if (!z2) {
                            this.cpf.cpa = true;
                            BdListView bdListView = this.cpf.mListView;
                            view2 = this.cpf.coW;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.cpf.coW;
                        view.setVisibility(0);
                    }
                    this.cpf.a(personBarData, true);
                }
            }
        }
    }
}
