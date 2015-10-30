package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes.dex */
public class ac implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        ProfileResIdl profileResIdl;
        ResponsePersonInfoMessage responsePersonInfoMessage = null;
        if (customMessage instanceof RequestPersonInfoMessage) {
            try {
                profileResIdl = (ProfileResIdl) new Wire(new Class[0]).parseFrom(com.baidu.tbadk.core.b.a.sL().T("tb_user_profile", TbadkCoreApplication.getCurrentAccountName()).get("profile_cache_key"), ProfileResIdl.class);
            } catch (IOException e) {
                e.printStackTrace();
                profileResIdl = null;
            }
            responsePersonInfoMessage = new ResponsePersonInfoMessage();
            if (profileResIdl != null) {
                responsePersonInfoMessage.setUser(profileResIdl.data.user);
                responsePersonInfoMessage.setAnti_stat(profileResIdl.data.anti_stat);
                responsePersonInfoMessage.setTainfo(profileResIdl.data.tainfo);
                responsePersonInfoMessage.setPost_list(profileResIdl.data.post_list);
            }
        }
        return responsePersonInfoMessage;
    }
}
