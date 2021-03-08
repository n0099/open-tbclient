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
/* loaded from: classes9.dex */
public class a {
    private ArrayList<TransmitForumData> grV = new ArrayList<>();
    private final CustomMessageListener ljS = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.livesdk.share.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                a.this.grV.clear();
                a.this.grV.addAll((ArrayList) customResponsedMessage.getData());
            }
        }
    };
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.ljS);
    }

    public void ddP() {
        f.ctM().ctP();
    }

    public void hi(long j) {
        if (j > 0) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mTbPageContext.getPageActivity(), RequestResponseCode.REQUEST_SELECT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
            selectForumActivityConfig.setFrom(1);
            selectForumActivityConfig.setForumList(this.grV);
            selectForumActivityConfig.setLiveId(j);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public List<TransmitForumData> ddQ() {
        return this.grV;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ljS);
    }
}
