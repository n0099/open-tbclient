package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Hottopic.TopicInfo;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class j58 implements vn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public long i;
    public l58 j;
    public boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947834396, "Lcom/baidu/tieba/j58;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947834396, "Lcom/baidu/tieba/j58;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public j58() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.vn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return l;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void a(TopicInfo topicInfo) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, topicInfo) != null) || topicInfo == null) {
            return;
        }
        this.a = String.valueOf(topicInfo.topic_id);
        this.b = topicInfo.topic_name;
        this.c = topicInfo.desc;
        this.d = topicInfo.total_post_num.longValue();
        this.e = topicInfo.head_photo_url;
        this.f = topicInfo.head_background_url;
        if (StringUtils.isNull(topicInfo.share_title)) {
            str = "";
        } else {
            str = topicInfo.share_title;
        }
        this.g = str;
        this.h = topicInfo.share_pic;
        this.i = topicInfo.idx_num.longValue();
        Long l2 = topicInfo.pmy_topic_id;
        String str2 = topicInfo.head_photo_jump_url;
        Integer num = topicInfo.pmy_source;
        if (topicInfo.is_deleted.longValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.k = z;
        VideoInfo videoInfo = topicInfo.video_info;
        if (videoInfo != null && !StringUtils.isNull(videoInfo.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
            VideoInfo videoInfo2 = topicInfo.video_info;
            String str3 = videoInfo2.video_md5;
            String str4 = videoInfo2.video_url;
            videoInfo2.video_duration.intValue();
            topicInfo.video_info.video_width.intValue();
            topicInfo.video_info.video_height.intValue();
            VideoInfo videoInfo3 = topicInfo.video_info;
            String str5 = videoInfo3.thumbnail_url;
            videoInfo3.thumbnail_width.intValue();
            topicInfo.video_info.thumbnail_height.intValue();
            topicInfo.video_info.video_length.intValue();
            topicInfo.video_info.play_count.intValue();
        }
        String str6 = topicInfo.tag_list_type;
        if (topicInfo.join_info != null) {
            l58 l58Var = new l58();
            this.j = l58Var;
            l58Var.a(topicInfo.join_info);
        }
    }
}
