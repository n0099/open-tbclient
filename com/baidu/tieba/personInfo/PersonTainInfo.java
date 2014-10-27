package com.baidu.tieba.personInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Profile.CommonLocation;
import tbclient.Profile.ReplyList;
import tbclient.Profile.TAInfo;
/* loaded from: classes.dex */
public class PersonTainInfo implements Serializable {
    public static final int FRIEND_STAT_IS_FRIEND = 1;
    public static final int FRIEND_STAT_NOT_FRIEND = 0;
    public static final int FRIEND_STAT_VALIDATE = 2;
    private static final long serialVersionUID = -1538103146882985197L;
    private DistanceInfo distanceInfo;
    private int friendNum;
    private int groupNum;
    private int isFriend;
    private boolean userClientVersionLower;
    private List<CommonForum> commonForum = new ArrayList();
    private List<CommonGroup> commonGroup = new ArrayList();
    private List<CommonFriend> commonFriend = new ArrayList();
    private List<ReplyInfo> replyInfo = new ArrayList();

    public List<CommonForum> getCommonForum() {
        return this.commonForum;
    }

    public List<CommonGroup> getCommonGroup() {
        return this.commonGroup;
    }

    public List<CommonFriend> getCommonFriend() {
        return this.commonFriend;
    }

    public List<ReplyInfo> getReplyInfo() {
        return this.replyInfo;
    }

    public DistanceInfo getDistanceInfo() {
        return this.distanceInfo;
    }

    public int getGroupNum() {
        return this.groupNum;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public boolean getUserClientVersionLower() {
        return this.userClientVersionLower;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("foruminfo");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    CommonForum commonForum = new CommonForum();
                    commonForum.parseJson(optJSONArray.optJSONObject(i));
                    this.commonForum.add(commonForum);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("groupinfo");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    CommonGroup commonGroup = new CommonGroup();
                    commonGroup.parseJson(optJSONArray2.optJSONObject(i2));
                    this.commonGroup.add(commonGroup);
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("friendinfo");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    CommonFriend commonFriend = new CommonFriend();
                    commonFriend.parseJson(optJSONArray3.optJSONObject(i3));
                    this.commonFriend.add(commonFriend);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("distanceinfo");
            if (optJSONObject != null && this.distanceInfo == null) {
                this.distanceInfo = new DistanceInfo();
                this.distanceInfo.parseJson(optJSONObject);
            }
            this.groupNum = jSONObject.optInt("groupnum", 0);
            this.friendNum = jSONObject.optInt("friendnum", 0);
            this.isFriend = jSONObject.optInt("is_friend", 0);
            this.userClientVersionLower = jSONObject.optInt("userClientVersionIsLower", 0) == 1;
            JSONArray optJSONArray4 = jSONObject.optJSONArray("reply_list");
            if (optJSONArray4 != null) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    JSONObject optJSONObject2 = optJSONArray4.optJSONObject(i4);
                    if (optJSONObject2 != null) {
                        ReplyInfo replyInfo = new ReplyInfo();
                        replyInfo.parseJson(optJSONObject2);
                        this.replyInfo.add(replyInfo);
                    }
                }
            }
        }
    }

    public void parseProto(TAInfo tAInfo) {
        if (tAInfo != null) {
            this.groupNum = tAInfo.groupnum.intValue();
            this.friendNum = tAInfo.friendnum.intValue();
            this.isFriend = tAInfo.is_friend.intValue();
            this.userClientVersionLower = tAInfo.userClientVersionIsLower.intValue() == 1;
            this.commonForum.clear();
            List<String> list = tAInfo.foruminfo;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    CommonForum commonForum = new CommonForum();
                    commonForum.parseProto(list.get(i));
                    this.commonForum.add(commonForum);
                }
            }
            this.commonGroup.clear();
            List<String> list2 = tAInfo.groupinfo;
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    CommonGroup commonGroup = new CommonGroup();
                    commonGroup.parseProto(list2.get(i2));
                    this.commonGroup.add(commonGroup);
                }
            }
            this.commonFriend.clear();
            List<String> list3 = tAInfo.friendinfo;
            if (list3 != null) {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    CommonFriend commonFriend = new CommonFriend();
                    commonFriend.parseProto(list3.get(i3));
                    this.commonFriend.add(commonFriend);
                }
            }
            CommonLocation commonLocation = tAInfo.location;
            if (commonLocation != null && this.distanceInfo == null) {
                this.distanceInfo = new DistanceInfo();
                this.distanceInfo.parseProto(commonLocation);
            }
            this.replyInfo.clear();
            List<ReplyList> list4 = tAInfo.reply_list;
            if (list4 != null) {
                for (int i4 = 0; i4 < list4.size(); i4++) {
                    ReplyInfo replyInfo = new ReplyInfo();
                    replyInfo.parseProto(list4.get(i4));
                    this.replyInfo.add(replyInfo);
                }
            }
        }
    }
}
