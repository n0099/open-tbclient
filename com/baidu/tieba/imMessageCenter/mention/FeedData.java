package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.a.c.e.p.k;
import d.a.n0.g0.b.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ReplyMe.ReplyList;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes4.dex */
public class FeedData implements Serializable, a {
    public static final String TYPE_DECLARE = "declare";
    public static final String TYPE_GRAFFITI = "graffiti";
    public static final String TYPE_ZAN = "zan";
    public static final long serialVersionUID = -7837936115460478133L;
    public String content;
    public String fname;
    public long fromForumId;
    public int hideForumName;
    public boolean isAuthor;
    public int isFloor;
    public boolean isNew;
    public BaijiahaoData mBaijiahao;
    public boolean mIsShareThread;
    public boolean mIsStory;
    public OriginalThreadInfo mOriginalThreadInfo;
    public String mPraiseItemType;
    public String postFrom;
    public String post_id;
    public String quote_content;
    public String quote_pid;
    public String threadImgUrl;
    public String thread_id;
    public int thread_type;
    public long time;
    public String title;
    public int type;
    public MetaData replyer = new MetaData();
    public MetaData threadAuthor = new MetaData();
    public MetaData quote_user = new MetaData();
    public int mPraiseNum = 0;
    public List<LikeData> mPraiseList = null;
    public boolean isBjh = false;

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public String getContent() {
        return this.content;
    }

    public String getFname() {
        return this.fname;
    }

    public long getFromForumId() {
        return this.fromForumId;
    }

    public boolean getIsFloor() {
        return this.isFloor == 1;
    }

    public OriginalThreadInfo getOriginalThreadInfo() {
        return this.mOriginalThreadInfo;
    }

    public String getPostFrom() {
        return this.postFrom;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public String getPraiseItemType() {
        return this.mPraiseItemType;
    }

    public List<LikeData> getPraiseList() {
        return this.mPraiseList;
    }

    public int getPraiseNum() {
        return this.mPraiseNum;
    }

    public String getQuote_content() {
        return this.quote_content;
    }

    public String getQuote_pid() {
        return this.quote_pid;
    }

    public MetaData getQuote_user() {
        return this.quote_user;
    }

    public MetaData getReplyer() {
        return this.replyer;
    }

    public MetaData getThreadAuthor() {
        return this.threadAuthor;
    }

    public String getThreadImgUrl() {
        return this.threadImgUrl;
    }

    public int getThread_Type() {
        return this.thread_type;
    }

    public String getThread_id() {
        return this.thread_id;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isAuthor() {
        return this.isAuthor;
    }

    public boolean isBjh() {
        return this.isBjh;
    }

    public boolean isHideForumName() {
        return this.hideForumName == 1;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean isStory() {
        return this.mIsStory;
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        try {
            this.type = jSONObject.optInt("type", 0);
            this.title = jSONObject.optString("title");
            this.time = jSONObject.optLong("time", 0L) * 1000;
            this.fname = jSONObject.optString("fname");
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
            this.postFrom = jSONObject.optString("post_from");
            boolean z = jSONObject.optInt("is_share_thread") == 1;
            this.mIsShareThread = z;
            if (z) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.mOriginalThreadInfo = originalThreadInfo;
                originalThreadInfo.l(jSONObject.optJSONObject("origin_thread_info"));
            }
            if (((!k.isEmpty(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) || this.mPraiseItemType.equals(TYPE_GRAFFITI) || this.mPraiseItemType.equals(TYPE_DECLARE)) && (optJSONObject = jSONObject.optJSONObject(TYPE_ZAN)) != null) {
                this.mPraiseNum = optJSONObject.optInt("num");
                this.isAuthor = optJSONObject.optInt("consent_type") == 2;
                JSONArray optJSONArray = optJSONObject.optJSONArray("liker_list");
                if (optJSONArray != null) {
                    this.mPraiseList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        LikeData likeData = new LikeData();
                        likeData.parserJson(optJSONArray.optJSONObject(i2));
                        this.mPraiseList.add(likeData);
                    }
                }
            }
            this.replyer.parserJson(jSONObject.optJSONObject("replyer"));
            this.threadAuthor.parserJson(jSONObject.optJSONObject("thread_author_user"));
            this.quote_user.parserJson(jSONObject.optJSONObject("quote_user"));
            this.thread_type = jSONObject.optInt("thread_type");
            this.threadImgUrl = jSONObject.optString("thread_img_url");
            this.isNew = jSONObject.optInt("unread") == 1;
            this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH) == 1;
            if (jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME) != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.mBaijiahao = baijiahaoData;
                baijiahaoData.parseJson(jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME));
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtoBuf(ReplyList replyList) {
        Zan zan;
        if (replyList == null) {
            return;
        }
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
        if (((!k.isEmpty(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) || this.mPraiseItemType.equals(TYPE_GRAFFITI) || this.mPraiseItemType.equals(TYPE_DECLARE)) && (zan = replyList.zan) != null) {
            this.mPraiseNum = zan.num.intValue();
            this.isAuthor = zan.consent_type.intValue() == 2;
            List<User> list = zan.liker_list;
            if (list != null) {
                this.mPraiseList = new ArrayList();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    LikeData likeData = new LikeData();
                    likeData.parserProtoBuf(list.get(i2));
                    this.mPraiseList.add(likeData);
                }
            }
        }
        this.replyer.parserProtobuf(replyList.replyer);
        this.threadAuthor.parserProtobuf(replyList.thread_author_user);
        this.quote_user.parserProtobuf(replyList.quote_user);
        this.thread_type = replyList.thread_type.intValue();
        this.mIsStory = replyList.is_story.intValue() == 1;
        boolean z = replyList.is_share_thread.intValue() == 1;
        this.mIsShareThread = z;
        if (z) {
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            this.mOriginalThreadInfo = originalThreadInfo;
            originalThreadInfo.j(replyList.origin_thread_info);
        }
        this.postFrom = replyList.post_from;
        this.threadImgUrl = replyList.thread_img_url;
        this.isNew = replyList.unread.intValue() == 1;
        this.isBjh = replyList.is_bjh.intValue() == 1;
        if (replyList.baijiahao != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            this.mBaijiahao = baijiahaoData;
            baijiahaoData.parseProto(replyList.baijiahao);
        }
    }

    public String toJson() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.type);
            jSONObject.put("title", this.title);
            jSONObject.put("time", this.time / 1000);
            jSONObject.put("fname", this.fname);
            jSONObject.put("content", this.content);
            jSONObject.put("quote_content", this.quote_content);
            jSONObject.put("thread_id", this.thread_id);
            jSONObject.put("post_id", this.post_id);
            jSONObject.put("is_floor", this.isFloor);
            jSONObject.put("quote_pid", this.quote_pid);
            jSONObject.put("thread_type", this.thread_type);
            jSONObject.put("v_forum_id", this.fromForumId);
            jSONObject.put("hide_fname", this.hideForumName);
            int i2 = 1;
            jSONObject.put("is_story", this.mIsStory ? 1 : 0);
            jSONObject.put("post_from", this.postFrom);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", this.replyer.getUserId());
            jSONObject2.put("name", this.replyer.getUserName());
            jSONObject2.put("portrait", this.replyer.getPortrait());
            jSONObject2.put("gender", this.replyer.getGender());
            jSONObject.put("replyer", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject2.put("id", this.threadAuthor.getUserId());
            jSONObject2.put("name", this.threadAuthor.getUserName());
            jSONObject2.put("portrait", this.threadAuthor.getPortrait());
            jSONObject2.put("gender", this.threadAuthor.getGender());
            jSONObject.put("thread_author_user", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("id", this.quote_user.getUserId());
            jSONObject4.put("name", this.quote_user.getUserName());
            jSONObject4.put("portrait", this.quote_user.getPortrait());
            jSONObject4.put("gender", this.quote_user.getGender());
            jSONObject.put("quote_user", jSONObject4);
            if (!this.mIsShareThread) {
                i2 = 0;
            }
            jSONObject.put("is_share_thread", i2);
            if (this.mOriginalThreadInfo != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("title", this.mOriginalThreadInfo.f12183g);
                jSONObject.put("origin_thread_info", jSONObject5);
            }
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONArray.toString();
    }
}
