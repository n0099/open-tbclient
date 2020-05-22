package com.baidu.tieba.share;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.data.ContriInfo;
/* loaded from: classes.dex */
public class AddExperiencedModel extends BdBaseModel {
    public static final int DELAY_TIME = 2000;
    public static int MAX_ADD_ADVANCED = 6;
    public static int MAX_ADD_NORMAL = 3;
    public static String USELESS_FORUM_ID = "24981790";
    private HttpMessageListener dNE;
    private a kYF;
    private ContriInfo kYG;
    private Runnable kYH;

    /* loaded from: classes.dex */
    public interface a {
        void a(ContriInfo contriInfo);
    }

    public AddExperiencedModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kYH = new Runnable() { // from class: com.baidu.tieba.share.AddExperiencedModel.1
            @Override // java.lang.Runnable
            public void run() {
                if (AddExperiencedModel.this.kYF != null) {
                    AddExperiencedModel.this.kYF.a(AddExperiencedModel.this.kYG);
                }
            }
        };
        this.dNE = new HttpMessageListener(1003332, true) { // from class: com.baidu.tieba.share.AddExperiencedModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AddExperiencedResponseMessage)) {
                    AddExperiencedModel.this.kYG = ((AddExperiencedResponseMessage) httpResponsedMessage).getContriInfo();
                    e.ld().postDelayed(AddExperiencedModel.this.kYH, 2000L);
                }
            }
        };
        Fv();
        registerListener(this.dNE);
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003332, TbConfig.SERVER_ADDRESS + TbConfig.URL_ADD_EXPERIENCED);
        tbHttpMessageTask.setResponsedClass(AddExperiencedResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void fj(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1003332);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        sendMessage(httpMessage);
    }

    public static boolean LP(String str) {
        return b.toLong(str, 0L) > 0 && !USELESS_FORUM_ID.equals(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        e.ld().removeCallbacks(this.kYH);
    }
}
