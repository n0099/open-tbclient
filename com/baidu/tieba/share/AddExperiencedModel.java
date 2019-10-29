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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.data.ContriInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class AddExperiencedModel extends BdBaseModel {
    public static final int DELAY_TIME = 2000;
    public static int MAX_ADD_ADVANCED = 6;
    public static int MAX_ADD_NORMAL = 3;
    public static String USELESS_FORUM_ID = "24981790";
    private HttpMessageListener cjO;
    private a iXs;
    private ContriInfo iXt;
    private Runnable iXu;

    /* loaded from: classes.dex */
    public interface a {
        void a(ContriInfo contriInfo);
    }

    public AddExperiencedModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iXu = new Runnable() { // from class: com.baidu.tieba.share.AddExperiencedModel.1
            @Override // java.lang.Runnable
            public void run() {
                if (AddExperiencedModel.this.iXs != null) {
                    AddExperiencedModel.this.iXs.a(AddExperiencedModel.this.iXt);
                }
            }
        };
        this.cjO = new HttpMessageListener(1003332, true) { // from class: com.baidu.tieba.share.AddExperiencedModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AddExperiencedResponseMessage)) {
                    AddExperiencedModel.this.iXt = ((AddExperiencedResponseMessage) httpResponsedMessage).getContriInfo();
                    e.fZ().postDelayed(AddExperiencedModel.this.iXu, 2000L);
                }
            }
        };
        registerTask();
        registerListener(this.cjO);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003332, TbConfig.SERVER_ADDRESS + TbConfig.URL_ADD_EXPERIENCED);
        tbHttpMessageTask.setResponsedClass(AddExperiencedResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void dR(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1003332);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        sendMessage(httpMessage);
    }

    public static boolean Dl(String str) {
        return b.toLong(str, 0L) > 0 && !USELESS_FORUM_ID.equals(str);
    }

    public static boolean Dm(String str) {
        String str2;
        boolean z;
        l<String> bK = com.baidu.tbadk.core.d.a.akN().bK("tb.share_add_experienced", TbadkCoreApplication.getCurrentAccount());
        if (bK != null) {
            String str3 = bK.get(str);
            String currentDay = UtilHelper.getCurrentDay();
            if (!StringUtils.isNull(str3)) {
                String[] split = str3.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 2) {
                    String trim = split[0].trim();
                    String trim2 = split[1].trim();
                    if (currentDay.equals(trim)) {
                        int i = b.toInt(trim2, 0) + 1;
                        String str4 = trim + Constants.ACCEPT_TIME_SEPARATOR_SP + i;
                        if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                            z = i <= MAX_ADD_ADVANCED;
                        } else {
                            z = i <= MAX_ADD_NORMAL;
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
            bK.setForever(str, str2);
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
        this.iXs = aVar;
    }

    public void onDestroy() {
        e.fZ().removeCallbacks(this.iXu);
    }
}
