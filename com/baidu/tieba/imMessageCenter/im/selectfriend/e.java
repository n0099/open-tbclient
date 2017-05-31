package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* loaded from: classes2.dex */
class e extends CustomMessageListener {
    private final /* synthetic */ long cgy;
    private final /* synthetic */ String cgz;
    final /* synthetic */ c dlp;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i, long j, String str, String str2) {
        super(i);
        this.dlp = cVar;
        this.cgy = j;
        this.val$name = str;
        this.cgz = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SelectFriendActivity selectFriendActivity;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2921015) {
            selectFriendActivity = this.dlp.dlo;
            selectFriendActivity.a((ShareFromPBMsgData) customResponsedMessage.getData(), this.cgy, this.val$name, this.cgz);
        }
    }
}
