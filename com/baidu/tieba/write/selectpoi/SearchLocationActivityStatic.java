package com.baidu.tieba.write.selectpoi;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.location.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationSearchResponseMessage;
/* loaded from: classes.dex */
public class SearchLocationActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002012, new f());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        aqk();
        com.baidu.tieba.tbadkCore.a.a.c(303018, LocationSearchResponseMessage.class, false);
    }

    public static void aqk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, com.baidu.tieba.tbadkCore.a.a.R(TbConfig.GET_SUGGEST_LOCATION_BY_NAME, 303018));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LocationSearchHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
