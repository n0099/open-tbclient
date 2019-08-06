package com.baidu.tieba.location.selectpoi;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.location.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.location.data.LocationSearchResponseMessage;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
/* loaded from: classes5.dex */
public class SearchLocationActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002012, new CustomMessageTask.CustomRunnable<SearchLocationActivityConfig>() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<SearchLocationActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), SearchLocationActivity.class);
                    customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra(IntentConfig.REQUEST_CODE, 0));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bLY();
        com.baidu.tieba.tbadkCore.a.a.c(303018, LocationSearchResponseMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(SelectLocationActivityConfig.class, SelectLocationActivity.class);
    }

    public static void bLY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, com.baidu.tieba.tbadkCore.a.a.bo(TbConfig.GET_SUGGEST_LOCATION_BY_NAME, 303018));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LocationSearchHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
