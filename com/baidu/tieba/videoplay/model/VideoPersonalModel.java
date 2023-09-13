package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.go5;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class VideoPersonalModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public VideoRecommentPlayActivityConfig.PersonalPageParams a;
    @Nullable
    public b b;
    @NonNull
    public wp5 c;
    @NonNull
    public xp5 d;
    @Nullable
    public UserItemData e;
    @NonNull
    public List<Map<String, Object>> f;
    public int g;
    public boolean h;

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull List<VideoItemData> list);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements xp5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoRecommentPlayActivityConfig.PersonalPageParams a;
        public final /* synthetic */ VideoPersonalModel b;

        public a(VideoPersonalModel videoPersonalModel, VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPersonalModel, personalPageParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoPersonalModel;
            this.a = personalPageParams;
        }

        @Override // com.baidu.tieba.xp5.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.h = false;
        }

        @Override // com.baidu.tieba.xp5.a
        public void b(@NonNull List<ThreadData> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) && this.b.b != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (ThreadData threadData : list) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData(threadData);
                    if (this.b.e != null) {
                        videoItemData.author_info = this.b.e;
                    }
                    arrayList.add(videoItemData);
                }
                if (map != null) {
                    this.b.f.add(map);
                }
                this.a.setCurrentPn(this.b.g);
                this.b.b.a(arrayList);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPersonalModel(@NonNull TbPageContext tbPageContext, @NonNull VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, personalPageParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = (wp5) go5.c(wp5.b);
        this.f = new ArrayList();
        this.h = false;
        this.a = personalPageParams;
        xp5 a2 = this.c.a(tbPageContext);
        this.d = a2;
        a2.a(new a(this, personalPageParams));
    }

    public void S(@NonNull Long l, @NonNull UserItemData userItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, userItemData) != null) || this.h) {
            return;
        }
        this.e = userItemData;
        this.g = this.a.getCurrentPn() + 1;
        this.h = true;
        this.d.b(this.a.getPersonalPageUid(), null, Integer.valueOf(this.a.getWorkTabId()), 40, 0, Integer.valueOf(!this.a.isVideoTab()), l, Integer.valueOf(this.g));
    }

    public void T(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.b = bVar;
        }
    }

    @NonNull
    public List<Map<String, Object>> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d.a(null);
        }
    }
}
