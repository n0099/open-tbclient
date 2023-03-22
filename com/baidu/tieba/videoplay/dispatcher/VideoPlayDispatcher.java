package com.baidu.tieba.videoplay.dispatcher;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.fp5;
import com.baidu.tieba.g39;
import com.baidu.tieba.gg;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoPlayDispatcher implements g39 {
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

    @Override // com.baidu.tieba.g39
    public void dispatch(JSONObject jSONObject, Context context) {
        boolean z;
        boolean z2;
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
            videoItemData.author_info = userItemData;
            videoItemData.thumbnail_url = jSONObject.optString("thumbnailUrl");
            videoItemData.video_url = jSONObject.optString("videoUrl");
            videoItemData.video_width = jSONObject.optString("videoWidth");
            videoItemData.video_height = jSONObject.optString("videoHeight");
            videoItemData.video_duration = gg.e(jSONObject.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
            if (gg.g(jSONObject.optString("videoHeight"), 0L) > gg.g(jSONObject.optString("videoWidth"), 0L)) {
                z = true;
            } else {
                z = false;
            }
            videoItemData.comment_num = jSONObject.optString("postNum");
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
            arrayList.add(videoItemData);
            JSONObject optJSONObject = jSONObject.optJSONObject("rect");
            Rect rect = null;
            if (optJSONObject != null) {
                rect = new Rect();
                rect.left = optJSONObject.optInt("l");
                rect.top = optJSONObject.optInt("t");
                rect.right = optJSONObject.optInt("r");
                rect.bottom = optJSONObject.optInt("b");
            }
            Rect rect2 = rect;
            if (TextUtils.isEmpty(videoItemData.video_url)) {
                new VideoRecommentPlayActivityConfig(context, arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE, z2).start();
            } else {
                fp5.d(context, arrayList, videoItemData.nid, z, 0, rect2, "from_nani_video", "personalize_page", "", VideoPlayActivityConfig.FROM_H5_SEARCH, "", z2, false, gg.g(videoItemData.forum_id, 0L));
            }
        }
    }
}
