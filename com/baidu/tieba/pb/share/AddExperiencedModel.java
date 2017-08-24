package com.baidu.tieba.pb.share;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.c.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class AddExperiencedModel extends BdBaseModel {
    public static int MAX_ADD_ADVANCED = 6;
    public static int MAX_ADD_NORMAL = 3;
    public static String USELESS_FORUM_ID = "24981790";
    public static String WEIXIN_FRIEND = "weixin_friend";
    public static String WEIXIN_TIMELINE = "weixin_timeline";
    private HttpMessageListener eYP;

    public AddExperiencedModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eYP = new HttpMessageListener(CmdConfigHttp.CMD_ADD_EXPERIENCED) { // from class: com.baidu.tieba.pb.share.AddExperiencedModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AddExperiencedResponseMessage) {
                    AddExperiencedResponseMessage addExperiencedResponseMessage = (AddExperiencedResponseMessage) httpResponsedMessage;
                }
            }
        };
        Eo();
        registerListener(this.eYP);
    }

    private void Eo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_EXPERIENCED, TbConfig.SERVER_ADDRESS + TbConfig.URL_ADD_EXPERIENCED);
        tbHttpMessageTask.setResponsedClass(AddExperiencedResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bP(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_EXPERIENCED);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        sendMessage(httpMessage);
    }

    public static boolean pS(String str) {
        return b.d(str, 0L) > 0 && !USELESS_FORUM_ID.equals(str);
    }

    public static boolean pT(String str) {
        String str2;
        boolean z;
        l<String> M = a.to().M("tb.share_add_experienced", TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            String str3 = M.get(str);
            String currentDay = UtilHelper.getCurrentDay();
            if (!StringUtils.isNull(str3)) {
                String[] split = str3.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 2) {
                    String trim = split[0].trim();
                    String trim2 = split[1].trim();
                    if (currentDay.equals(trim)) {
                        int g = b.g(trim2, 0) + 1;
                        String str4 = trim + Constants.ACCEPT_TIME_SEPARATOR_SP + g;
                        if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                            z = g <= MAX_ADD_ADVANCED;
                        } else {
                            z = g <= MAX_ADD_NORMAL;
                        }
                        str2 = str4;
                    } else {
                        str2 = currentDay + Constants.ACCEPT_TIME_SEPARATOR_SP + "1";
                        z = true;
                    }
                } else {
                    str2 = currentDay + Constants.ACCEPT_TIME_SEPARATOR_SP + "1";
                    z = true;
                }
            } else {
                str2 = currentDay + Constants.ACCEPT_TIME_SEPARATOR_SP + "1";
                z = true;
            }
            M.k(str, str2);
            return z;
        }
        return false;
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
