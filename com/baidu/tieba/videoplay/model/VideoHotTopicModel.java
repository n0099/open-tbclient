package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.module.hottopic.VideoHotTopicParams;
import com.baidu.tieba.k9;
import com.baidu.tieba.l35;
import com.baidu.tieba.no5;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class VideoHotTopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public VideoHotTopicParams a;
    @Nullable
    public b b;
    @NonNull
    public no5 c;
    @NonNull
    public List<Map<String, Object>> d;
    public int e;
    public boolean f;

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
    public class a implements no5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoHotTopicParams a;
        public final /* synthetic */ VideoHotTopicModel b;

        public a(VideoHotTopicModel videoHotTopicModel, VideoHotTopicParams videoHotTopicParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoHotTopicModel, videoHotTopicParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoHotTopicModel;
            this.a = videoHotTopicParams;
        }

        @Override // com.baidu.tieba.no5.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.f = false;
        }

        @Override // com.baidu.tieba.no5.a
        public void b(@NonNull List<ThreadData> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) && this.b.b != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (ThreadData threadData : list) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData(threadData);
                    arrayList.add(videoItemData);
                }
                if (map != null) {
                    this.b.d.add(map);
                }
                this.a.setCurrentPn(this.b.e);
                this.b.b.a(arrayList);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoHotTopicModel(@NonNull TbPageContext tbPageContext, @NonNull VideoHotTopicParams videoHotTopicParams) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, videoHotTopicParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = (no5) ServiceManager.getService(no5.a);
        this.d = new ArrayList();
        this.f = false;
        this.a = videoHotTopicParams;
        this.c.a(tbPageContext, videoHotTopicParams.getTopicId(), videoHotTopicParams.getTopicName());
        this.c.c(new a(this, videoHotTopicParams));
    }

    public void a0(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.b = bVar;
        }
    }

    @NonNull
    public List<Map<String, Object>> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public void Z(@NonNull Long l) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) != null) || this.f) {
            return;
        }
        this.f = true;
        this.e = this.a.getCurrentPn() + 1;
        l35 l35Var = new l35();
        l35Var.k(this.e);
        this.c.b(this.a.getSortType(), l35Var, l.longValue());
    }
}
