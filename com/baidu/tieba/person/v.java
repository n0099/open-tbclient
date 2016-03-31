package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(s sVar, int i) {
        super(i);
        this.dst = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity aBf;
        PersonBarActivity aBf2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.dst.bIP;
            if (z) {
                r personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                aBf = this.dst.aBf();
                if (aBf != null) {
                    if (personBarData != null) {
                        this.dst.dsm = true;
                    }
                    aBf2 = this.dst.aBf();
                    if (aBf2.getRequestCode() != 23011) {
                        view3 = this.dst.dsk;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.dst.dsn;
                        if (!z2) {
                            this.dst.dsn = true;
                            BdListView bdListView = this.dst.Je;
                            view2 = this.dst.dsk;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.dst.dsk;
                        view.setVisibility(0);
                    }
                    this.dst.a(personBarData, true);
                }
            }
        }
    }
}
