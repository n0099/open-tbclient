package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes2.dex */
public class r {
    private b fvN;
    private PbModel fvh;
    private final HttpMessageListener fzE = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.pb.pb.main.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            r.this.a(httpResponsedMessage, CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        }
    };
    private final HttpMessageListener fzF = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE) { // from class: com.baidu.tieba.pb.pb.main.r.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            r.this.a(httpResponsedMessage, CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
        }
    };
    private BdUniqueId mTag;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void c(CustomDialogData customDialogData);

        void qz(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void c(ContriInfo contriInfo);
    }

    public r(PbModel pbModel, BdUniqueId bdUniqueId) {
        this.fvh = pbModel;
        this.mTag = bdUniqueId;
        registerTask();
        this.fzE.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.fzE);
        MessageManager.getInstance().registerListener(this.fzF);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_CHANGE_FLOOR_AGREE_URL);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask2.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void a(String str, int i, a aVar) {
        if (this.fvh != null && this.fvh.getPbData() != null) {
            a(str, i, 1, 2, StringUtils.isNull(this.fvh.getForumId()) ? "" : this.fvh.getForumId(), aVar);
        }
    }

    public void a(String str, int i, int i2, int i3, String str2, a aVar) {
        if (this.fvh != null && this.fvh.getPbData() != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("post_id", str);
            httpMessage.addParam("thread_id", this.fvh.getPbData().getThreadId());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", i2);
            httpMessage.addParam("agree_type", i3);
            httpMessage.addParam("forum_id", str2);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.setTag(this.mTag);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(String str, int i, int i2, String str2, a aVar) {
        if (this.fvh != null && this.fvh.getPbData() != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.fvh.getPbData().getThreadId());
            httpMessage.addParam("post_id", str);
            httpMessage.addParam("obj_type", i);
            httpMessage.addParam("agree_type", i2);
            httpMessage.addParam("forum_id", str2);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        a aVar;
        Object extra;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
            if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof a)) {
                aVar = null;
            } else {
                aVar = (a) extra;
            }
            if (aVar != null) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
                if (!pbFloorAgreeResponseMessage.hasError()) {
                    aVar.qz(pbFloorAgreeResponseMessage.getScore());
                    if (this.fvN != null && pbFloorAgreeResponseMessage.getContriInfo() != null && pbFloorAgreeResponseMessage.getContriInfo().isShowToast()) {
                        this.fvN.c(pbFloorAgreeResponseMessage.getContriInfo());
                    } else if (pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
                        aVar.c(pbFloorAgreeResponseMessage.getActivityDialogData());
                    }
                }
            }
        }
    }

    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.fzE);
        MessageManager.getInstance().unRegisterListener(this.fzF);
        return true;
    }

    public void a(b bVar) {
        this.fvN = bVar;
    }
}
