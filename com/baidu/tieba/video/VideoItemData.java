package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cq4;
import com.repackage.fi5;
import com.repackage.hq4;
import com.repackage.og;
import com.repackage.z65;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BaijiahaoInfo;
import tbclient.PbContent;
import tbclient.User;
import tbclient.VideoInfo;
import tbclient.WorkCreatorInfo;
/* loaded from: classes4.dex */
public class VideoItemData implements Serializable, Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<VideoItemData> CREATOR;
    public static final int TYPE_MORE = 1;
    public static final int TYPE_NOMAL = 0;
    public static final int VIDEO_TYPE_BJH = 3;
    public static final int VIDEO_TYPE_DYNAMIC = 2;
    public static final int VIDEO_TYPE_NORMAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String abstext;
    public ActivityItemData act_info;
    public String agree_num;
    public UserItemData author_info;
    public BaijiahaoData baijiahaoData;
    public int channel_mid_request_num;
    public int channel_mid_request_video_num;
    public String comment_num;
    public int discoverType;
    public transient SparseArray<String> feedBackExtraMap;
    public transient SparseArray<String> feedBackReasonMap;
    public boolean forbidComment;
    public String forum_id;
    public String forum_name;
    @Nullable
    public String highLightPostId;
    public boolean isBjhVideo;
    public boolean isTitleExpanded;
    public int isVerticalVideo;
    public String is_agreed;
    public String is_deleted;
    public int is_manager;
    public int is_origin_manager;
    public String is_private;
    public AlaInfoData mAlaInfoData;
    public String mExtra;
    public String mMd5;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    public transient List<PbContent> mRichAbstractList;
    public long mVideoWatchDuration;
    public WorksInfoData mWorksInfoData;
    public String mark_id;
    public String nid;
    public String noCommetStr;
    public int play_count;
    public String post_id;
    @Nullable
    public transient List<PbContent> richTitle;
    public String share_num;
    public String tags;
    public transient ThreadData threadData;
    public String thread_id;
    public String thumbnail_height;
    public String thumbnail_url;
    public String thumbnail_width;
    public String title;
    @Nullable
    public SpannableStringBuilder titleSsb;
    public int video_duration;
    public String video_height;
    public String video_length;
    public String video_log_id;
    public String video_url;
    public String video_width;

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<VideoItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VideoItemData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new VideoItemData(parcel) : (VideoItemData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VideoItemData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new VideoItemData[i] : (VideoItemData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(455935813, "Lcom/baidu/tieba/video/VideoItemData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(455935813, "Lcom/baidu/tieba/video/VideoItemData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public VideoItemData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isBjhVideo = false;
        this.forbidComment = false;
        this.discoverType = 0;
        this.isTitleExpanded = false;
        this.feedBackReasonMap = null;
        this.feedBackExtraMap = null;
    }

    private boolean compareString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            if (StringUtils.isNull(str) && StringUtils.isNull(str2)) {
                return true;
            }
            return Objects.equals(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean isBarManager(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? i == 1 : invokeI.booleanValue;
    }

    public static boolean isBarOwner(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? i == 2 : invokeI.booleanValue;
    }

    public VideoItemData buildWithFlutterMap(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            if (map != null && !map.isEmpty()) {
                this.thread_id = (String) map.get("tid");
                Object obj = map.get("rich_title");
                if (obj != null) {
                    this.richTitle = DataExt.toEntityList(DataExt.toJson(obj), PbContent.class);
                }
                try {
                    Object obj2 = map.get("rich_abstract");
                    if (obj2 != null) {
                        this.mRichAbstractList = hq4.a(new JSONArray(DataExt.toJson(obj2)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean z = false;
                this.is_manager = og.e((String) map.get("is_manager"), 0);
                this.is_origin_manager = og.e((String) map.get("is_origin_manager"), 0);
                this.nid = (String) map.get("nid");
                this.post_id = (String) map.get("first_post_id");
                if (map.get(WriteActivityConfig.VIDEO_INFO) instanceof Map) {
                    Map map2 = (Map) map.get(WriteActivityConfig.VIDEO_INFO);
                    this.thumbnail_width = String.valueOf(map2.get("thumbnail_width"));
                    this.thumbnail_height = String.valueOf(map2.get("thumbnail_height"));
                    this.mMd5 = (String) map2.get(VideoFinishResult.KEY_VIDEO_MD5);
                    this.video_url = (String) map2.get("video_url");
                    this.video_duration = og.e((String) map2.get(AdWebVideoActivityConfig.KEY_VIDEO_DURATION), 0);
                    this.video_width = String.valueOf(map2.get("video_width"));
                    this.video_height = String.valueOf(map2.get("video_height"));
                    this.isVerticalVideo = og.a(map2.get(TiebaStatic.Params.IS_VERTICAL), false) ? 1 : 0;
                    this.thumbnail_url = (String) map2.get("thumbnail_url");
                    this.play_count = og.e((String) map2.get("play_count"), 0);
                }
                this.comment_num = (String) map.get("reply_num");
                this.share_num = (String) map.get("share_num");
                this.title = (String) map.get("title");
                this.forum_id = String.valueOf(map.get("fid"));
                this.forum_name = (String) map.get("fname");
                if (map.get("agree") instanceof Map) {
                    Map map3 = (Map) map.get("agree");
                    this.agree_num = (String) map3.get("agree_num");
                    this.is_agreed = (String) map3.get("has_agree");
                }
                if (map.get(Constants.PAGE_BAIJIAHAO_NAME) instanceof Map) {
                    Map map4 = (Map) map.get(Constants.PAGE_BAIJIAHAO_NAME);
                    BaijiahaoData baijiahaoData = new BaijiahaoData();
                    baijiahaoData.oriUgcNid = (String) map4.get("ori_ugc_nid");
                    baijiahaoData.oriUgcTid = (String) map4.get("ori_ugc_tid");
                    baijiahaoData.oriUgcType = og.e((String) map4.get(TiebaStatic.Params.UGC_TYPE), 0);
                    baijiahaoData.oriUgcVid = (String) map4.get("ori_ugc_vid");
                    baijiahaoData.forwardUrl = (String) map4.get("forward_url");
                    this.baijiahaoData = baijiahaoData;
                }
                if (map.get(NotificationCompat.CarExtender.KEY_AUTHOR) instanceof Map) {
                    Map map5 = (Map) map.get(NotificationCompat.CarExtender.KEY_AUTHOR);
                    UserItemData userItemData = new UserItemData();
                    userItemData.user_name = (String) map5.get("name");
                    userItemData.name_show = (String) map5.get("name_show");
                    userItemData.portrait = (String) map5.get("portrait");
                    userItemData.user_id = (String) map5.get("id");
                    userItemData.is_follow = (String) map5.get("has_concerned");
                    if (map5.get("baijiahao_info") instanceof Map) {
                        userItemData.bjhAvatar = (String) ((Map) map5.get("baijiahao_info")).get("avatar");
                    }
                    if (map5.get("work_creator_info") instanceof Map) {
                        userItemData.auth = (String) ((Map) map5.get("work_creator_info")).get("auth_desc");
                    }
                    this.author_info = userItemData;
                }
                ThreadData threadData = new ThreadData();
                this.threadData = threadData;
                try {
                    threadData.parserJson(new JSONObject(DataExt.toJson(map)));
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                BaijiahaoData baijiahaoData2 = this.baijiahaoData;
                if (baijiahaoData2 != null && UtilHelper.isUgcThreadType(baijiahaoData2.oriUgcType)) {
                    z = true;
                }
                this.isBjhVideo = z;
            }
            return this;
        }
        return (VideoItemData) invokeL.objValue;
    }

    public VideoItemData buildWithOriginThreadData(OriginalThreadInfo originalThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, originalThreadInfo)) == null) {
            if (originalThreadInfo != null) {
                this.thread_id = originalThreadInfo.f;
                this.post_id = originalThreadInfo.n;
                VideoInfo videoInfo = originalThreadInfo.r;
                if (videoInfo != null) {
                    this.thumbnail_url = videoInfo.thumbnail_url;
                    this.video_url = videoInfo.video_url;
                    this.video_height = String.valueOf(videoInfo.video_height);
                    this.video_width = String.valueOf(originalThreadInfo.r.video_width);
                    VideoInfo videoInfo2 = originalThreadInfo.r;
                    this.mMd5 = videoInfo2.video_md5;
                    this.video_duration = videoInfo2.video_duration.intValue();
                    this.play_count = originalThreadInfo.r.play_count.intValue();
                    this.isVerticalVideo = originalThreadInfo.r.is_vertical.intValue();
                }
                this.comment_num = String.valueOf(originalThreadInfo.A);
                this.agree_num = String.valueOf(originalThreadInfo.z.agree_num);
                this.share_num = String.valueOf(originalThreadInfo.B);
                String str = originalThreadInfo.g;
                this.title = str;
                if (TextUtils.isEmpty(str)) {
                    this.title = originalThreadInfo.b;
                }
                this.forum_id = String.valueOf(originalThreadInfo.e);
                this.baijiahaoData = originalThreadInfo.p;
                this.forum_name = originalThreadInfo.d;
                this.is_agreed = String.valueOf(originalThreadInfo.z.has_agree);
                if (originalThreadInfo.y != null) {
                    UserItemData userItemData = new UserItemData();
                    User user = originalThreadInfo.y;
                    userItemData.user_name = user.name;
                    userItemData.name_show = user.name_show;
                    userItemData.portrait = user.portrait;
                    userItemData.user_id = String.valueOf(user.id);
                    userItemData.is_follow = String.valueOf(originalThreadInfo.y.has_concerned);
                    BaijiahaoInfo baijiahaoInfo = originalThreadInfo.y.baijiahao_info;
                    if (baijiahaoInfo != null) {
                        userItemData.bjhAvatar = baijiahaoInfo.avatar;
                    }
                    WorkCreatorInfo workCreatorInfo = originalThreadInfo.y.work_creator_info;
                    if (workCreatorInfo != null) {
                        userItemData.auth = workCreatorInfo.auth_desc;
                    }
                    this.author_info = userItemData;
                }
                this.act_info = originalThreadInfo.d();
                this.isBjhVideo = originalThreadInfo.i();
                this.threadData = originalThreadInfo.b();
                this.richTitle = originalThreadInfo.f();
            }
            return this;
        }
        return (VideoItemData) invokeL.objValue;
    }

    public VideoItemData buildWithThreadData(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                this.threadData = threadData;
                this.thread_id = threadData.getTid();
                this.is_manager = threadData.getIsManager();
                this.is_origin_manager = threadData.getIsOriginManager();
                this.nid = threadData.getNid();
                this.post_id = threadData.getFirst_post_id();
                if (threadData.getThreadVideoInfo() != null) {
                    this.thumbnail_url = threadData.getThreadVideoInfo().thumbnail_url;
                    this.video_url = threadData.getThreadVideoInfo().video_url;
                    this.video_height = String.valueOf(threadData.getThreadVideoInfo().video_height);
                    this.video_width = String.valueOf(threadData.getThreadVideoInfo().video_width);
                    this.mMd5 = threadData.getThreadVideoInfo().video_md5;
                    this.video_duration = threadData.getThreadVideoInfo().video_duration.intValue();
                    this.play_count = threadData.getThreadVideoInfo().play_count.intValue();
                    this.isVerticalVideo = threadData.getThreadVideoInfo().is_vertical.intValue();
                }
                this.comment_num = String.valueOf(threadData.getReply_num());
                this.agree_num = String.valueOf(threadData.getAgreeNum());
                this.share_num = String.valueOf(threadData.getShareNum());
                this.title = threadData.getTitle();
                this.richTitle = threadData.getRichTitle();
                this.mRichAbstractList = threadData.getRichAbstractList();
                this.abstext = threadData.getAbstract();
                this.forum_id = String.valueOf(threadData.getFid());
                this.baijiahaoData = threadData.getBaijiahaoData();
                this.forum_name = threadData.getForum_name();
                this.is_agreed = String.valueOf(threadData.getHasAgree());
                if (threadData.getAuthor() != null) {
                    UserItemData userItemData = new UserItemData();
                    userItemData.user_name = threadData.getAuthor().getUserName();
                    userItemData.name_show = threadData.getAuthor().getName_show();
                    userItemData.portrait = threadData.getAuthor().getPortrait();
                    userItemData.user_id = threadData.getAuthor().getUserId();
                    userItemData.is_follow = threadData.getAuthor().hadConcerned() ? "1" : "0";
                    if (threadData.getAuthor().getBaijiahaoInfo() != null) {
                        userItemData.bjhAvatar = threadData.getAuthor().getBaijiahaoInfo().avatar;
                    }
                    if (threadData.getAuthor().getCreatorInfo() != null) {
                        userItemData.auth = threadData.getAuthor().getCreatorInfo().authDesc;
                    }
                    this.author_info = userItemData;
                }
                this.act_info = threadData.getActivityData();
                reGenerateTitle();
                this.mRecomAbTag = threadData.mRecomAbTag;
                this.mRecomSource = threadData.mRecomSource;
                this.mRecomWeight = threadData.mRecomWeight;
                this.mRecomExtra = threadData.mRecomExtra;
                this.isBjhVideo = threadData.isUgcThreadType();
                this.forbidComment = threadData.forbidComment;
                this.noCommetStr = threadData.noCommetStr;
                this.mWorksInfoData = threadData.worksInfoData;
                this.feedBackReasonMap = threadData.getFeedBackReasonMap();
                this.feedBackExtraMap = threadData.feedBackExtraMap;
                if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null && threadData.getAuthor().getAlaInfo().isLegalYYLiveData()) {
                    this.mAlaInfoData = threadData.getAuthor().getAlaInfo();
                }
            }
            return this;
        }
        return (VideoItemData) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VideoItemData.class != obj.getClass()) {
                return false;
            }
            VideoItemData videoItemData = (VideoItemData) obj;
            return Objects.equals(this.thread_id, videoItemData.thread_id) && Objects.equals(this.video_url, videoItemData.video_url) && compareString(this.title, videoItemData.title);
        }
        return invokeL.booleanValue;
    }

    public int getChannelMidRequestNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.channel_mid_request_num : invokeV.intValue;
    }

    public int getChannelMidRequestVideoNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.channel_mid_request_video_num : invokeV.intValue;
    }

    public cq4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SparseArray<String> sparseArray = this.feedBackReasonMap;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            cq4 cq4Var = new cq4();
            cq4Var.n(this.nid);
            cq4Var.o(this.thread_id);
            cq4Var.l(this.forum_id);
            cq4Var.j(this.feedBackReasonMap);
            cq4Var.g = this.feedBackExtraMap;
            cq4Var.p = this.mRecomAbTag;
            cq4Var.k = this.mRecomWeight;
            cq4Var.m = this.mRecomExtra;
            cq4Var.l = this.mRecomSource;
            return cq4Var;
        }
        return (cq4) invokeV.objValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.thread_id : (String) invokeV.objValue;
    }

    @NonNull
    public SpannableStringBuilder getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.titleSsb == null) {
                reGenerateTitle();
            }
            return this.titleSsb;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public int getVideoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BaijiahaoData baijiahaoData = this.baijiahaoData;
            if (baijiahaoData == null) {
                return 1;
            }
            int i = baijiahaoData.oriUgcType;
            if (i == 2) {
                return 3;
            }
            return i == 4 ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public long getVideoWatchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mVideoWatchDuration : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Objects.hash(this.thread_id, this.video_url, this.title, this.abstext) : invokeV.intValue;
    }

    public boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.author_info == null) {
                return false;
            }
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.author_info.user_id);
        }
        return invokeV.booleanValue;
    }

    public boolean isWorksInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            WorksInfoData worksInfoData = this.mWorksInfoData;
            return worksInfoData != null && worksInfoData.isWorks;
        }
        return invokeV.booleanValue;
    }

    public void parseFeedJson(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.thread_id = jSONObject.optString("id");
            this.nid = jSONObject.optString("nid");
            this.post_id = jSONObject.optString("first_post_id");
            JSONObject optJSONObject = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
            if (optJSONObject != null) {
                this.thumbnail_url = optJSONObject.optString("thumbnail_url");
                this.video_url = optJSONObject.optString("video_url");
                this.video_height = optJSONObject.optString("video_height");
                this.video_width = optJSONObject.optString("video_width");
                this.video_duration = optJSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.mMd5 = optJSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5);
                this.isVerticalVideo = optJSONObject.optInt(TiebaStatic.Params.IS_VERTICAL);
                this.play_count = optJSONObject.getInt("play_count");
            }
            this.comment_num = jSONObject.optString("reply_num");
            this.agree_num = jSONObject.optString("agree_num");
            this.share_num = jSONObject.optString("share_num");
            this.title = jSONObject.optString("title");
            JSONArray optJSONArray = jSONObject.optJSONArray("rich_abstract");
            if (optJSONArray != null) {
                this.mRichAbstractList = hq4.a(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rich_title");
            if (optJSONArray2 != null) {
                this.richTitle = DataExt.toEntityList(optJSONArray2.toString(), PbContent.class);
            }
            StringBuilder sb = new StringBuilder();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("abstract");
            if (optJSONArray3 != null) {
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray3.getJSONObject(i);
                    if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                        sb.append(optJSONArray3.getJSONObject(i).optString("text"));
                    }
                }
            }
            this.abstext = sb.toString();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum_info");
            if (optJSONObject2 != null) {
                this.forum_id = optJSONObject2.optString("id");
                this.forum_name = optJSONObject2.optString("name");
            }
            if (TextUtils.isEmpty(this.forum_id)) {
                this.forum_id = jSONObject.optString("fid");
            }
            if (TextUtils.isEmpty(this.forum_name)) {
                this.forum_name = jSONObject.optString("fname");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("agree");
            if (optJSONObject3 != null) {
                this.is_agreed = optJSONObject3.optString("has_agree");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
            boolean z = true;
            if (optJSONObject4 != null) {
                UserItemData userItemData = new UserItemData();
                userItemData.user_name = optJSONObject4.optString("name");
                userItemData.name_show = optJSONObject4.optString("name_show");
                userItemData.portrait = optJSONObject4.optString("portrait");
                userItemData.user_id = optJSONObject4.optString("id");
                userItemData.is_follow = optJSONObject4.optString("has_concerned");
                JSONObject optJSONObject5 = optJSONObject4.optJSONObject("baijiahao_info");
                if (optJSONObject5 != null) {
                    userItemData.bjhAvatar = optJSONObject5.optString("avatar");
                }
                JSONObject optJSONObject6 = optJSONObject4.optJSONObject("work_creator_info");
                if (optJSONObject6 != null) {
                    userItemData.auth = optJSONObject6.optString("auth_desc");
                }
                this.author_info = userItemData;
                AlaInfoData alaInfoData = new AlaInfoData();
                alaInfoData.parserJson(optJSONObject4.optJSONObject("ala_live_info"));
                if (alaInfoData.live_status == 1 && alaInfoData.isLegalYYLiveData()) {
                    this.mAlaInfoData = alaInfoData;
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject7 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.baijiahaoData = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject7);
            }
            if (this.baijiahaoData == null || !UtilHelper.isUgcThreadType(this.baijiahaoData.oriUgcType)) {
                z = false;
            }
            this.isBjhVideo = z;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("works_info");
            if (optJSONObject8 != null) {
                WorksInfoData worksInfoData = new WorksInfoData();
                this.mWorksInfoData = worksInfoData;
                worksInfoData.parseJson(optJSONObject8);
            }
            this.mExtra = jSONObject.optString("extra");
            if (!StringUtils.isNull(str2)) {
                JSONObject jSONObject3 = new JSONObject(str2);
                this.mRecomAbTag = jSONObject3.optString("abtest_tag");
                this.mRecomSource = jSONObject3.optString("source");
                this.mRecomWeight = jSONObject3.optString("weight");
                this.mRecomExtra = jSONObject3.optString("extra");
                JSONArray optJSONArray4 = jSONObject3.optJSONArray("dislike_resource");
                if (optJSONArray4 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (int i2 = 0; i2 < optJSONArray4.length(); i2++) {
                        JSONObject jSONObject4 = optJSONArray4.getJSONObject(i2);
                        if (jSONObject4 != null) {
                            int optInt = jSONObject4.optInt("dislike_id");
                            String optString = jSONObject4.optString("dislike_reason");
                            String optString2 = jSONObject4.optString("extra");
                            sparseArray.put(optInt, optString + "%" + optString2);
                        }
                    }
                    this.feedBackReasonMap = sparseArray;
                }
            }
            ThreadData threadData = new ThreadData();
            this.threadData = threadData;
            threadData.parserJson(jSONObject);
            if (this.feedBackReasonMap == null) {
                this.feedBackReasonMap = this.threadData.feedBackReasonMap;
                this.feedBackExtraMap = this.threadData.feedBackExtraMap;
                this.mRecomAbTag = this.threadData.mRecomAbTag;
                this.mRecomSource = this.threadData.mRecomSource;
                this.mRecomWeight = this.threadData.mRecomWeight;
                this.mRecomExtra = this.threadData.mRecomExtra;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseJson(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.thread_id = jSONObject.optString("thread_id");
            this.nid = jSONObject.optString("nid");
            this.post_id = jSONObject.optString("first_post_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject != null) {
                this.thumbnail_url = optJSONObject.optString("thumbnail_url");
                this.video_url = optJSONObject.optString("video_url");
                this.video_height = optJSONObject.optString("video_height");
                this.video_width = optJSONObject.optString("video_width");
                this.video_duration = optJSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.mMd5 = optJSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5);
            }
            this.comment_num = jSONObject.optString("post_num");
            this.agree_num = jSONObject.optString("agree_num");
            this.share_num = jSONObject.optString("share_num");
            this.title = jSONObject.optString("title");
            JSONArray optJSONArray = jSONObject.optJSONArray("rich_title");
            if (optJSONArray != null) {
                this.richTitle = DataExt.toEntityList(optJSONArray.toString(), PbContent.class);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rich_abstract");
            if (optJSONArray2 != null) {
                this.mRichAbstractList = hq4.a(optJSONArray2);
            }
            StringBuilder sb = new StringBuilder();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("abstract");
            if (optJSONArray3 != null) {
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray3.getJSONObject(i);
                    if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                        sb.append(optJSONArray3.getJSONObject(i).optString("text"));
                    }
                }
            }
            this.abstext = sb.toString();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum_info");
            if (optJSONObject2 != null) {
                this.forum_id = optJSONObject2.optString("id");
                this.forum_name = optJSONObject2.optString("name");
            }
            this.is_agreed = jSONObject.optString("has_agree");
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (optJSONObject3 != null) {
                UserItemData userItemData = new UserItemData();
                userItemData.user_name = optJSONObject3.optString("user_name");
                userItemData.name_show = optJSONObject3.optString("user_nickname");
                userItemData.portrait = optJSONObject3.optString("portrait");
                userItemData.user_id = optJSONObject3.optString("user_id");
                userItemData.is_follow = optJSONObject3.optString(AddFriendActivityConfig.TYPE_FOCUS);
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("baijiahao_info");
                if (optJSONObject4 != null) {
                    userItemData.bjhAvatar = optJSONObject4.optString("avatar");
                }
                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("work_creator_info");
                if (optJSONObject5 != null) {
                    userItemData.auth = optJSONObject5.optString("auth_desc");
                }
                this.author_info = userItemData;
                AlaInfoData alaInfoData = new AlaInfoData();
                alaInfoData.parserJson(optJSONObject3.optJSONObject("ala_live_info"));
                if (alaInfoData.live_status == 1 && alaInfoData.isLegalYYLiveData()) {
                    this.mAlaInfoData = alaInfoData;
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject6 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.baijiahaoData = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject6);
            }
            this.isBjhVideo = this.baijiahaoData != null && UtilHelper.isUgcThreadType(this.baijiahaoData.oriUgcType);
            this.mRecomAbTag = jSONObject.optString("abtest_tag");
            this.mRecomSource = jSONObject.optString("source");
            this.mRecomWeight = jSONObject.optString("weight");
            this.mRecomExtra = jSONObject.optString("extra");
            this.mExtra = jSONObject.optString("extra");
            this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
            this.noCommetStr = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject7 = jSONObject.optJSONObject("works_info");
            if (optJSONObject7 != null) {
                WorksInfoData worksInfoData = new WorksInfoData();
                this.mWorksInfoData = worksInfoData;
                worksInfoData.parseJson(optJSONObject7);
            }
            ThreadData threadData = new ThreadData();
            this.threadData = threadData;
            threadData.parserJson(jSONObject);
            this.threadData.tid = this.thread_id;
            this.threadData.threadType = 40;
            this.threadData.setReply_num(og.e(this.comment_num, 0));
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_width = Integer.valueOf(this.video_width);
            builder.video_height = Integer.valueOf(this.video_height);
            builder.video_url = this.video_url;
            builder.thumbnail_url = this.thumbnail_url;
            builder.video_md5 = this.mMd5;
            this.threadData.setVideoInfo(builder.build(true));
            if (this.feedBackReasonMap == null) {
                this.feedBackReasonMap = this.threadData.feedBackReasonMap;
                this.feedBackExtraMap = this.threadData.feedBackExtraMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseProto(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) || threadData == null) {
            return;
        }
        this.thread_id = threadData.getTid();
        this.nid = threadData.getNid();
        this.post_id = threadData.getFirstPostId();
        VideoInfo threadVideoInfo = threadData.getThreadVideoInfo();
        if (threadVideoInfo != null) {
            this.thumbnail_url = threadVideoInfo.thumbnail_url;
            this.video_url = threadVideoInfo.video_url;
            this.video_height = String.valueOf(threadVideoInfo.video_height);
            this.video_width = String.valueOf(threadVideoInfo.video_width);
            this.mMd5 = threadVideoInfo.video_md5;
            this.isVerticalVideo = threadVideoInfo.is_vertical.intValue();
            this.video_duration = threadVideoInfo.video_duration.intValue();
        }
        if (threadData.getPost_num() == 0) {
            this.comment_num = String.valueOf(threadData.getReply_num());
        } else {
            this.comment_num = String.valueOf(threadData.getPost_num());
        }
        this.agree_num = String.valueOf(threadData.getAgreeNum());
        this.share_num = String.valueOf(threadData.getShareNum());
        this.title = threadData.getTitle();
        this.richTitle = threadData.getRichTitle();
        this.abstext = threadData.getAbstract();
        this.forum_id = String.valueOf(threadData.getFid());
        this.forum_name = threadData.getForum_name();
        this.is_agreed = String.valueOf(threadData.getHasAgree());
        MetaData author = threadData.getAuthor();
        if (author != null) {
            UserItemData userItemData = new UserItemData();
            userItemData.user_name = author.getUserName();
            userItemData.name_show = author.getName_show();
            userItemData.portrait = author.getPortrait();
            userItemData.user_id = author.getUserId();
            userItemData.is_follow = author.getIsLike() ? "1" : "0";
            BaijiahaoInfo baijiahaoInfo = author.getBaijiahaoInfo();
            if (baijiahaoInfo != null) {
                userItemData.bjhAvatar = baijiahaoInfo.avatar;
            }
            if (author.getCreatorInfo() != null) {
                userItemData.auth = author.getCreatorInfo().authDesc;
            }
            this.author_info = userItemData;
        }
        BaijiahaoData baijiahaoData = threadData.getBaijiahaoData();
        this.baijiahaoData = baijiahaoData;
        this.isBjhVideo = baijiahaoData != null && UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
        this.mRecomAbTag = threadData.mRecomAbTag;
        this.mRecomSource = threadData.mRecomSource;
        this.mRecomWeight = threadData.mRecomWeight;
        this.mRecomExtra = threadData.mRecomExtra;
        this.forbidComment = threadData.forbidComment;
        this.noCommetStr = threadData.getRawThreadInfo().if_comment_info;
        this.mWorksInfoData = threadData.worksInfoData;
        this.feedBackReasonMap = threadData.getFeedBackReasonMap();
        this.feedBackExtraMap = threadData.feedBackExtraMap;
    }

    public void reGenerateTitle() {
        List<PbContent> list;
        CharSequence n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.titleSsb = new SpannableStringBuilder();
            if (this.threadData != null && (list = this.richTitle) != null && !list.isEmpty()) {
                for (PbContent pbContent : this.richTitle) {
                    if (pbContent.type.intValue() == 18) {
                        z65 f = z65.f(this.threadData, pbContent);
                        f.d(R.color.CAM_X0101);
                        f.e(R.color.CAM_X0113);
                        f.b(HotTopicStat.Locate.VIDEO_MIDDLE);
                        n = fi5.o(f);
                    } else {
                        n = fi5.n(this.threadData, pbContent);
                    }
                    this.titleSsb.append(n);
                }
            } else if (!TextUtils.isEmpty(this.title)) {
                this.titleSsb.append((CharSequence) this.title);
            } else if (!TextUtils.isEmpty(this.abstext)) {
                this.titleSsb.append((CharSequence) this.abstext);
            }
        }
    }

    public void setChannelMidRequestNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.channel_mid_request_num = i;
        }
    }

    public void setChannelMidRequestVideoNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.channel_mid_request_video_num = i;
        }
    }

    public void setVideoWatchDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.mVideoWatchDuration = j;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, parcel, i) == null) {
            parcel.writeString(this.forum_id);
            parcel.writeString(this.forum_name);
            parcel.writeString(this.mark_id);
            parcel.writeString(this.thread_id);
            parcel.writeString(this.highLightPostId);
            parcel.writeInt(this.is_manager);
            parcel.writeInt(this.is_origin_manager);
            parcel.writeString(this.nid);
            parcel.writeString(this.post_id);
            parcel.writeString(this.video_log_id);
            parcel.writeString(this.video_url);
            parcel.writeString(this.video_width);
            parcel.writeString(this.video_height);
            parcel.writeString(this.video_length);
            parcel.writeInt(this.video_duration);
            parcel.writeString(this.thumbnail_url);
            parcel.writeString(this.thumbnail_width);
            parcel.writeString(this.thumbnail_height);
            parcel.writeString(this.tags);
            parcel.writeString(this.title);
            parcel.writeString(this.abstext);
            parcel.writeString(this.is_deleted);
            parcel.writeString(this.is_private);
            parcel.writeString(this.is_agreed);
            parcel.writeString(this.agree_num);
            parcel.writeString(this.share_num);
            parcel.writeString(this.comment_num);
            parcel.writeInt(this.play_count);
            parcel.writeParcelable(this.author_info, i);
            parcel.writeParcelable(this.mAlaInfoData, i);
            parcel.writeParcelable(this.act_info, i);
            parcel.writeLong(this.mVideoWatchDuration);
            parcel.writeInt(this.isVerticalVideo);
            parcel.writeSerializable(this.baijiahaoData);
            parcel.writeByte(this.isBjhVideo ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.forbidComment ? (byte) 1 : (byte) 0);
            parcel.writeString(this.noCommetStr);
            parcel.writeInt(this.discoverType);
            parcel.writeByte(this.isTitleExpanded ? (byte) 1 : (byte) 0);
            parcel.writeString(this.mRecomSource);
            parcel.writeString(this.mRecomAbTag);
            parcel.writeString(this.mRecomWeight);
            parcel.writeString(this.mMd5);
            parcel.writeString(this.mRecomExtra);
            parcel.writeParcelable(this.mWorksInfoData, i);
            parcel.writeSparseArray(this.feedBackReasonMap);
            parcel.writeSparseArray(this.feedBackExtraMap);
        }
    }

    public VideoItemData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.isBjhVideo = false;
        this.forbidComment = false;
        this.discoverType = 0;
        this.isTitleExpanded = false;
        this.feedBackReasonMap = null;
        this.feedBackExtraMap = null;
        this.forum_id = parcel.readString();
        this.forum_name = parcel.readString();
        this.mark_id = parcel.readString();
        this.thread_id = parcel.readString();
        this.highLightPostId = parcel.readString();
        this.is_manager = parcel.readInt();
        this.is_origin_manager = parcel.readInt();
        this.nid = parcel.readString();
        this.post_id = parcel.readString();
        this.video_log_id = parcel.readString();
        this.video_url = parcel.readString();
        this.video_width = parcel.readString();
        this.video_height = parcel.readString();
        this.video_length = parcel.readString();
        this.video_duration = parcel.readInt();
        this.thumbnail_url = parcel.readString();
        this.thumbnail_width = parcel.readString();
        this.thumbnail_height = parcel.readString();
        this.tags = parcel.readString();
        this.title = parcel.readString();
        this.abstext = parcel.readString();
        this.is_deleted = parcel.readString();
        this.is_private = parcel.readString();
        this.is_agreed = parcel.readString();
        this.agree_num = parcel.readString();
        this.share_num = parcel.readString();
        this.comment_num = parcel.readString();
        this.play_count = parcel.readInt();
        this.author_info = (UserItemData) parcel.readParcelable(UserItemData.class.getClassLoader());
        this.mAlaInfoData = (AlaInfoData) parcel.readParcelable(AlaInfoData.class.getClassLoader());
        this.act_info = (ActivityItemData) parcel.readParcelable(ActivityItemData.class.getClassLoader());
        this.mVideoWatchDuration = parcel.readLong();
        this.isVerticalVideo = parcel.readInt();
        this.baijiahaoData = (BaijiahaoData) parcel.readSerializable();
        this.isBjhVideo = parcel.readByte() != 0;
        this.forbidComment = parcel.readByte() != 0;
        this.noCommetStr = parcel.readString();
        this.discoverType = parcel.readInt();
        this.isTitleExpanded = parcel.readByte() != 0;
        this.mRecomSource = parcel.readString();
        this.mRecomAbTag = parcel.readString();
        this.mRecomWeight = parcel.readString();
        this.mMd5 = parcel.readString();
        this.mRecomExtra = parcel.readString();
        this.mWorksInfoData = (WorksInfoData) parcel.readParcelable(WorksInfoData.class.getClassLoader());
        this.feedBackReasonMap = parcel.readSparseArray(SparseArray.class.getClassLoader());
        this.feedBackExtraMap = parcel.readSparseArray(SparseArray.class.getClassLoader());
    }
}
