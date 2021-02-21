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
    private BdUniqueId aCW;
    private HttpMessageListener gOS;
    private a oqP;

    /* loaded from: classes11.dex */
    public interface a {
        void A(int i, String str);

        void a(j jVar);
    }

    public b(TbPageContext<YuyinCharmRankTotalActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.gOS = new HttpMessageListener(1031035) { // from class: com.baidu.tieba.yuyinala.charm.charmrank.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof CharmRankListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId()) {
                    CharmRankListHttpResponseMessage charmRankListHttpResponseMessage = (CharmRankListHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        if (b.this.oqP != null) {
                            b.this.oqP.a(charmRankListHttpResponseMessage.eaq());
                        }
                    } else if (b.this.oqP != null) {
                        b.this.oqP.A(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.oqP = aVar;
        this.aCW = BdUniqueId.gen();
        setUniqueId(this.aCW);
        MessageManager.getInstance().registerListener(this.gOS);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031035, com.baidu.live.a.avJ + "ala/audio/room/getRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(CharmRankListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gQ(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1031035);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        httpMessage.addParam("rank_type", str);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gOS);
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
