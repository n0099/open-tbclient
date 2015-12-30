package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(s sVar, int i) {
        super(i);
        this.cOw = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity aoI;
        PersonBarActivity aoI2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.cOw.mIsHost;
            if (z) {
                r personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                aoI = this.cOw.aoI();
                if (aoI != null) {
                    if (personBarData != null) {
                        this.cOw.cOq = true;
                    }
                    aoI2 = this.cOw.aoI();
                    if (aoI2.getRequestCode() != 23011) {
                        view3 = this.cOw.cOo;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.cOw.cOr;
                        if (!z2) {
                            this.cOw.cOr = true;
                            BdListView bdListView = this.cOw.mListView;
                            view2 = this.cOw.cOo;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.cOw.cOo;
                        view.setVisibility(0);
                    }
                    this.cOw.a(personBarData, true);
                }
            }
        }
    }
}
