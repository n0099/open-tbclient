package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.e.a.f;
import b.a.q0.i0.c.a;
import b.a.q0.s.q.b1;
import b.a.q0.s.q.d2;
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
/* loaded from: classes9.dex */
public class VideoHotTopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public VideoHotTopicParams f55131e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f55132f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.i0.c.a f55133g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public List<Map<String, Object>> f55134h;

    /* renamed from: i  reason: collision with root package name */
    public int f55135i;
    public boolean j;

    /* loaded from: classes9.dex */
    public class a implements a.InterfaceC0665a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicParams f55136a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicModel f55137b;

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
            this.f55137b = videoHotTopicModel;
            this.f55136a = videoHotTopicParams;
        }

        @Override // b.a.q0.i0.c.a.InterfaceC0665a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55137b.j = false;
            }
        }

        @Override // b.a.q0.i0.c.a.InterfaceC0665a
        public void b(@NonNull List<d2> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.f55137b.f55132f == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (d2 d2Var : list) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData(d2Var);
                arrayList.add(videoItemData);
            }
            if (map != null) {
                this.f55137b.f55134h.add(map);
            }
            this.f55136a.setCurrentPn(this.f55137b.f55135i);
            this.f55137b.f55132f.a(arrayList);
        }
    }

    /* loaded from: classes9.dex */
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
        this.f55133g = (b.a.q0.i0.c.a) ServiceManager.getService(b.a.q0.i0.c.a.f12639a);
        this.f55134h = new ArrayList();
        this.j = false;
        this.f55131e = videoHotTopicParams;
        this.f55133g.a(tbPageContext, videoHotTopicParams.getTopicId(), videoHotTopicParams.getTopicName());
        this.f55133g.c(new a(this, videoHotTopicParams));
    }

    @NonNull
    public List<Map<String, Object>> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55134h : (List) invokeV.objValue;
    }

    public void B(@NonNull Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) || this.j) {
            return;
        }
        this.j = true;
        this.f55135i = this.f55131e.getCurrentPn() + 1;
        b1 b1Var = new b1();
        b1Var.k(this.f55135i);
        this.f55133g.b(this.f55131e.getSortType(), b1Var, l.longValue());
    }

    public void C(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f55132f = bVar;
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
