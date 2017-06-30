package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreHttpResMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreSocketResMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes.dex */
class ex extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ew ezG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex(ew ewVar, int i, int i2) {
        super(i, i2);
        this.ezG = ewVar;
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
                    if (!com.baidu.tbadk.core.util.z.t(data)) {
                        this.ezG.evu.ci(data);
                        return;
                    }
                    return;
                }
                this.ezG.evu.h(error, errorString, "");
            } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                List<PostData> data2 = lookMoreSocketResMessage.getData();
                String errorString2 = lookMoreSocketResMessage.getErrorString();
                int error2 = lookMoreSocketResMessage.getError();
                if (error2 == 0) {
                    if (data2 != null) {
                        this.ezG.evu.ci(data2);
                        return;
                    }
                    return;
                }
                this.ezG.evu.h(error2, errorString2, "");
            }
        }
    }
}
