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
/* loaded from: classes10.dex */
public class b extends BdBaseModel<YuyinCharmRankTotalActivity> {
    private BdUniqueId brL;
    private HttpMessageListener gLY;
    private a ogv;

    /* loaded from: classes10.dex */
    public interface a {
        void a(j jVar);

        void w(int i, String str);
    }

    public b(TbPageContext<YuyinCharmRankTotalActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.gLY = new HttpMessageListener(1031035) { // from class: com.baidu.tieba.yuyinala.charm.charmrank.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof CharmRankListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId()) {
                    CharmRankListHttpResponseMessage charmRankListHttpResponseMessage = (CharmRankListHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        if (b.this.ogv != null) {
                            b.this.ogv.a(charmRankListHttpResponseMessage.dXX());
                        }
                    } else if (b.this.ogv != null) {
                        b.this.ogv.w(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.ogv = aVar;
        this.brL = BdUniqueId.gen();
        setUniqueId(this.brL);
        MessageManager.getInstance().registerListener(this.gLY);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031035, com.baidu.live.a.avU + "ala/audio/room/getRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(CharmRankListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gI(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1031035);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        httpMessage.addParam("rank_type", str);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gLY);
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
