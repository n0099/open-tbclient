package com.baidu.tieba.publisher.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ugc.model.AtSelectEvent;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import com.baidu.searchbox.ugc.service.AtService;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
/* loaded from: classes11.dex */
public class a implements AtService {
    @Override // com.baidu.searchbox.ugc.service.AtService
    public void open(Context context) {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(context, 0, false);
        atListActivityConfig.setIsForBjh(true);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig);
        customMessage.setTag(BdUniqueId.gen());
        MessageManager.getInstance().sendMessage(customMessage);
    }

    @Override // com.baidu.searchbox.ugc.service.AtService
    public void postAtSelectEvent(AtUserInfoItem atUserInfoItem) {
        AtSelectEvent atSelectEvent = new AtSelectEvent();
        atSelectEvent.mAtUserInfoItem = atUserInfoItem;
        EventBusWrapper.post(atSelectEvent);
    }
}
