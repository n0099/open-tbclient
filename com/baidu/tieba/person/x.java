package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(t tVar, int i) {
        super(i);
        this.eeh = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity aKx;
        PersonBarActivity aKx2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.eeh.cgJ;
            if (z) {
                s personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                aKx = this.eeh.aKx();
                if (aKx != null) {
                    if (personBarData != null) {
                        this.eeh.eea = true;
                    }
                    aKx2 = this.eeh.aKx();
                    if (aKx2.getRequestCode() != 23011) {
                        view3 = this.eeh.edY;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.eeh.eeb;
                        if (!z2) {
                            this.eeh.eeb = true;
                            BdListView bdListView = this.eeh.zt;
                            view2 = this.eeh.edY;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.eeh.edY;
                        view.setVisibility(0);
                    }
                    this.eeh.a(personBarData, true);
                }
            }
        }
    }
}
