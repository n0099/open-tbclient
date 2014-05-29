package com.baidu.tieba.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends CustomMessageListener {
    final /* synthetic */ av a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(av avVar, int i) {
        super(i);
        this.a = avVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Context context;
        com.baidu.adp.base.e eVar;
        com.baidu.adp.base.e eVar2;
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case MessageTypes.CMD_UPDATE_ATTENTION /* 2003118 */:
                    if ((customResponsedMessage instanceof UpdateAttentionMessage) && this.a.h() != null) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        com.baidu.tbadk.coreExtra.message.a data = updateAttentionMessage.getData();
                        if (this.a.h().getUserId() != null && data != null && this.a.h().getUserId().equals(data.c) && data.a) {
                            this.a.h().setHave_attention(updateAttentionMessage.isAttention() ? 0 : 1);
                            this.a.mLoadDataMode = 3;
                            this.a.setErrorString(updateAttentionMessage.getErrorString());
                            eVar = this.a.mLoadDataCallBack;
                            if (eVar != null) {
                                eVar2 = this.a.mLoadDataCallBack;
                                eVar2.a(Boolean.valueOf(updateAttentionMessage.isSucc()));
                                return;
                            }
                            return;
                        } else if (data != null && !TextUtils.isEmpty(data.b)) {
                            context = this.a.s;
                            com.baidu.adp.lib.util.k.a(context, data.b);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
