package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.VideoHolyCardResponseMessage;
/* loaded from: classes.dex */
public class VideoHolyCardModel extends BdBaseModel {
    private long fhx;
    private a ipI;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(1003400) { // from class: com.baidu.tieba.model.VideoHolyCardModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof VideoHolyCardResponseMessage) && VideoHolyCardModel.this.ipI != null) {
                VideoHolyCardModel.this.ipI.onResult(((VideoHolyCardResponseMessage) httpResponsedMessage).isVideoHolyCard);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void onResult(boolean z);
    }

    public VideoHolyCardModel() {
        cgv();
    }

    private void cgv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003400, TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_HOLY_CARD);
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
        this.ipI = aVar;
    }

    public void cgw() {
        if (System.currentTimeMillis() - this.fhx > 200) {
            String clientIP = UtilHelper.getClientIP();
            String str = RomUtils.UNKNOWN;
            int networkOperator = UtilHelper.getNetworkOperator();
            if (networkOperator == 1) {
                str = "CMNET";
            } else if (networkOperator == 2) {
                str = "UNICOM";
            } else if (networkOperator == 3) {
                str = "TELECOM";
            }
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                this.ipI.onResult(false);
                return;
            }
            HttpMessage httpMessage = new HttpMessage(1003400);
            httpMessage.addParam("localip", clientIP);
            httpMessage.addParam("network", str);
            MessageManager.getInstance().sendMessage(httpMessage);
            this.fhx = System.currentTimeMillis();
        }
    }
}
