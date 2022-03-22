package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.a.f;
import c.a.o0.i0.d.a;
import c.a.o0.r.r.z0;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.module.hottopic.VideoHotTopicParams;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class VideoHotTopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public VideoHotTopicParams a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f36743b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.i0.d.a f36744c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public List<Map<String, Object>> f36745d;

    /* renamed from: e  reason: collision with root package name */
    public int f36746e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36747f;

    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC0813a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoHotTopicParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicModel f36748b;

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
            this.f36748b = videoHotTopicModel;
            this.a = videoHotTopicParams;
        }

        @Override // c.a.o0.i0.d.a.InterfaceC0813a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36748b.f36747f = false;
            }
        }

        @Override // c.a.o0.i0.d.a.InterfaceC0813a
        public void b(@NonNull List<ThreadData> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.f36748b.f36743b == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ThreadData threadData : list) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData(threadData);
                arrayList.add(videoItemData);
            }
            if (map != null) {
                this.f36748b.f36745d.add(map);
            }
            this.a.setCurrentPn(this.f36748b.f36746e);
            this.f36748b.f36743b.a(arrayList);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(@NonNull List<VideoItemData> list);
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
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36744c = (c.a.o0.i0.d.a) ServiceManager.getService(c.a.o0.i0.d.a.a);
        this.f36745d = new ArrayList();
        this.f36747f = false;
        this.a = videoHotTopicParams;
        this.f36744c.a(tbPageContext, videoHotTopicParams.getTopicId(), videoHotTopicParams.getTopicName());
        this.f36744c.c(new a(this, videoHotTopicParams));
    }

    @NonNull
    public List<Map<String, Object>> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36745d : (List) invokeV.objValue;
    }

    public void D(@NonNull Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) || this.f36747f) {
            return;
        }
        this.f36747f = true;
        this.f36746e = this.a.getCurrentPn() + 1;
        z0 z0Var = new z0();
        z0Var.k(this.f36746e);
        this.f36744c.b(this.a.getSortType(), z0Var, l.longValue());
    }

    public void E(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f36743b = bVar;
        }
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
}
