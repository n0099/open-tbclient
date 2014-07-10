package com.baidu.tieba.message.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.a.b;
import com.baidu.tieba.message.RequestFriendFeedLocalMessage;
import com.baidu.tieba.message.ResponseFriendFeedLocalMessage;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestFriendFeedLocalMessage)) {
            return null;
        }
        byte[] a = b.a().e().a("friend_feed_data" + TbadkApplication.getCurrentAccount());
        ResponseFriendFeedLocalMessage responseFriendFeedLocalMessage = new ResponseFriendFeedLocalMessage();
        try {
            responseFriendFeedLocalMessage.decodeInBackGround(2001172, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseFriendFeedLocalMessage;
    }
}
