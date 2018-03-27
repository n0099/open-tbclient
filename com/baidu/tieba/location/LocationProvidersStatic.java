package com.baidu.tieba.location;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes3.dex */
public class LocationProvidersStatic {
    static {
        com.baidu.adp.lib.d.a.mG().a(b.aRl());
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        if (loadBoolean) {
            com.baidu.adp.lib.d.a.mG().a(a.aRk());
        }
        MessageManager.getInstance().registerListener(new CustomMessageListener(2010044) { // from class: com.baidu.tieba.location.LocationProvidersStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i iVar = (i) customResponsedMessage.getData();
                int indexOf = iVar.getCollectTools().indexOf(7);
                if (indexOf != -1) {
                    iVar.b(new com.baidu.tieba.location.editortool.b(iVar.getContext(), indexOf + 1));
                }
                if (iVar.getCollectTools().indexOf(8) != -1) {
                    if (iVar.Lj()) {
                        iVar.b(new com.baidu.tieba.location.editortool.a(iVar.getContext(), true));
                    } else {
                        iVar.b(new com.baidu.tieba.location.editortool.a(iVar.getContext()));
                    }
                }
            }
        });
        CustomMessageTask customMessageTask = new CustomMessageTask(2016556, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.location.LocationProvidersStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<r> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2016556, new com.baidu.tieba.location.editortool.b(customMessage.getData(), 0));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
