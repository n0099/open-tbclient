package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes11.dex */
public class b {
    public void a(TbPageContext tbPageContext, x xVar) {
        if (xVar != null && xVar.aKQ != null && xVar.mLiveInfo != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = xVar.aKQ;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(tbPageContext.getPageActivity(), ExtraParamsManager.getDecryptUserId(alaLiveUserInfoData.userUk), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, null, null, 0L, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaLiveUserInfoData.userStatus, Long.toString(xVar.mLiveInfo.group_id), Long.toString(xVar.mLiveInfo.live_id), false, null, null, alaLiveUserInfoData.nickName, "")));
        }
    }

    public void j(AlaWheatInfoData alaWheatInfoData) {
        if (alaWheatInfoData != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{alaWheatInfoData.uk}));
        }
    }
}
