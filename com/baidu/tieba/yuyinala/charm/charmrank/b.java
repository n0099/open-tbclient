package com.baidu.tieba.yuyinala.charm.charmrank;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.j;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes11.dex */
public class b extends BdBaseModel<YuyinCharmRankTotalActivity> {
    private BdUniqueId bwz;
    private HttpMessageListener gQE;
    private a olb;

    /* loaded from: classes11.dex */
    public interface a {
        void a(j jVar);

        void v(int i, String str);
    }

    public b(TbPageContext<YuyinCharmRankTotalActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.gQE = new HttpMessageListener(1031035) { // from class: com.baidu.tieba.yuyinala.charm.charmrank.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof CharmRankListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId()) {
                    CharmRankListHttpResponseMessage charmRankListHttpResponseMessage = (CharmRankListHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        if (b.this.olb != null) {
                            b.this.olb.a(charmRankListHttpResponseMessage.ebO());
                        }
                    } else if (b.this.olb != null) {
                        b.this.olb.v(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.olb = aVar;
        this.bwz = BdUniqueId.gen();
        setUniqueId(this.bwz);
        MessageManager.getInstance().registerListener(this.gQE);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031035, com.baidu.live.a.aAH + "ala/audio/room/getRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(CharmRankListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gJ(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1031035);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        httpMessage.addParam("rank_type", str);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gQE);
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
