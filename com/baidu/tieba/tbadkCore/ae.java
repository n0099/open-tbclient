package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e {
    private static final String aHa = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.COMMON_PRAISE_URL;
    private static TbHttpMessageTask aHb = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, aHa);
    private final HttpMessageListener aHc;
    private a cXM;

    /* loaded from: classes.dex */
    public interface a {
        void ge(String str);

        void y(int i, String str);
    }

    static {
        aHb.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(aHb);
    }

    public ae(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.cXM = null;
        this.aHc = new af(this, CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.cXM = aVar;
    }

    public void registerListener() {
        registerListener(this.aHc);
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
