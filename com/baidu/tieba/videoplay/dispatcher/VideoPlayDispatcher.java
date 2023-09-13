package com.baidu.tieba.videoplay.dispatcher;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.tieba.ix5;
import com.baidu.tieba.s7a;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class VideoPlayDispatcher implements s7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VideoPlayDispatcher() {
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0196  */
    @Override // com.baidu.tieba.s7a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatch(JSONObject jSONObject, Context context) {
        boolean z;
        boolean z2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Rect rect;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.thread_id = jSONObject.optString("threadId");
            videoItemData.post_id = jSONObject.optString("postId");
            videoItemData.title = jSONObject.optString("title");
            UserItemData userItemData = new UserItemData();
            userItemData.user_name = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
            userItemData.name_show = jSONObject.optString("nickName");
            userItemData.portrait = jSONObject.optString("portrait");
            userItemData.is_follow = jSONObject.optString("has_concerned");
            videoItemData.author_info = userItemData;
            videoItemData.thumbnail_url = jSONObject.optString("thumbnailUrl");
            videoItemData.video_url = jSONObject.optString("videoUrl");
            videoItemData.video_width = jSONObject.optString("videoWidth");
            videoItemData.video_height = jSONObject.optString("videoHeight");
            boolean z3 = false;
            videoItemData.video_duration = JavaTypesHelper.toInt(jSONObject.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
            if (JavaTypesHelper.toLong(jSONObject.optString("videoHeight"), 0L) > JavaTypesHelper.toLong(jSONObject.optString("videoWidth"), 0L)) {
                z = true;
            } else {
                z = false;
            }
            videoItemData.comment_num = jSONObject.optString("postNum");
            videoItemData.is_agreed = jSONObject.optString("isAgreed");
            videoItemData.agree_num = jSONObject.optString("agreeNum");
            videoItemData.share_num = jSONObject.optString("shareNum");
            videoItemData.forum_id = jSONObject.optString("forumId");
            videoItemData.forum_name = jSONObject.optString("forumName");
            videoItemData.highLightPostId = jSONObject.optString("hightlightAnchorPid");
            boolean equals = "1".equals(jSONObject.optString("showComment"));
            if (!TextUtils.isEmpty(videoItemData.highLightPostId)) {
                z2 = true;
            } else {
                z2 = equals;
            }
            if (jSONObject.optInt("author_is_living") == 1) {
                z3 = true;
            }
            if (z3) {
                try {
                    jSONObject2 = new JSONObject(jSONObject.optString("yy_ext"));
                } catch (Exception e) {
                    e.printStackTrace();
                    jSONObject2 = null;
                }
                if (jSONObject2 != null) {
                    AlaInfoData alaInfoData = new AlaInfoData();
                    alaInfoData.live_status = 1;
                    alaInfoData.roomId = jSONObject2.optLong("room_id");
                    YyExtData yyExtData = new YyExtData();
                    yyExtData.mSid = jSONObject2.optString("sid");
                    yyExtData.mSsid = jSONObject2.optString(YyLiveRoomConfig.KEY_SSID);
                    yyExtData.mTemplateId = jSONObject2.optString("template_id");
                    alaInfoData.mYyExtData = yyExtData;
                    videoItemData.mAlaInfoData = alaInfoData;
                }
            }
            arrayList.add(videoItemData);
            String optString = jSONObject.optString("rect");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject3 = new JSONObject(optString);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    jSONObject3 = null;
                }
                if (jSONObject3 != null) {
                    Rect rect2 = new Rect();
                    rect2.left = jSONObject3.optInt("l");
                    rect2.top = jSONObject3.optInt("t");
                    rect2.right = jSONObject3.optInt("r");
                    rect2.bottom = jSONObject3.optInt("b");
                    rect = rect2;
                    if (!TextUtils.isEmpty(videoItemData.video_url)) {
                        new VideoRecommentPlayActivityConfig(context, arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE, z2).start();
                        return;
                    }
                    String optString2 = jSONObject.optString("page_from");
                    if ("recommend".equals(optString2)) {
                        str = "index";
                    } else if (ImageViewerConfig.FROM_CONCERN.equals(optString2)) {
                        str = "concern_tab";
                    } else {
                        str = VideoPlayActivityConfig.FROM_H5_SEARCH;
                    }
                    ix5.d(context, arrayList, videoItemData.nid, z, 0, rect, "from_nani_video", "personalize_page", "", str, "", z2, false, JavaTypesHelper.toLong(videoItemData.forum_id, 0L));
                    return;
                }
            }
            rect = null;
            if (!TextUtils.isEmpty(videoItemData.video_url)) {
            }
        }
    }
}
