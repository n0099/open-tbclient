package com.baidu.tieba.personCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.o.a;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes4.dex */
public class PersonCenterFragmentStatic {
    static {
        aIS();
        a.chb();
    }

    private static void aIS() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PROFILE, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002700, com.baidu.tieba.tbadkCore.a.a.bl(Config.USER_INFO_ADDRESS, CmdConfigSocket.CMD_PROFILE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
