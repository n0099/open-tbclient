package com.baidu.tieba.immessagecenter.mention;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.bi;
import com.baidu.tieba.cq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.NewFloorInfo;
import tbclient.PbContent;
import tbclient.ReplyMe.ReplyList;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes6.dex */
public class FeedData implements Serializable, cq5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_DECLARE = "declare";
    public static final String TYPE_GRAFFITI = "graffiti";
    public static final String TYPE_ZAN = "zan";
    public static final long serialVersionUID = -7837936115460478133L;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public String fname;
    public long fromForumId;
    public boolean hasAgree;
    public int hideForumName;
    public boolean isAuthor;
    public boolean isBjh;
    public int isFirstPost;
    public int isFloor;
    public boolean isNew;
    public BaijiahaoData mBaijiahao;
    public int mIsBotReply;
    public boolean mIsShareThread;
    public boolean mIsStory;
    public OriginalThreadInfo mOriginalThreadInfo;
    public String mPraiseItemType;
    public List<LikeData> mPraiseList;
    public int mPraiseNum;
    public List<NewFloorInfo> newReplayInfo;
    public String postFrom;
    public String post_id;
    public String quote_content;
    public String quote_pid;
    public MetaData quote_user;
    public MetaData replyer;
    public String targetScheme;
    public MetaData threadAuthor;
    public String threadImgUrl;
    public String thread_id;
    public int thread_type;
    public long time;
    public String title;
    public int type;

    public FeedData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.replyer = new MetaData();
        this.threadAuthor = new MetaData();
        this.quote_user = new MetaData();
        this.mPraiseNum = 0;
        this.mPraiseList = null;
        this.isBjh = false;
        this.mIsBotReply = 0;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBaijiahao;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public String getFname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.fname;
        }
        return (String) invokeV.objValue;
    }

    public long getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.fromForumId;
        }
        return invokeV.longValue;
    }

    public boolean getHasAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.hasAgree;
        }
        return invokeV.booleanValue;
    }

    public int getIsFirstPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.isFirstPost;
        }
        return invokeV.intValue;
    }

    public boolean getIsFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.isFloor == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<NewFloorInfo> getNewReplayInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.newReplayInfo;
        }
        return (List) invokeV.objValue;
    }

    public OriginalThreadInfo getOriginalThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mOriginalThreadInfo;
        }
        return (OriginalThreadInfo) invokeV.objValue;
    }

    public String getPostFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.postFrom;
        }
        return (String) invokeV.objValue;
    }

    public String getPost_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.post_id;
        }
        return (String) invokeV.objValue;
    }

    public String getPraiseItemType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mPraiseItemType;
        }
        return (String) invokeV.objValue;
    }

    public List<LikeData> getPraiseList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mPraiseList;
        }
        return (List) invokeV.objValue;
    }

    public int getPraiseNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mPraiseNum;
        }
        return invokeV.intValue;
    }

    public String getQuote_content() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.quote_content;
        }
        return (String) invokeV.objValue;
    }

    public String getQuote_pid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.quote_pid;
        }
        return (String) invokeV.objValue;
    }

    public MetaData getQuote_user() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.quote_user;
        }
        return (MetaData) invokeV.objValue;
    }

    public MetaData getReplyer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.replyer;
        }
        return (MetaData) invokeV.objValue;
    }

    public String getTargetScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.targetScheme;
        }
        return (String) invokeV.objValue;
    }

    public MetaData getThreadAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.threadAuthor;
        }
        return (MetaData) invokeV.objValue;
    }

    public String getThreadImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.threadImgUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getThread_Type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.thread_type;
        }
        return invokeV.intValue;
    }

    public String getThread_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.thread_id;
        }
        return (String) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.time;
        }
        return invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public boolean isAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.isAuthor;
        }
        return invokeV.booleanValue;
    }

    public boolean isBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.isBjh;
        }
        return invokeV.booleanValue;
    }

    public boolean isBotReply() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.mIsBotReply == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHideForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.hideForumName == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.isNew;
        }
        return invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mIsShareThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isStory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mIsStory;
        }
        return invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        JSONObject optJSONObject;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, jSONObject) != null) || jSONObject == null) {
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
            if (jSONObject.optInt("has_agree") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.hasAgree = z;
            this.isFloor = jSONObject.optInt("is_floor");
            this.isFirstPost = jSONObject.optInt("is_first_post");
            this.quote_pid = jSONObject.optString("quote_pid");
            this.mPraiseItemType = jSONObject.optString("item_type");
            this.fromForumId = jSONObject.optLong("v_forum_id");
            this.hideForumName = jSONObject.optInt("hide_fname");
            if (jSONObject.optInt("is_story") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mIsStory = z2;
            this.postFrom = jSONObject.optString("post_from");
            if (jSONObject.optInt(VideoPlayActivityConfig.IS_SHARE_THREAD) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.mIsShareThread = z3;
            if (z3) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.mOriginalThreadInfo = originalThreadInfo;
                originalThreadInfo.r(jSONObject.optJSONObject("origin_thread_info"));
            }
            if (((!bi.isEmpty(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) || this.mPraiseItemType.equals(TYPE_GRAFFITI) || this.mPraiseItemType.equals(TYPE_DECLARE)) && (optJSONObject = jSONObject.optJSONObject(TYPE_ZAN)) != null) {
                this.mPraiseNum = optJSONObject.optInt("num");
                if (optJSONObject.optInt("consent_type") == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.isAuthor = z6;
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
            this.threadAuthor.parserJson(jSONObject.optJSONObject("thread_author_user"));
            this.quote_user.parserJson(jSONObject.optJSONObject("quote_user"));
            this.thread_type = jSONObject.optInt("thread_type");
            this.threadImgUrl = jSONObject.optString("thread_img_url");
            if (jSONObject.optInt("unread") == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.isNew = z4;
            this.newReplayInfo = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("new_floor_info");
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                NewFloorInfo.Builder builder = new NewFloorInfo.Builder();
                JSONArray jSONArray = jSONObject2.getJSONArray("content");
                builder.content = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    PbContent.Builder builder2 = new PbContent.Builder();
                    builder2.text = jSONArray.getJSONObject(i3).optString("text");
                    builder2.type = Integer.valueOf(jSONArray.getJSONObject(i3).optInt("type"));
                    builder2.link = jSONArray.getJSONObject(i3).optString("link");
                    builder2.uid = Long.valueOf(jSONArray.getJSONObject(i3).optLong("uid"));
                    builder.content.add(builder2.build(true));
                }
                builder.is_floor = Integer.valueOf(jSONObject2.getInt("is_floor"));
                this.newReplayInfo.add(builder.build(true));
            }
            if (jSONObject.optInt(ImageViewerConfig.IS_BJH) == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.isBjh = z5;
            if (jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME) != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.mBaijiahao = baijiahaoData;
                baijiahaoData.parseJson(jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME));
            }
            this.mIsBotReply = jSONObject.optInt("is_bot_reply");
            this.targetScheme = jSONObject.optString("target_scheme");
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserProtoBuf(ReplyList replyList) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Zan zan;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, replyList) != null) || replyList == null) {
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
        boolean z6 = false;
        if (replyList.has_agree.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hasAgree = z;
        this.isFloor = replyList.is_floor.intValue();
        this.quote_pid = String.valueOf(replyList.quote_pid);
        this.mPraiseItemType = replyList.item_type;
        this.hideForumName = replyList.hide_fname.intValue();
        this.fromForumId = replyList.v_forum_id.longValue();
        if (((!bi.isEmpty(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) || this.mPraiseItemType.equals(TYPE_GRAFFITI) || this.mPraiseItemType.equals(TYPE_DECLARE)) && (zan = replyList.zan) != null) {
            this.mPraiseNum = zan.num.intValue();
            if (zan.consent_type.intValue() == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.isAuthor = z5;
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
        this.threadAuthor.parserProtobuf(replyList.thread_author_user);
        this.quote_user.parserProtobuf(replyList.quote_user);
        this.thread_type = replyList.thread_type.intValue();
        if (replyList.is_story.intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIsStory = z2;
        if (replyList.is_share_thread.intValue() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.mIsShareThread = z3;
        if (z3) {
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            this.mOriginalThreadInfo = originalThreadInfo;
            originalThreadInfo.o(replyList.origin_thread_info);
        }
        this.postFrom = replyList.post_from;
        this.threadImgUrl = replyList.thread_img_url;
        if (replyList.unread.intValue() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.isNew = z4;
        if (replyList.is_bjh.intValue() == 1) {
            z6 = true;
        }
        this.isBjh = z6;
        if (replyList.baijiahao != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            this.mBaijiahao = baijiahaoData;
            baijiahaoData.parseProto(replyList.baijiahao);
        }
        this.targetScheme = replyList.target_scheme;
        this.newReplayInfo = replyList.new_floor_info;
    }

    public void setIsFirstPost(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.isFirstPost = i;
        }
    }

    public String toJson() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
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
                jSONObject.put("has_agree", this.hasAgree);
                jSONObject.put("is_floor", this.isFloor);
                jSONObject.put("quote_pid", this.quote_pid);
                jSONObject.put("thread_type", this.thread_type);
                jSONObject.put("v_forum_id", this.fromForumId);
                jSONObject.put("hide_fname", this.hideForumName);
                int i2 = 1;
                if (this.mIsStory) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("is_story", i);
                jSONObject.put("post_from", this.postFrom);
                jSONObject.put("is_first_post", this.isFirstPost);
                jSONObject.put("new_floor_info", this.newReplayInfo);
                jSONObject.put("target_scheme", this.targetScheme);
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
                jSONObject.put(VideoPlayActivityConfig.IS_SHARE_THREAD, i2);
                if (this.mOriginalThreadInfo != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("title", this.mOriginalThreadInfo.g);
                    jSONObject.put("origin_thread_info", jSONObject5);
                }
                jSONArray.put(jSONObject);
                jSONObject.put("is_bot_reply", this.mIsBotReply);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
