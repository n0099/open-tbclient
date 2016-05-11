package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ g dZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, int i) {
        super(i);
        this.dZv = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i = 0;
        if (customResponsedMessage != null) {
            if (!(customResponsedMessage.getData() instanceof ArrayList)) {
                this.dZv.dZr = 0;
                this.dZv.dZq = null;
                return;
            }
            ArrayList arrayList4 = (ArrayList) customResponsedMessage.getData();
            arrayList = this.dZv.dZq;
            if (arrayList == null) {
                if (arrayList4.size() > 0) {
                    this.dZv.dZr = 1;
                } else {
                    this.dZv.dZr = 2;
                }
            } else {
                int size = arrayList4.size();
                arrayList2 = this.dZv.dZq;
                if (size != arrayList2.size()) {
                    this.dZv.dZr = 1;
                } else {
                    while (true) {
                        int i2 = i;
                        if (i2 > arrayList4.size()) {
                            break;
                        }
                        if (i2 == arrayList4.size()) {
                            this.dZv.dZr = 2;
                        } else if (StringUtils.isNull((String) arrayList4.get(i2))) {
                            break;
                        } else {
                            arrayList3 = this.dZv.dZq;
                            if (!((String) arrayList4.get(i2)).equals(arrayList3.get(i2))) {
                                break;
                            }
                        }
                        i = i2 + 1;
                    }
                    this.dZv.dZr = 1;
                }
            }
            this.dZv.dZq = arrayList4;
        }
    }
}
