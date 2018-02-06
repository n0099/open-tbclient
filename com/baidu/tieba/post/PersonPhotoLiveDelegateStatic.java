package com.baidu.tieba.post;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonPhotoLiveDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.bxZ = new j();
        cVar.type = 2;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e bi(Context context) {
        this.bxQ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        return this.bxQ;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2016220) { // from class: com.baidu.tieba.post.PersonPhotoLiveDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.g.a aVar;
                com.baidu.tbadk.mainTab.c MV;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016220 && (customResponsedMessage.getData() instanceof com.baidu.tbadk.g.a) && TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!am.isEmpty(currentAccount) && (aVar = (com.baidu.tbadk.g.a) customResponsedMessage.getData()) != null) {
                        PersonPhotoLiveDelegateStatic personPhotoLiveDelegateStatic = new PersonPhotoLiveDelegateStatic();
                        aVar.a(personPhotoLiveDelegateStatic);
                        if (aVar.getContext() != null && (MV = personPhotoLiveDelegateStatic.MV()) != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("key_uid", currentAccount);
                            bundle.putString("thread_type_key", "photolive");
                            MV.bxZ.setArguments(bundle);
                        }
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }
}
