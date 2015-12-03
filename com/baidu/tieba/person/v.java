package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(s sVar, int i) {
        super(i);
        this.cKg = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity anx;
        PersonBarActivity anx2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.cKg.mIsHost;
            if (z) {
                r personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                anx = this.cKg.anx();
                if (anx != null) {
                    if (personBarData != null) {
                        this.cKg.cKa = true;
                    }
                    anx2 = this.cKg.anx();
                    if (anx2.getRequestCode() != 23011) {
                        view3 = this.cKg.cJY;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.cKg.cKb;
                        if (!z2) {
                            this.cKg.cKb = true;
                            BdListView bdListView = this.cKg.mListView;
                            view2 = this.cKg.cJY;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.cKg.cJY;
                        view.setVisibility(0);
                    }
                    this.cKg.a(personBarData, true);
                }
            }
        }
    }
}
