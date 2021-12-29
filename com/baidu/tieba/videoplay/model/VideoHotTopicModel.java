package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.a.f;
import c.a.s0.j0.d.a;
import c.a.s0.s.q.b1;
import c.a.s0.s.q.d2;
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
/* loaded from: classes12.dex */
public class VideoHotTopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public VideoHotTopicParams f50872e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f50873f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.j0.d.a f50874g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public List<Map<String, Object>> f50875h;

    /* renamed from: i  reason: collision with root package name */
    public int f50876i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50877j;

    /* loaded from: classes12.dex */
    public class a implements a.InterfaceC0844a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoHotTopicParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicModel f50878b;

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
            this.f50878b = videoHotTopicModel;
            this.a = videoHotTopicParams;
        }

        @Override // c.a.s0.j0.d.a.InterfaceC0844a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50878b.f50877j = false;
            }
        }

        @Override // c.a.s0.j0.d.a.InterfaceC0844a
        public void b(@NonNull List<d2> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.f50878b.f50873f == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (d2 d2Var : list) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData(d2Var);
                arrayList.add(videoItemData);
            }
            if (map != null) {
                this.f50878b.f50875h.add(map);
            }
            this.a.setCurrentPn(this.f50878b.f50876i);
            this.f50878b.f50873f.a(arrayList);
        }
    }

    /* loaded from: classes12.dex */
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
        this.f50874g = (c.a.s0.j0.d.a) ServiceManager.getService(c.a.s0.j0.d.a.a);
        this.f50875h = new ArrayList();
        this.f50877j = false;
        this.f50872e = videoHotTopicParams;
        this.f50874g.a(tbPageContext, videoHotTopicParams.getTopicId(), videoHotTopicParams.getTopicName());
        this.f50874g.c(new a(this, videoHotTopicParams));
    }

    @NonNull
    public List<Map<String, Object>> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50875h : (List) invokeV.objValue;
    }

    public void B(@NonNull Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) || this.f50877j) {
            return;
        }
        this.f50877j = true;
        this.f50876i = this.f50872e.getCurrentPn() + 1;
        b1 b1Var = new b1();
        b1Var.k(this.f50876i);
        this.f50874g.b(this.f50872e.getSortType(), b1Var, l.longValue());
    }

    public void C(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f50873f = bVar;
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
