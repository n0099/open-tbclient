package com.baidu.tieba.livesdk.pay_channel;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ah;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder;
import com.baidu.tieba.wallet.ITiebaPay;
import com.baidu.tieba.wallet.ITiebaPayCallback;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a implements IPayChannelBuilder {
    private ITiebaPay hkQ = null;

    @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder
    public IPayChannel build() {
        bJF();
        return new IPayChannel() { // from class: com.baidu.tieba.livesdk.pay_channel.a.1
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel
            public void pay(Object obj, final IPayCallback iPayCallback) {
                if (obj instanceof ah) {
                    a.this.bJF();
                    if (a.this.hkQ == null) {
                        if (iPayCallback != null) {
                            iPayCallback.onPayResult(2, null);
                            return;
                        }
                        return;
                    }
                    HashMap<String, String> b = com.baidu.tieba.livesdk.pay_channel.bddactory.a.b((ah) obj);
                    a.this.hkQ.pay(((ah) obj).UB, b, new ITiebaPayCallback() { // from class: com.baidu.tieba.livesdk.pay_channel.a.1.1
                        @Override // com.baidu.tieba.wallet.ITiebaPayCallback
                        public void onPayResult(int i, String str) {
                            if (iPayCallback != null) {
                                iPayCallback.onPayResult(i, str);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel
            public void onPayResult(String str, String str2, Context context, boolean z) {
            }

            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel
            public void release() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJF() {
        CustomResponsedMessage runTask;
        if (this.hkQ == null && (runTask = MessageManager.getInstance().runTask(2921422, ITiebaPay.class)) != null) {
            this.hkQ = (ITiebaPay) runTask.getData();
        }
    }
}
