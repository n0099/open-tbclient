package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(s sVar, int i) {
        super(i);
        this.dvP = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity aBC;
        PersonBarActivity aBC2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.dvP.bIW;
            if (z) {
                r personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                aBC = this.dvP.aBC();
                if (aBC != null) {
                    if (personBarData != null) {
                        this.dvP.dvI = true;
                    }
                    aBC2 = this.dvP.aBC();
                    if (aBC2.getRequestCode() != 23011) {
                        view3 = this.dvP.dvG;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.dvP.dvJ;
                        if (!z2) {
                            this.dvP.dvJ = true;
                            BdListView bdListView = this.dvP.zu;
                            view2 = this.dvP.dvG;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.dvP.dvG;
                        view.setVisibility(0);
                    }
                    this.dvP.a(personBarData, true);
                }
            }
        }
    }
}
