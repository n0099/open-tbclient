package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, int i) {
        super(i);
        this.bSc = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity aem;
        PersonBarActivity aem2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.bSc.mIsHost;
            if (z) {
                u personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                aem = this.bSc.aem();
                if (aem != null) {
                    aem2 = this.bSc.aem();
                    if (aem2.getRequestCode() != 23011) {
                        view3 = this.bSc.bRU;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.bSc.bRX;
                        if (!z2) {
                            this.bSc.bRX = true;
                            BdListView bdListView = this.bSc.mListView;
                            view2 = this.bSc.bRU;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.bSc.bRU;
                        view.setVisibility(0);
                    }
                    this.bSc.a(personBarData, true);
                }
            }
        }
    }
}
