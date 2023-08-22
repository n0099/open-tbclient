package com.baidu.tieba.videoplay.dispatcher;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.y5a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/tieba/videoplay/dispatcher/VideoListPlayDispatcher;", "Lcom/baidu/tieba/schema/SchemaDispatcher;", "()V", "dispatch", "", "jsonObject", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "Companion", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoListPlayDispatcher implements y5a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String TAG = "VideoImmersivePlayDispatcher";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1173970241, "Lcom/baidu/tieba/videoplay/dispatcher/VideoListPlayDispatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1173970241, "Lcom/baidu/tieba/videoplay/dispatcher/VideoListPlayDispatcher;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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
    }

    public VideoListPlayDispatcher() {
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

    @Override // com.baidu.tieba.y5a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) {
            if (jSONObject != null && context != null) {
                String videoData = jSONObject.optString("videoData");
                if (TextUtils.isEmpty(videoData)) {
                    DefaultLog.getInstance().e(TAG, "dispatch videoData is empty");
                    return;
                }
                VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = null;
                try {
                    Intrinsics.checkNotNullExpressionValue(videoData, "videoData");
                    personalPageParams = (VideoRecommentPlayActivityConfig.PersonalPageParams) DataExt.toEntity(videoData, VideoRecommentPlayActivityConfig.PersonalPageParams.class);
                } catch (Exception e) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e(TAG, "dispatch videoData entity parse failed. ex=" + e.getMessage());
                }
                if (personalPageParams != null && !ListUtils.isEmpty(personalPageParams.getDataList())) {
                    ArrayList arrayList = new ArrayList();
                    int size = personalPageParams.getDataList().size();
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        VideoItemData videoItemData = new VideoItemData();
                        videoItemData.buildWithFlutterMap(personalPageParams.getDataList().get(i2));
                        arrayList.add(videoItemData);
                        if (TextUtils.equals(personalPageParams.getThreadId(), videoItemData.getThreadId())) {
                            i = i2;
                        }
                    }
                    VideoPlayActivityConfig.bigDataList = arrayList;
                    VideoRecommentPlayActivityConfig.bigPersonalPageParams = personalPageParams;
                    new VideoRecommentPlayActivityConfig(context, i, VideoRecommentPlayActivityConfig.FROM_PERSONAL_PAGE, personalPageParams.getThreadId(), personalPageParams.isShowComment()).start();
                    return;
                }
                DefaultLog.getInstance().e(TAG, "dispatch datalist is empty");
                return;
            }
            DefaultLog.getInstance().e(TAG, "dispatch json is null or context is null");
        }
    }
}
