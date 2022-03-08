package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.a.f;
import c.a.q0.i0.d.a;
import c.a.q0.r.r.b1;
import c.a.q0.r.r.e2;
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
/* loaded from: classes6.dex */
public class VideoHotTopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public VideoHotTopicParams f47541e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f47542f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.i0.d.a f47543g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public List<Map<String, Object>> f47544h;

    /* renamed from: i  reason: collision with root package name */
    public int f47545i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f47546j;

    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC0846a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoHotTopicParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicModel f47547b;

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
            this.f47547b = videoHotTopicModel;
            this.a = videoHotTopicParams;
        }

        @Override // c.a.q0.i0.d.a.InterfaceC0846a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47547b.f47546j = false;
            }
        }

        @Override // c.a.q0.i0.d.a.InterfaceC0846a
        public void b(@NonNull List<e2> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.f47547b.f47542f == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (e2 e2Var : list) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData(e2Var);
                arrayList.add(videoItemData);
            }
            if (map != null) {
                this.f47547b.f47544h.add(map);
            }
            this.a.setCurrentPn(this.f47547b.f47545i);
            this.f47547b.f47542f.a(arrayList);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47543g = (c.a.q0.i0.d.a) ServiceManager.getService(c.a.q0.i0.d.a.a);
        this.f47544h = new ArrayList();
        this.f47546j = false;
        this.f47541e = videoHotTopicParams;
        this.f47543g.a(tbPageContext, videoHotTopicParams.getTopicId(), videoHotTopicParams.getTopicName());
        this.f47543g.c(new a(this, videoHotTopicParams));
    }

    @NonNull
    public List<Map<String, Object>> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47544h : (List) invokeV.objValue;
    }

    public void B(@NonNull Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) || this.f47546j) {
            return;
        }
        this.f47546j = true;
        this.f47545i = this.f47541e.getCurrentPn() + 1;
        b1 b1Var = new b1();
        b1Var.k(this.f47545i);
        this.f47543g.b(this.f47541e.getSortType(), b1Var, l.longValue());
    }

    public void C(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f47542f = bVar;
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
