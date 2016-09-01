package com.baidu.tieba.pb.pb.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(e eVar, int i) {
        super(i);
        this.elb = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        com.baidu.tieba.pb.data.h hVar3;
        com.baidu.tieba.pb.data.h hVar4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
            bg bgVar = (bg) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(bgVar.getId()) && bgVar.rt() != null) {
                hVar = this.elb.ekQ;
                if (hVar != null) {
                    hVar2 = this.elb.ekQ;
                    if (hVar2.aLQ() != null) {
                        hVar3 = this.elb.ekQ;
                        if (!TextUtils.isEmpty(hVar3.aLQ().getId())) {
                            String id = bgVar.getId();
                            hVar4 = this.elb.ekQ;
                            if (!id.equals(hVar4.aLQ().getId())) {
                            }
                        }
                    }
                }
            }
        }
    }
}
