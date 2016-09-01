package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ai extends com.baidu.adp.base.e {
    private static final String aUy = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.COMMON_PRAISE_URL;
    private static TbHttpMessageTask aUz = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, aUy);
    private final HttpMessageListener aUA;
    private a frt;

    /* loaded from: classes.dex */
    public interface a {
        void hu(String str);

        void v(int i, String str);
    }

    static {
        aUz.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(aUz);
    }

    public ai(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.frt = null;
        this.aUA = new aj(this, CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.frt = aVar;
    }

    public void registerListener() {
        this.aUA.setSelfListener(true);
        this.aUA.setTag(getUniqueId());
        registerListener(this.aUA);
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

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
