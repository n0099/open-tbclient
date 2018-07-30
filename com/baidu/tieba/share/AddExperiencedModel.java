package com.baidu.tieba.share;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.data.ContriInfo;
/* loaded from: classes.dex */
public class AddExperiencedModel extends BdBaseModel {
    public static final int DELAY_TIME = 2000;
    public static int MAX_ADD_ADVANCED = 6;
    public static int MAX_ADD_NORMAL = 3;
    public static String USELESS_FORUM_ID = "24981790";
    private HttpMessageListener aqx;
    private a gBT;
    private ContriInfo gBU;
    private Runnable gBV;

    /* loaded from: classes.dex */
    public interface a {
        void b(ContriInfo contriInfo);
    }

    public AddExperiencedModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gBV = new Runnable() { // from class: com.baidu.tieba.share.AddExperiencedModel.1
            @Override // java.lang.Runnable
            public void run() {
                if (AddExperiencedModel.this.gBT != null) {
                    AddExperiencedModel.this.gBT.b(AddExperiencedModel.this.gBU);
                }
            }
        };
        this.aqx = new HttpMessageListener(CmdConfigHttp.CMD_ADD_EXPERIENCED, true) { // from class: com.baidu.tieba.share.AddExperiencedModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AddExperiencedResponseMessage)) {
                    AddExperiencedModel.this.gBU = ((AddExperiencedResponseMessage) httpResponsedMessage).getContriInfo();
                    e.in().postDelayed(AddExperiencedModel.this.gBV, 2000L);
                }
            }
        };
        registerTask();
        registerListener(this.aqx);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_EXPERIENCED, TbConfig.SERVER_ADDRESS + TbConfig.URL_ADD_EXPERIENCED);
        tbHttpMessageTask.setResponsedClass(AddExperiencedResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void ce(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_EXPERIENCED);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        sendMessage(httpMessage);
    }

    public static boolean tf(String str) {
        return b.c(str, 0L) > 0 && !USELESS_FORUM_ID.equals(str);
    }

    public static boolean tg(String str) {
        String str2;
        boolean z;
        l<String> Q = com.baidu.tbadk.core.c.a.xb().Q("tb.share_add_experienced", TbadkCoreApplication.getCurrentAccount());
        if (Q != null) {
            String str3 = Q.get(str);
            String currentDay = UtilHelper.getCurrentDay();
            if (!StringUtils.isNull(str3)) {
                String[] split = str3.split(",");
                if (split != null && split.length == 2) {
                    String trim = split[0].trim();
                    String trim2 = split[1].trim();
                    if (currentDay.equals(trim)) {
                        int g = b.g(trim2, 0) + 1;
                        String str4 = trim + "," + g;
                        if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                            z = g <= MAX_ADD_ADVANCED;
                        } else {
                            z = g <= MAX_ADD_NORMAL;
                        }
                        str2 = str4;
                    } else {
                        str2 = currentDay + ",1";
                        z = true;
                    }
                } else {
                    str2 = currentDay + ",1";
                    z = true;
                }
            } else {
                str2 = currentDay + ",1";
                z = true;
            }
            Q.e(str, str2);
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

    public void a(a aVar) {
        this.gBT = aVar;
    }

    public void onDestroy() {
        e.in().removeCallbacks(this.gBV);
    }
}
