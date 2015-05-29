package com.baidu.tieba.write.editor;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.PbEditor.af;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ EditorInfoContainer czz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(EditorInfoContainer editorInfoContainer, int i) {
        super(i);
        this.czz = editorInfoContainer;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof af) {
                this.czz.a((af) data);
            }
        }
    }
}
