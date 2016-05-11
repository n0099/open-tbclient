package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.e {
    private static final String aKM = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.COMMON_PRAISE_URL;
    private static TbHttpMessageTask aKN = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, aKM);
    private final HttpMessageListener aKO;
    private a erI;

    /* loaded from: classes.dex */
    public interface a {
        void gK(String str);

        void q(int i, String str);
    }

    static {
        aKN.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(aKN);
    }

    public af(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.erI = null;
        this.aKO = new ag(this, CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.erI = aVar;
    }

    public void registerListener() {
        this.aKO.setSelfListener(true);
        this.aKO.setTag(getUniqueId());
        registerListener(this.aKO);
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
