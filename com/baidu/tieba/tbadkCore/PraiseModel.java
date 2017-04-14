package com.baidu.tieba.tbadkCore;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class PraiseModel extends BdBaseModel {
    public static final int LIKE = 1;
    public static final int UN_LIKE = 0;
    private static final String aYK = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.COMMON_PRAISE_URL;
    private static TbHttpMessageTask task = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, aYK);
    private final HttpMessageListener aYL;
    private a fuT;

    /* loaded from: classes.dex */
    public interface a {
        void hm(String str);

        void w(int i, String str);
    }

    static {
        task.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public PraiseModel(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.fuT = null;
        this.aYL = new ad(this, CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.fuT = aVar;
    }

    public void registerListener() {
        this.aYL.setSelfListener(true);
        this.aYL.setTag(getUniqueId());
        registerListener(this.aYL);
    }

    public void a(String str, String str2, int i, String str3) {
        String str4;
        if (i == 1) {
            str4 = "unlike";
        } else {
            str4 = "like";
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        httpMessage.addParam("st_type", str4);
        httpMessage.addParam("action", str4);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(str)).toString());
        httpMessage.addParam("thread_id", new StringBuilder(String.valueOf(str2)).toString());
        httpMessage.addParam("st_param", str3);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
