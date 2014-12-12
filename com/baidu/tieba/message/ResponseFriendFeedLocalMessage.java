package com.baidu.tieba.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.data.i;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.FriendFeedPage.FriendFeedPageResIdl;
import tbclient.FriendFeedPage.FriendThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ResponseFriendFeedLocalMessage extends CustomResponsedMessage<Object> {
    private i friendFeedData;

    public ResponseFriendFeedLocalMessage() {
        super(2001172);
    }

    public i getFriendFeedData() {
        return this.friendFeedData;
    }

    public void setFriendFeedData(i iVar) {
        this.friendFeedData = iVar;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        if (bArr != null) {
            FriendFeedPageResIdl friendFeedPageResIdl = (FriendFeedPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FriendFeedPageResIdl.class);
            setError(friendFeedPageResIdl.error.errorno.intValue());
            setErrorString(friendFeedPageResIdl.error.usermsg);
            if (getError() == 0 && friendFeedPageResIdl.data != null) {
                setFriendFeedData(new i());
                if (friendFeedPageResIdl.data.thread_list != null) {
                    getFriendFeedData().E(new ArrayList());
                    List<FriendThreadInfo> list = friendFeedPageResIdl.data.thread_list;
                    if (list != null) {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            FriendFeedThreadData friendFeedThreadData = new FriendFeedThreadData();
                            friendFeedThreadData.setUserMap(getFriendFeedData().getUserMap());
                            friendFeedThreadData.parserProtobuf(list.get(i2));
                            friendFeedThreadData.parser_title();
                            getFriendFeedData().Ct().add(friendFeedThreadData);
                        }
                    }
                    getFriendFeedData().setHasMore(friendFeedPageResIdl.data.has_more.intValue());
                    List<User> list2 = friendFeedPageResIdl.data.user_list;
                    if (list2 != null) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            MetaData metaData = new MetaData();
                            metaData.parserProtobuf(list2.get(i3));
                            String userId = metaData.getUserId();
                            if (userId != null && !userId.equals("0")) {
                                getFriendFeedData().getUserMap().put(metaData.getUserId(), metaData);
                            }
                        }
                    }
                }
            }
        }
    }
}
