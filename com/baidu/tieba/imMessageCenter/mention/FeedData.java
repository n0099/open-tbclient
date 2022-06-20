package com.baidu.tieba.imMessageCenter.mention;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l65;
import com.repackage.oi;
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
/* loaded from: classes3.dex */
public class FeedData implements Serializable, l65 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_DECLARE = "declare";
    public static final String TYPE_GRAFFITI = "graffiti";
    public static final String TYPE_ZAN = "zan";
    public static final long serialVersionUID = -7837936115460478133L;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public String fname;
    public long fromForumId;
    public int hideForumName;
    public boolean isAuthor;
    public boolean isBjh;
    public int isFirstPost;
    public int isFloor;
    public boolean isNew;
    public BaijiahaoData mBaijiahao;
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
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBaijiahao : (BaijiahaoData) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.content : (String) invokeV.objValue;
    }

    public String getFname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fname : (String) invokeV.objValue;
    }

    public long getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fromForumId : invokeV.longValue;
    }

    public int getIsFirstPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isFirstPost : invokeV.intValue;
    }

    public boolean getIsFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isFloor == 1 : invokeV.booleanValue;
    }

    public List<NewFloorInfo> getNewReplayInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.newReplayInfo : (List) invokeV.objValue;
    }

    public OriginalThreadInfo getOriginalThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mOriginalThreadInfo : (OriginalThreadInfo) invokeV.objValue;
    }

    public String getPostFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.postFrom : (String) invokeV.objValue;
    }

    public String getPost_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.post_id : (String) invokeV.objValue;
    }

    public String getPraiseItemType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mPraiseItemType : (String) invokeV.objValue;
    }

    public List<LikeData> getPraiseList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPraiseList : (List) invokeV.objValue;
    }

    public int getPraiseNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mPraiseNum : invokeV.intValue;
    }

    public String getQuote_content() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.quote_content : (String) invokeV.objValue;
    }

    public String getQuote_pid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.quote_pid : (String) invokeV.objValue;
    }

    public MetaData getQuote_user() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.quote_user : (MetaData) invokeV.objValue;
    }

    public MetaData getReplyer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.replyer : (MetaData) invokeV.objValue;
    }

    public MetaData getThreadAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.threadAuthor : (MetaData) invokeV.objValue;
    }

    public String getThreadImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.threadImgUrl : (String) invokeV.objValue;
    }

    public int getThread_Type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.thread_type : invokeV.intValue;
    }

    public String getThread_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.thread_id : (String) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.time : invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.type : invokeV.intValue;
    }

    public boolean isAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.isAuthor : invokeV.booleanValue;
    }

    public boolean isBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.isBjh : invokeV.booleanValue;
    }

    public boolean isHideForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.hideForumName == 1 : invokeV.booleanValue;
    }

    public boolean isNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.isNew : invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mIsShareThread : invokeV.booleanValue;
    }

    public boolean isStory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mIsStory : invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, jSONObject) == null) || jSONObject == null) {
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
            this.isFirstPost = jSONObject.optInt("is_first_post");
            this.quote_pid = jSONObject.optString("quote_pid");
            this.mPraiseItemType = jSONObject.optString("item_type");
            this.fromForumId = jSONObject.optLong("v_forum_id");
            this.hideForumName = jSONObject.optInt("hide_fname");
            this.mIsStory = jSONObject.optInt("is_story") == 1;
            this.postFrom = jSONObject.optString("post_from");
            boolean z = jSONObject.optInt(VideoPlayActivityConfig.IS_SHARE_THREAD) == 1;
            this.mIsShareThread = z;
            if (z) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.mOriginalThreadInfo = originalThreadInfo;
                originalThreadInfo.q(jSONObject.optJSONObject("origin_thread_info"));
            }
            if (((!oi.isEmpty(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) || this.mPraiseItemType.equals(TYPE_GRAFFITI) || this.mPraiseItemType.equals(TYPE_DECLARE)) && (optJSONObject = jSONObject.optJSONObject(TYPE_ZAN)) != null) {
                this.mPraiseNum = optJSONObject.optInt("num");
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
            this.threadAuthor.parserJson(jSONObject.optJSONObject("thread_author_user"));
            this.quote_user.parserJson(jSONObject.optJSONObject("quote_user"));
            this.thread_type = jSONObject.optInt("thread_type");
            this.threadImgUrl = jSONObject.optString("thread_img_url");
            this.isNew = jSONObject.optInt("unread") == 1;
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
            this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH) == 1;
            if (jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME) != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.mBaijiahao = baijiahaoData;
                baijiahaoData.parseJson(jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME));
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserProtoBuf(ReplyList replyList) {
        Zan zan;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, replyList) == null) || replyList == null) {
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
        if (((!oi.isEmpty(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) || this.mPraiseItemType.equals(TYPE_GRAFFITI) || this.mPraiseItemType.equals(TYPE_DECLARE)) && (zan = replyList.zan) != null) {
            this.mPraiseNum = zan.num.intValue();
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
        this.threadAuthor.parserProtobuf(replyList.thread_author_user);
        this.quote_user.parserProtobuf(replyList.quote_user);
        this.thread_type = replyList.thread_type.intValue();
        this.mIsStory = replyList.is_story.intValue() == 1;
        boolean z = replyList.is_share_thread.intValue() == 1;
        this.mIsShareThread = z;
        if (z) {
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            this.mOriginalThreadInfo = originalThreadInfo;
            originalThreadInfo.n(replyList.origin_thread_info);
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
        this.newReplayInfo = replyList.new_floor_info;
    }

    public void setIsFirstPost(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.isFirstPost = i;
        }
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
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
                int i = 1;
                jSONObject.put("is_story", this.mIsStory ? 1 : 0);
                jSONObject.put("post_from", this.postFrom);
                jSONObject.put("is_first_post", this.isFirstPost);
                jSONObject.put("new_floor_info", this.newReplayInfo);
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
                    i = 0;
                }
                jSONObject.put(VideoPlayActivityConfig.IS_SHARE_THREAD, i);
                if (this.mOriginalThreadInfo != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("title", this.mOriginalThreadInfo.g);
                    jSONObject.put("origin_thread_info", jSONObject5);
                }
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
