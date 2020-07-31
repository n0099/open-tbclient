package com.baidu.tieba.livesdk.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.realAuthen.AuthenCallback;
import com.baidu.live.tbadk.realAuthen.RealAuthen;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.wallet.ICertification;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements RealAuthen {
    @Override // com.baidu.live.tbadk.realAuthen.RealAuthen
    public void doAuthen(Map<String, Object> map, final AuthenCallback authenCallback) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921433, ICertification.class);
        if (runTask != null && runTask.getData() != null) {
            ((ICertification) runTask.getData()).certification(TbadkCoreApplication.getInst(), map, new ICertification.CertificationCallback() { // from class: com.baidu.tieba.livesdk.c.a.1
                @Override // com.baidu.tieba.wallet.ICertification.CertificationCallback
                public void onResult(int i, Map<String, Object> map2) {
                    if (authenCallback != null) {
                        authenCallback.onAuthenResult(i, map2);
                    }
                }
            });
        }
    }
}
