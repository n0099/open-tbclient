package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.e.a.f;
import b.a.q0.i0.e.b;
import b.a.q0.s.q.d2;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tieba.video.UserItemData;
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
public class VideoPersonalModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public VideoRecommentPlayActivityConfig.PersonalPageParams f55138e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f55139f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.i0.e.a f55140g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.i0.e.b f55141h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public UserItemData f55142i;
    @NonNull
    public List<Map<String, Object>> j;
    public int k;
    public boolean l;

    /* loaded from: classes9.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoRecommentPlayActivityConfig.PersonalPageParams f55143a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPersonalModel f55144b;

        public a(VideoPersonalModel videoPersonalModel, VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPersonalModel, personalPageParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55144b = videoPersonalModel;
            this.f55143a = personalPageParams;
        }

        @Override // b.a.q0.i0.e.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55144b.l = false;
            }
        }

        @Override // b.a.q0.i0.e.b.a
        public void b(@NonNull List<d2> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.f55144b.f55139f == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (d2 d2Var : list) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData(d2Var);
                if (this.f55144b.f55142i != null) {
                    videoItemData.author_info = this.f55144b.f55142i;
                }
                arrayList.add(videoItemData);
            }
            if (map != null) {
                this.f55144b.j.add(map);
            }
            this.f55143a.setCurrentPn(this.f55144b.k);
            this.f55144b.f55139f.a(arrayList);
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(@NonNull List<VideoItemData> list);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55140g = (b.a.q0.i0.e.a) b.a.q0.i0.b.c(b.a.q0.i0.e.a.f12650b);
        this.j = new ArrayList();
        this.l = false;
        this.f55138e = personalPageParams;
        b.a.q0.i0.e.b a2 = this.f55140g.a(tbPageContext);
        this.f55141h = a2;
        a2.a(new a(this, personalPageParams));
    }

    @NonNull
    public List<Map<String, Object>> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    public void C(@NonNull Long l, @NonNull UserItemData userItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, userItemData) == null) || this.l) {
            return;
        }
        this.f55142i = userItemData;
        this.k = this.f55138e.getCurrentPn() + 1;
        this.l = true;
        this.f55141h.b(this.f55138e.getPersonalPageUid(), null, Integer.valueOf(this.f55138e.getWorkTabId()), 40, 0, Integer.valueOf(!this.f55138e.isVideoTab()), l, Integer.valueOf(this.k));
    }

    public void D(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f55139f = bVar;
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

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f55141h.a(null);
        }
    }
}
