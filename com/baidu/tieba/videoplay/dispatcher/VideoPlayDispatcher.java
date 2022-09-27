package com.baidu.tieba.videoplay.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dh;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.tieba.zf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoPlayDispatcher implements zf8 {
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

    @Override // com.baidu.tieba.zf8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) || jSONObject == null || context == null) {
            return;
        }
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
        videoItemData.video_duration = dh.e(jSONObject.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
        boolean z = dh.g(jSONObject.optString("videoHeight"), 0L) > dh.g(jSONObject.optString("videoWidth"), 0L);
        Intent intent = new Intent();
        intent.putExtra("is_vertail", z);
        videoItemData.comment_num = jSONObject.optString("postNum");
        videoItemData.agree_num = jSONObject.optString("agreeNum");
        videoItemData.share_num = jSONObject.optString("shareNum");
        videoItemData.forum_id = jSONObject.optString(TbTitleActivityConfig.FORUM_ID);
        videoItemData.forum_name = jSONObject.optString("forumName");
        arrayList.add(videoItemData);
        intent.putExtra("video_list", arrayList);
        intent.setClass(context, VideoPlayActivity.class);
        context.startActivity(intent);
    }
}
