package com.baidu.tieba.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.data.s;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.FriendFeedPage.FriendFeedPageResIdl;
import tbclient.FriendFeedPage.FriendThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ResponseFriendFeedMessage extends TbSocketReponsedMessage {
    private static final String FRIEND_FEED_KEY_PRE = "friend_feed_data";
    private s friendFeedData;

    public ResponseFriendFeedMessage() {
        super(303003);
    }

    public s getFriendFeedData() {
        return this.friendFeedData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        FriendFeedPageResIdl friendFeedPageResIdl = (FriendFeedPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FriendFeedPageResIdl.class);
        setError(friendFeedPageResIdl.error.errorno.intValue());
        setErrorString(friendFeedPageResIdl.error.usermsg);
        if (getError() == 0 && friendFeedPageResIdl.data != null) {
            this.friendFeedData = new s();
            if (friendFeedPageResIdl.data.thread_list != null) {
                getFriendFeedData().z(new ArrayList());
                List<User> list = friendFeedPageResIdl.data.user_list;
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            getFriendFeedData().getUserMap().put(metaData.getUserId(), metaData);
                        }
                    }
                }
                List<FriendThreadInfo> list2 = friendFeedPageResIdl.data.thread_list;
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        FriendFeedThreadData friendFeedThreadData = new FriendFeedThreadData();
                        friendFeedThreadData.setUserMap(getFriendFeedData().getUserMap());
                        friendFeedThreadData.parserProtobuf(list2.get(i3));
                        friendFeedThreadData.parser_title();
                        getFriendFeedData().zh().add(friendFeedThreadData);
                    }
                }
                getFriendFeedData().setHasMore(friendFeedPageResIdl.data.has_more.intValue());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Message<?> orginalMessage = getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestFriendFeedMessage) && getError() == 0 && TextUtils.isEmpty(((RequestFriendFeedMessage) orginalMessage).getTimeline())) {
            saveProtocolBufferDataToCache(a.kS().bc("tb.friend_feed"), FRIEND_FEED_KEY_PRE + TbadkApplication.getCurrentAccount(), bArr);
        }
    }
}
