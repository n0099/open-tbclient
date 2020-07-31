package com.baidu.tieba.livesdk.share.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tieba.c.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private ArrayList<TransmitForumData> fkE = new ArrayList<>();
    private final CustomMessageListener jFk = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.livesdk.share.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                a.this.fkE.clear();
                a.this.fkE.addAll((ArrayList) customResponsedMessage.getData());
            }
        }
    };
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.jFk);
    }

    public void cDf() {
        f.bSP().bSS();
    }

    public void fj(long j) {
        if (j > 0) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mTbPageContext.getPageActivity(), RequestResponseCode.REQUEST_SELECT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
            selectForumActivityConfig.setFrom(1);
            selectForumActivityConfig.setForumList(this.fkE);
            selectForumActivityConfig.setLiveId(j);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public List<TransmitForumData> cDg() {
        return this.fkE;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jFk);
    }
}
