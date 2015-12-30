package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.AnchorInfo;
import tbclient.LbsInfo;
import tbclient.Media;
import tbclient.PostInfoContent;
import tbclient.PostInfoList;
import tbclient.Quote;
import tbclient.VideoInfo;
import tbclient.Voice;
/* loaded from: classes.dex */
public class PersonInfoPostList implements Serializable {
    private static final long serialVersionUID = 4381439596593543429L;
    private String _abstract;
    private PersonInfoPostAnchor anchorInfo;
    private String contentThread;
    private int createTime;
    private long forumId;
    private String forumName;
    private int hidePost;
    private String ip;
    private int isPostDeleted;
    private int isThread;
    private PersonInfoPostLbs lbsInfo;
    private String pType;
    private long postId;
    private String postType;
    private PersonInfoPostQuote quote;
    private int replyNum;
    private long threadId;
    private long threadType;
    private String title;
    private long userId;
    private String userName;
    private String userPortrait;
    private PersonInfoVideo videoInfo;
    private List<PersonInfoPostContent> contentList = new ArrayList();
    private List<PersonInfoAbstract> abstractThread = new ArrayList();
    private List<PersonInfoMedia> media = new ArrayList();
    private List<PersonInfoPostVoice> voiceInfo = new ArrayList();

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optLong("forum_id");
            this.threadId = jSONObject.optLong("thread_id");
            this.threadType = jSONObject.optLong(PbActivityConfig.KEY_THREAD_TYPE);
            this.postId = jSONObject.optLong("post_id");
            this.isThread = jSONObject.optInt("is_thread");
            this.createTime = jSONObject.optInt("create_time");
            this.forumName = jSONObject.optString("forum_name");
            this.title = jSONObject.optString("title");
            this.contentThread = jSONObject.optString("content_thread");
            this.userName = jSONObject.optString("user_name");
            this.ip = jSONObject.optString("ip");
            this.isPostDeleted = jSONObject.optInt("is_post_deleted");
            this.pType = jSONObject.optString("ptype");
            this._abstract = jSONObject.optString("_abstract");
            this.replyNum = jSONObject.optInt("reply_num");
            this.userId = jSONObject.optLong("user_id");
            this.userPortrait = jSONObject.optString("user_portrait");
            this.postType = jSONObject.optString("post_type");
            this.hidePost = jSONObject.optInt("hide_post");
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                if (this.lbsInfo == null) {
                    this.lbsInfo = new PersonInfoPostLbs();
                }
                this.lbsInfo.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("quote");
            if (optJSONObject2 != null) {
                if (this.quote == null) {
                    this.quote = new PersonInfoPostQuote();
                }
                this.quote.parseJson(optJSONObject2);
            }
            if (jSONObject.optJSONObject("anchor_info") != null) {
                if (this.anchorInfo == null) {
                    this.anchorInfo = new PersonInfoPostAnchor();
                }
                this.anchorInfo.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("video_info");
            if (optJSONObject3 != null) {
                if (this.videoInfo == null) {
                    this.videoInfo = new PersonInfoVideo();
                }
                this.videoInfo.parseJson(optJSONObject3);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("voice_info");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                    if (optJSONObject4 != null) {
                        PersonInfoPostVoice personInfoPostVoice = new PersonInfoPostVoice();
                        personInfoPostVoice.parseJson(optJSONObject4);
                        this.voiceInfo.add(personInfoPostVoice);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject5 != null) {
                        PersonInfoMedia personInfoMedia = new PersonInfoMedia();
                        personInfoMedia.parseJson(optJSONObject5);
                        this.media.add(personInfoMedia);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("abstract_thread");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i3);
                    if (optJSONObject6 != null) {
                        PersonInfoAbstract personInfoAbstract = new PersonInfoAbstract();
                        personInfoAbstract.parseJson(optJSONObject6);
                        this.abstractThread.add(personInfoAbstract);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            if (optJSONArray4 != null) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    JSONObject optJSONObject7 = optJSONArray4.optJSONObject(i4);
                    if (optJSONObject7 != null) {
                        PersonInfoPostContent personInfoPostContent = new PersonInfoPostContent();
                        personInfoPostContent.parseJson(optJSONObject7);
                        this.contentList.add(personInfoPostContent);
                    }
                }
            }
        }
    }

    public void parseProto(PostInfoList postInfoList) {
        if (postInfoList != null) {
            this.forumId = postInfoList.forum_id.longValue();
            this.threadId = postInfoList.thread_id.longValue();
            this.threadType = postInfoList.thread_type.longValue();
            this.postId = postInfoList.post_id.longValue();
            this.isThread = postInfoList.is_thread.intValue();
            this.createTime = postInfoList.create_time.intValue();
            this.forumName = postInfoList.forum_name;
            this.title = postInfoList.title;
            this.contentThread = postInfoList.content_thread;
            this.userName = postInfoList.user_name;
            this.ip = postInfoList.ip;
            this.isPostDeleted = postInfoList.is_post_deleted.intValue();
            this.pType = postInfoList.ptype;
            this._abstract = postInfoList._abstract;
            this.replyNum = postInfoList.reply_num.intValue();
            this.userId = postInfoList.user_id.longValue();
            this.userPortrait = postInfoList.user_portrait;
            this.postType = postInfoList.post_type;
            this.hidePost = postInfoList.hide_post.intValue();
            LbsInfo lbsInfo = postInfoList.lbs_info;
            if (this.lbsInfo == null) {
                this.lbsInfo = new PersonInfoPostLbs();
            }
            this.lbsInfo.parseProto(lbsInfo);
            Quote quote = postInfoList.quote;
            if (this.quote == null) {
                this.quote = new PersonInfoPostQuote();
            }
            this.quote.parseProto(quote);
            AnchorInfo anchorInfo = postInfoList.anchor_info;
            if (this.anchorInfo == null) {
                this.anchorInfo = new PersonInfoPostAnchor();
            }
            this.anchorInfo.parseProto(anchorInfo);
            VideoInfo videoInfo = postInfoList.video_info;
            if (this.videoInfo == null) {
                this.videoInfo = new PersonInfoVideo();
            }
            this.videoInfo.parserProtobuf(videoInfo);
            List<PostInfoContent> list = postInfoList.content;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    PersonInfoPostContent personInfoPostContent = new PersonInfoPostContent();
                    personInfoPostContent.parseProto(list.get(i));
                    this.contentList.add(personInfoPostContent);
                }
            }
            List<Abstract> list2 = postInfoList.abstract_thread;
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    PersonInfoAbstract personInfoAbstract = new PersonInfoAbstract();
                    personInfoAbstract.parseProto(list2.get(i2));
                    this.abstractThread.add(personInfoAbstract);
                }
            }
            List<Media> list3 = postInfoList.media;
            if (list3 != null) {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    PersonInfoMedia personInfoMedia = new PersonInfoMedia();
                    personInfoMedia.parseProto(list3.get(i3));
                    this.media.add(personInfoMedia);
                }
            }
            List<Voice> list4 = postInfoList.voice_info;
            if (list4 != null) {
                for (int i4 = 0; i4 < list4.size(); i4++) {
                    PersonInfoPostVoice personInfoPostVoice = new PersonInfoPostVoice();
                    personInfoPostVoice.parseProto(list4.get(i4));
                    this.voiceInfo.add(personInfoPostVoice);
                }
            }
        }
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadType() {
        return this.threadType;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public long getPostId() {
        return this.postId;
    }

    public int getIsThread() {
        return this.isThread;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getTitle() {
        return this.title;
    }

    public List<PersonInfoPostContent> getContentList() {
        return this.contentList;
    }

    public String getContentThread() {
        return this.contentThread;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getIp() {
        return this.ip;
    }

    public int getIsPostDeleted() {
        return this.isPostDeleted;
    }

    public String getpType() {
        return this.pType;
    }

    public String get_abstract() {
        return this._abstract;
    }

    public List<PersonInfoAbstract> getAbstractThread() {
        return this.abstractThread;
    }

    public List<PersonInfoMedia> getMedia() {
        return this.media;
    }

    public int getReplyNum() {
        return this.replyNum;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserPortrait() {
        return this.userPortrait;
    }

    public String getPostType() {
        return this.postType;
    }

    public PersonInfoPostLbs getLbsInfo() {
        return this.lbsInfo;
    }

    public PersonInfoPostQuote getQuote() {
        return this.quote;
    }

    public List<PersonInfoPostVoice> getVoiceInfo() {
        return this.voiceInfo;
    }

    public PersonInfoPostAnchor getAnchorInfo() {
        return this.anchorInfo;
    }

    public PersonInfoVideo getVideoInfo() {
        return this.videoInfo;
    }

    public int getHidePost() {
        return this.hidePost;
    }
}
