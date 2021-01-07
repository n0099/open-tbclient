package com.baidu.tieba.newfaceshop;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.l;
/* loaded from: classes9.dex */
public abstract class FaceBaseModel extends BdBaseModel {
    @Override // com.baidu.adp.base.BdBaseModel
    public void sendMessage(final Message message) {
        if (l.isMainThread()) {
            super.sendMessage(message);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.FaceBaseModel.1
                @Override // java.lang.Runnable
                public void run() {
                    FaceBaseModel.this.sendMessage(message);
                }
            });
        }
    }
}
