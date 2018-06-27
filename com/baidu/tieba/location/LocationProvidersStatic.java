package com.baidu.tieba.location;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class LocationProvidersStatic {
    static {
        com.baidu.adp.lib.d.a.hB().a(b.aRJ());
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        if (loadBoolean) {
            com.baidu.adp.lib.d.a.hB().a(a.aRI());
        }
        MessageManager.getInstance().registerListener(new CustomMessageListener(2010044) { // from class: com.baidu.tieba.location.LocationProvidersStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EditorTools editorTools = (EditorTools) customResponsedMessage.getData();
                int indexOf = editorTools.getCollectTools().indexOf(7);
                if (indexOf != -1) {
                    editorTools.b(new com.baidu.tieba.location.editortool.b(editorTools.getContext(), indexOf + 1));
                }
                if (editorTools.getCollectTools().indexOf(8) != -1) {
                    if (editorTools.HF()) {
                        editorTools.b(new com.baidu.tieba.location.editortool.a(editorTools.getContext(), true));
                    } else {
                        editorTools.b(new com.baidu.tieba.location.editortool.a(editorTools.getContext()));
                    }
                }
            }
        });
        CustomMessageTask customMessageTask = new CustomMessageTask(2016556, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.location.LocationProvidersStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2016556, new com.baidu.tieba.location.editortool.b(customMessage.getData(), 0));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
