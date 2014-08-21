package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, int i) {
        super(i);
        this.a = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonBarActivity g;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001187) {
            z = this.a.n;
            if (z) {
                t personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                g = this.a.g();
                if (g != null) {
                    this.a.a(personBarData, true);
                }
            }
        }
    }
}
