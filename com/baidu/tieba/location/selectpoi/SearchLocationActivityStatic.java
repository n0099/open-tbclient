package com.baidu.tieba.location.selectpoi;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.location.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.location.data.LocationSearchResponseMessage;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
/* loaded from: classes22.dex */
public class SearchLocationActivityStatic {
    public static String Tag = "tag";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_SEARCH_LOCATION_PAGE, new CustomMessageTask.CustomRunnable<SearchLocationActivityConfig>() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<SearchLocationActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), SearchLocationActivity.class);
                    customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra("request_code", 0));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        daB();
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME, LocationSearchResponseMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(SelectLocationActivityConfig.class, SelectLocationActivity.class);
    }

    public static void daB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003002, com.baidu.tieba.tbadkCore.a.a.bK(TbConfig.GET_SUGGEST_LOCATION_BY_NAME, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LocationSearchHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
