package com.baidu.tieba.yuyinala.charm.charmrank;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.i;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes4.dex */
public class b extends BdBaseModel<YuyinCharmRankTotalActivity> {
    private BdUniqueId brR;
    private HttpMessageListener gER;
    private a ojn;

    /* loaded from: classes4.dex */
    public interface a {
        void a(i iVar);

        void t(int i, String str);
    }

    public b(TbPageContext<YuyinCharmRankTotalActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.gER = new HttpMessageListener(1031035) { // from class: com.baidu.tieba.yuyinala.charm.charmrank.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof CharmRankListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId()) {
                    CharmRankListHttpResponseMessage charmRankListHttpResponseMessage = (CharmRankListHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        if (b.this.ojn != null) {
                            b.this.ojn.a(charmRankListHttpResponseMessage.ecR());
                        }
                    } else if (b.this.ojn != null) {
                        b.this.ojn.t(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.ojn = aVar;
        this.brR = BdUniqueId.gen();
        setUniqueId(this.brR);
        MessageManager.getInstance().registerListener(this.gER);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031035, TbConfig.SERVER_ADDRESS + "ala/audio/room/getRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(CharmRankListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gM(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1031035);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        httpMessage.addParam("rank_type", str);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gER);
        MessageManager.getInstance().unRegisterTask(1031035);
        cancelMessage();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
