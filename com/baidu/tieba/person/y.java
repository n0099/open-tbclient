package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, int i) {
        super(i);
        this.bSb = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity ael;
        PersonBarActivity ael2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.bSb.mIsHost;
            if (z) {
                u personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                ael = this.bSb.ael();
                if (ael != null) {
                    ael2 = this.bSb.ael();
                    if (ael2.getRequestCode() != 23011) {
                        view3 = this.bSb.bRT;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.bSb.bRW;
                        if (!z2) {
                            this.bSb.bRW = true;
                            BdListView bdListView = this.bSb.mListView;
                            view2 = this.bSb.bRT;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.bSb.bRT;
                        view.setVisibility(0);
                    }
                    this.bSb.a(personBarData, true);
                }
            }
        }
    }
}
