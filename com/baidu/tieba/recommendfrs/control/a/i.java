package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ g dZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, int i) {
        super(i);
        this.dZv = gVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        String str;
        String str2;
        String str3;
        if (customResponsedMessage != null) {
            if (!(customResponsedMessage.getData() instanceof com.baidu.tieba.recommendfrs.data.j)) {
                this.dZv.dZo = null;
                this.dZv.dZr = 0;
                return;
            }
            com.baidu.tieba.recommendfrs.data.j jVar = (com.baidu.tieba.recommendfrs.data.j) customResponsedMessage.getData();
            if (jVar.dZY) {
                str2 = this.dZv.dZo;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.dZv.dZo;
                    if (str3.equals(jVar.dZX)) {
                        this.dZv.dZr = 2;
                        this.dZv.dZo = jVar.dZX;
                        return;
                    }
                }
                this.dZv.dZr = 1;
                this.dZv.dZo = jVar.dZX;
                return;
            }
            str = this.dZv.dZo;
            if (StringUtils.isNull(str)) {
                this.dZv.dZr = 2;
            } else {
                this.dZv.dZr = 1;
            }
            this.dZv.dZo = null;
        }
    }
}
