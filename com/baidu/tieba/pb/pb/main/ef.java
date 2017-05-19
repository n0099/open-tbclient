package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreHttpResMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreSocketResMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes.dex */
class ef extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ee ekI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ef(ee eeVar, int i, int i2) {
        super(i, i2);
        this.ekI = eeVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage instanceof LookMoreHttpResMessage) {
                LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                List<PostData> data = lookMoreHttpResMessage.getData();
                String errorString = lookMoreHttpResMessage.getErrorString();
                int error = lookMoreHttpResMessage.getError();
                if (error == 0) {
                    if (!com.baidu.tbadk.core.util.x.r(data)) {
                        this.ekI.egP.onSuccess(data);
                        return;
                    }
                    return;
                }
                this.ekI.egP.h(error, errorString, "");
            } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                List<PostData> data2 = lookMoreSocketResMessage.getData();
                String errorString2 = lookMoreSocketResMessage.getErrorString();
                int error2 = lookMoreSocketResMessage.getError();
                if (error2 == 0) {
                    if (data2 != null) {
                        this.ekI.egP.onSuccess(data2);
                        return;
                    }
                    return;
                }
                this.ekI.egP.h(error2, errorString2, "");
            }
        }
    }
}
