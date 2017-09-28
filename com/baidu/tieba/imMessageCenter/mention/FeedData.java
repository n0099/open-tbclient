package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ThreadExpressionActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ReplyMe.ReplyList;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes2.dex */
public class FeedData implements com.baidu.tbadk.mvc.b.a, Serializable {
    public static final String TYPE_DECLARE = "declare";
    public static final String TYPE_GRAFFITI = "graffiti";
    public static final String TYPE_ZAN = "zan";
    private static final long serialVersionUID = -7837936115460478133L;
    private long fromForumId;
    private int hideForumName;
    private boolean isAuthor;
    private int isFloor;
    private boolean mIsStory;
    private String mPraiseItemType;
    private String quote_pid;
    private int mPraiseNum = 0;
    private int mPraiseLiked = 0;
    private List<LikeData> mPraiseList = null;
    private int type = 0;
    private long time = 0;
    private String title = null;
    private String fname = null;
    private String content = null;
    private String quote_content = null;
    private String thread_id = null;
    private String post_id = null;
    private MetaData replyer = new MetaData();
    private MetaData quote_user = new MetaData();
    private int thread_type = 0;

    public String getPraiseItemType() {
        return this.mPraiseItemType;
    }

    public int getPraiseNum() {
        return this.mPraiseNum;
    }

    public int getPraiseLiked() {
        return this.mPraiseLiked;
    }

    public List<LikeData> getPraiseList() {
        return this.mPraiseList;
    }

    public int getType() {
        return this.type;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public String getFname() {
        return this.fname;
    }

    public String getContent() {
        return this.content;
    }

    public String getQuote_content() {
        return this.quote_content;
    }

    public String getThread_id() {
        return this.thread_id;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public MetaData getReplyer() {
        return this.replyer;
    }

    public MetaData getQuote_user() {
        return this.quote_user;
    }

    public boolean getIsFloor() {
        return this.isFloor == 1;
    }

    public String getQuote_pid() {
        return this.quote_pid;
    }

    public int getThread_Type() {
        return this.thread_type;
    }

    public boolean isAuthor() {
        return this.isAuthor;
    }

    public long getFromForumId() {
        return this.fromForumId;
    }

    public boolean isHideForumName() {
        return this.hideForumName == 1;
    }

    public boolean isStory() {
        return this.mIsStory;
    }

    public String toJson() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.type);
            jSONObject.put(VrPlayerActivityConfig.TITLE, this.title);
            jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.time / 1000);
            jSONObject.put(ImageViewerConfig.FORUM_NAME, this.fname);
            jSONObject.put("content", this.content);
            jSONObject.put("quote_content", this.quote_content);
            jSONObject.put("thread_id", this.thread_id);
            jSONObject.put("post_id", this.post_id);
            jSONObject.put("is_floor", this.isFloor);
            jSONObject.put("quote_pid", this.quote_pid);
            jSONObject.put("thread_type", this.thread_type);
            jSONObject.put("v_forum_id", this.fromForumId);
            jSONObject.put("hide_fname", this.hideForumName);
            jSONObject.put("is_story", this.mIsStory ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", this.replyer.getUserId());
            jSONObject2.put("name", this.replyer.getUserName());
            jSONObject2.put(IntentConfig.PORTRAIT, this.replyer.getPortrait());
            jSONObject2.put("gender", this.replyer.getGender());
            jSONObject.put("replyer", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", this.quote_user.getUserId());
            jSONObject3.put("name", this.quote_user.getUserName());
            jSONObject3.put(IntentConfig.PORTRAIT, this.quote_user.getPortrait());
            jSONObject3.put("gender", this.quote_user.getGender());
            jSONObject.put("quote_user", jSONObject3);
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            try {
                this.type = jSONObject.optInt("type", 0);
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.fname = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.content = jSONObject.optString("content");
                this.quote_content = jSONObject.optString("quote_content");
                this.thread_id = jSONObject.optString("thread_id");
                this.post_id = jSONObject.optString("post_id");
                this.isFloor = jSONObject.optInt("is_floor");
                this.quote_pid = jSONObject.optString("quote_pid");
                this.mPraiseItemType = jSONObject.optString("item_type");
                this.fromForumId = jSONObject.optLong("v_forum_id");
                this.hideForumName = jSONObject.optInt("hide_fname");
                this.mIsStory = jSONObject.optInt("is_story") == 1;
                if (((!com.baidu.adp.lib.util.k.isEmpty(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) || this.mPraiseItemType.equals(TYPE_GRAFFITI) || this.mPraiseItemType.equals(TYPE_DECLARE)) && (optJSONObject = jSONObject.optJSONObject(TYPE_ZAN)) != null) {
                    this.mPraiseNum = optJSONObject.optInt("num");
                    this.mPraiseLiked = optJSONObject.optInt(ThreadExpressionActivityConfig.IS_LIKED);
                    this.isAuthor = optJSONObject.optInt("consent_type") == 2;
                    JSONArray optJSONArray = optJSONObject.optJSONArray("liker_list");
                    if (optJSONArray != null) {
                        this.mPraiseList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            LikeData likeData = new LikeData();
                            likeData.parserJson(optJSONArray.optJSONObject(i));
                            this.mPraiseList.add(likeData);
                        }
                    }
                }
                this.replyer.parserJson(jSONObject.optJSONObject("replyer"));
                this.quote_user.parserJson(jSONObject.optJSONObject("quote_user"));
                this.thread_type = jSONObject.optInt("thread_type");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parserProtoBuf(ReplyList replyList) {
        Zan zan;
        if (replyList != null) {
            this.type = replyList.type.intValue();
            this.title = replyList.title;
            this.time = replyList.time.intValue() * 1000;
            this.fname = replyList.fname;
            this.content = replyList.content;
            this.quote_content = replyList.quote_content;
            this.thread_id = String.valueOf(replyList.thread_id);
            this.post_id = String.valueOf(replyList.post_id);
            this.isFloor = replyList.is_floor.intValue();
            this.quote_pid = String.valueOf(replyList.quote_pid);
            this.mPraiseItemType = replyList.item_type;
            this.hideForumName = replyList.hide_fname.intValue();
            this.fromForumId = replyList.v_forum_id.longValue();
            if (((!com.baidu.adp.lib.util.k.isEmpty(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) || this.mPraiseItemType.equals(TYPE_GRAFFITI) || this.mPraiseItemType.equals(TYPE_DECLARE)) && (zan = replyList.zan) != null) {
                this.mPraiseNum = zan.num.intValue();
                this.mPraiseLiked = zan.is_liked.intValue();
                this.isAuthor = zan.consent_type.intValue() == 2;
                List<User> list = zan.liker_list;
                if (list != null) {
                    this.mPraiseList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        LikeData likeData = new LikeData();
                        likeData.parserProtoBuf(list.get(i));
                        this.mPraiseList.add(likeData);
                    }
                }
            }
            this.replyer.parserProtobuf(replyList.replyer);
            this.quote_user.parserProtobuf(replyList.quote_user);
            this.thread_type = replyList.thread_type.intValue();
            this.mIsStory = replyList.is_story.intValue() == 1;
        }
    }
}
