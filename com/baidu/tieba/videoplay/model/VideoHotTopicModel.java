package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.e.a.f;
import c.a.q0.i0.c.a;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes7.dex */
public class VideoHotTopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public VideoHotTopicParams f58115e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f58116f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.i0.c.a f58117g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public List<Map<String, Object>> f58118h;

    /* renamed from: i  reason: collision with root package name */
    public int f58119i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58120j;

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0670a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicParams f58121a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicModel f58122b;

        public a(VideoHotTopicModel videoHotTopicModel, VideoHotTopicParams videoHotTopicParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoHotTopicModel, videoHotTopicParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58122b = videoHotTopicModel;
            this.f58121a = videoHotTopicParams;
        }

        @Override // c.a.q0.i0.c.a.InterfaceC0670a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58122b.f58120j = false;
            }
        }

        @Override // c.a.q0.i0.c.a.InterfaceC0670a
        public void b(@NonNull List<d2> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.f58122b.f58116f == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (d2 d2Var : list) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData(d2Var);
                arrayList.add(videoItemData);
            }
            if (map != null) {
                this.f58122b.f58118h.add(map);
            }
            this.f58121a.setCurrentPn(this.f58122b.f58119i);
            this.f58122b.f58116f.a(arrayList);
        }
    }

    /* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58117g = (c.a.q0.i0.c.a) ServiceManager.getService(c.a.q0.i0.c.a.f13498a);
        this.f58118h = new ArrayList();
        this.f58120j = false;
        this.f58115e = videoHotTopicParams;
        this.f58117g.a(tbPageContext, videoHotTopicParams.getTopicId(), videoHotTopicParams.getTopicName());
        this.f58117g.c(new a(this, videoHotTopicParams));
    }

    @NonNull
    public List<Map<String, Object>> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58118h : (List) invokeV.objValue;
    }

    public void B(@NonNull Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) || this.f58120j) {
            return;
        }
        this.f58120j = true;
        this.f58119i = this.f58115e.getCurrentPn() + 1;
        b1 b1Var = new b1();
        b1Var.k(this.f58119i);
        this.f58117g.b(this.f58115e.getSortType(), b1Var, l.longValue());
    }

    public void C(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f58116f = bVar;
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
