package com.baidu.tieba.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        k kVar = (k) customResponsedMessage.getData();
        int indexOf = kVar.getCollectTools().indexOf(7);
        if (indexOf != -1) {
            kVar.b(new com.baidu.tieba.location.editortool.b(kVar.getContext(), indexOf + 1));
        }
        if (kVar.getCollectTools().indexOf(8) != -1) {
            kVar.b(new com.baidu.tieba.location.editortool.a(kVar.getContext()));
        }
    }
}
