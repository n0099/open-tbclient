package com.baidu.tieba.livesdk.h;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.tieba.wallet.ITiebaPay;
import com.baidu.tieba.wallet.ITiebaPayCallback;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a implements IPayChannelBuilder {
    private ITiebaPay ibE = null;

    @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder
    public IPayChannel build() {
        cbZ();
        return new IPayChannel() { // from class: com.baidu.tieba.livesdk.h.a.1
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel
            public void pay(HashMap<String, String> hashMap, final IPayCallback iPayCallback) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    a.this.cbZ();
                    if (a.this.ibE != null) {
                        a.this.ibE.pay(hashMap.remove("channel"), hashMap, new ITiebaPayCallback() { // from class: com.baidu.tieba.livesdk.h.a.1.1
                            @Override // com.baidu.tieba.wallet.ITiebaPayCallback
                            public void onPayResult(int i, String str) {
                                if (iPayCallback != null) {
                                    iPayCallback.onPayResult(i, str);
                                }
                            }
                        });
                    } else if (iPayCallback != null) {
                        iPayCallback.onPayResult(2, null);
                    }
                }
            }

            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel
            public void onPayResult(String str, String str2, String str3, Context context, boolean z) {
            }

            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel
            public PayChannelType getType() {
                return PayChannelType.WALLET;
            }

            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel
            public void release() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbZ() {
        CustomResponsedMessage runTask;
        if (this.ibE == null && (runTask = MessageManager.getInstance().runTask(2921432, ITiebaPay.class)) != null) {
            this.ibE = (ITiebaPay) runTask.getData();
        }
    }
}
