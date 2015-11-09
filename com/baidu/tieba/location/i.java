package com.baidu.tieba.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.editortools.j;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        j jVar = (j) customResponsedMessage.getData();
        int indexOf = jVar.getCollectTools().indexOf(7);
        if (indexOf != -1) {
            jVar.b(new com.baidu.tieba.location.editortool.b(jVar.getContext(), indexOf + 1));
        }
        if (jVar.getCollectTools().indexOf(8) != -1) {
            jVar.b(new com.baidu.tieba.location.editortool.a(jVar.getContext()));
        }
    }
}
