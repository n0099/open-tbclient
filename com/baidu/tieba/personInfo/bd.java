package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes.dex */
public class bd implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        ProfileResIdl profileResIdl;
        if (customMessage instanceof RequestPersonInfoMessage) {
            byte[] bArr = com.baidu.tbadk.core.b.a.tc().P("tb_user_profile", TbadkCoreApplication.getCurrentAccountName()).get("profile_cache_key");
            ResponsePersonInfoMessage responsePersonInfoMessage = new ResponsePersonInfoMessage();
            if (bArr == null) {
                return responsePersonInfoMessage;
            }
            try {
                profileResIdl = (ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class);
            } catch (IOException e) {
                e.printStackTrace();
                profileResIdl = null;
            }
            if (profileResIdl != null) {
                responsePersonInfoMessage.setUser(profileResIdl.data.user);
                responsePersonInfoMessage.setAnti_stat(profileResIdl.data.anti_stat);
                responsePersonInfoMessage.setTainfo(profileResIdl.data.tainfo);
                responsePersonInfoMessage.setPost_list(profileResIdl.data.post_list);
                responsePersonInfoMessage.setUserGodInfo(profileResIdl.data.user_god_info);
            }
            return responsePersonInfoMessage;
        }
        return null;
    }
}
