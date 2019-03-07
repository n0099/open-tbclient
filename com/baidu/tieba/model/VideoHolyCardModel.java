package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.VideoHolyCardResponseMessage;
/* loaded from: classes.dex */
public class VideoHolyCardModel extends BdBaseModel {
    private a gXU;
    private long gXV;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_HOLY_CARD) { // from class: com.baidu.tieba.model.VideoHolyCardModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof VideoHolyCardResponseMessage) && VideoHolyCardModel.this.gXU != null) {
                VideoHolyCardModel.this.gXU.bt(((VideoHolyCardResponseMessage) httpResponsedMessage).isVideoHolyCard);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bt(boolean z);
    }

    public VideoHolyCardModel() {
        bEb();
    }

    private void bEb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_HOLY_CARD, TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_HOLY_CARD);
        tbHttpMessageTask.setResponsedClass(VideoHolyCardResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
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
        this.gXU = aVar;
    }

    public void bEc() {
        if (System.currentTimeMillis() - this.gXV > 200) {
            String clientIP = UtilHelper.getClientIP();
            String str = "UNKNOWN";
            int networkOperator = UtilHelper.getNetworkOperator();
            if (networkOperator == 1) {
                str = "CMNET";
            } else if (networkOperator == 2) {
                str = "UNICOM";
            } else if (networkOperator == 3) {
                str = "TELECOM";
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_HOLY_CARD);
            httpMessage.addParam("localip", clientIP);
            httpMessage.addParam("network", str);
            MessageManager.getInstance().sendMessage(httpMessage);
            this.gXV = System.currentTimeMillis();
        }
    }
}
