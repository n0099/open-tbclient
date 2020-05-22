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
import com.baidu.tieba.c.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<TransmitForumData> eVf = new ArrayList<>();
    private final CustomMessageListener jeI = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.livesdk.share.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                a.this.eVf.clear();
                a.this.eVf.addAll((ArrayList) customResponsedMessage.getData());
            }
        }
    };
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.jeI);
    }

    public void cvh() {
        e.bMw().bMz();
    }

    public void eS(long j) {
        if (j > 0) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mTbPageContext.getPageActivity(), RequestResponseCode.REQUEST_SELECT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
            selectForumActivityConfig.setFrom(1);
            selectForumActivityConfig.setForumList(this.eVf);
            selectForumActivityConfig.setLiveId(j);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public List<TransmitForumData> cvi() {
        return this.eVf;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jeI);
    }
}
