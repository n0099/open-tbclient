package com.baidu.tieba.person.post;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.b.a aVar;
        com.baidu.tbadk.mainTab.c fragmentTabStructure;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016220 && (customResponsedMessage.getData() instanceof com.baidu.tbadk.b.a) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!ar.isEmpty(currentAccount) && (aVar = (com.baidu.tbadk.b.a) customResponsedMessage.getData()) != null) {
                PersonPhotoLiveDelegateStatic personPhotoLiveDelegateStatic = new PersonPhotoLiveDelegateStatic();
                aVar.a(personPhotoLiveDelegateStatic);
                if (aVar.getContext() != null && (fragmentTabStructure = personPhotoLiveDelegateStatic.getFragmentTabStructure()) != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key_uid", currentAccount);
                    bundle.putString("thread_type_key", "photolive");
                    fragmentTabStructure.auY.setArguments(bundle);
                }
            }
        }
    }
}
