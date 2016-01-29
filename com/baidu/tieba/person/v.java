package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(s sVar, int i) {
        super(i);
        this.cXR = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity atz;
        PersonBarActivity atz2;
        boolean z2;
        View view;
        View view2;
        View view3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.cXR.bDs;
            if (z) {
                r personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                atz = this.cXR.atz();
                if (atz != null) {
                    if (personBarData != null) {
                        this.cXR.cXK = true;
                    }
                    atz2 = this.cXR.atz();
                    if (atz2.getRequestCode() != 23011) {
                        view3 = this.cXR.cXI;
                        view3.setVisibility(8);
                    } else {
                        z2 = this.cXR.cXL;
                        if (!z2) {
                            this.cXR.cXL = true;
                            BdListView bdListView = this.cXR.IY;
                            view2 = this.cXR.cXI;
                            bdListView.addHeaderView(view2);
                        }
                        view = this.cXR.cXI;
                        view.setVisibility(0);
                    }
                    this.cXR.a(personBarData, true);
                }
            }
        }
    }
}
