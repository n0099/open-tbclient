package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ EditorInfoContainer bVo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(EditorInfoContainer editorInfoContainer, int i) {
        super(i);
        this.bVo = editorInfoContainer;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof bb) {
                this.bVo.a((bb) data);
            }
        }
    }
}
