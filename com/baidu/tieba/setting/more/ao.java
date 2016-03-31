package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import protobuf.MaskInfo;
/* loaded from: classes.dex */
class ao extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        MaskInfo maskInfo;
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && (socketResponsedMessage instanceof ResponseOnlineMessage) && (maskInfo = ((ResponseOnlineMessage) socketResponsedMessage).getMaskInfo()) != null) {
            SettingStatic.maskInfo = maskInfo;
            SettingStatic.aPg();
        }
    }
}
