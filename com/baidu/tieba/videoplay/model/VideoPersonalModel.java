package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.a.f;
import c.a.q0.i0.f.b;
import c.a.q0.r.r.e2;
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
/* loaded from: classes6.dex */
public class VideoPersonalModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public VideoRecommentPlayActivityConfig.PersonalPageParams f47548e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f47549f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.i0.f.a f47550g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.i0.f.b f47551h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public UserItemData f47552i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public List<Map<String, Object>> f47553j;
    public int k;
    public boolean l;

    /* loaded from: classes6.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoRecommentPlayActivityConfig.PersonalPageParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPersonalModel f47554b;

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
            this.f47554b = videoPersonalModel;
            this.a = personalPageParams;
        }

        @Override // c.a.q0.i0.f.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47554b.l = false;
            }
        }

        @Override // c.a.q0.i0.f.b.a
        public void b(@NonNull List<e2> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.f47554b.f47549f == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (e2 e2Var : list) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData(e2Var);
                if (this.f47554b.f47552i != null) {
                    videoItemData.author_info = this.f47554b.f47552i;
                }
                arrayList.add(videoItemData);
            }
            if (map != null) {
                this.f47554b.f47553j.add(map);
            }
            this.a.setCurrentPn(this.f47554b.k);
            this.f47554b.f47549f.a(arrayList);
        }
    }

    /* loaded from: classes6.dex */
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
        this.f47550g = (c.a.q0.i0.f.a) c.a.q0.i0.b.c(c.a.q0.i0.f.a.f12637b);
        this.f47553j = new ArrayList();
        this.l = false;
        this.f47548e = personalPageParams;
        c.a.q0.i0.f.b a2 = this.f47550g.a(tbPageContext);
        this.f47551h = a2;
        a2.a(new a(this, personalPageParams));
    }

    @NonNull
    public List<Map<String, Object>> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47553j : (List) invokeV.objValue;
    }

    public void C(@NonNull Long l, @NonNull UserItemData userItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, userItemData) == null) || this.l) {
            return;
        }
        this.f47552i = userItemData;
        this.k = this.f47548e.getCurrentPn() + 1;
        this.l = true;
        this.f47551h.b(this.f47548e.getPersonalPageUid(), null, Integer.valueOf(this.f47548e.getWorkTabId()), 40, 0, Integer.valueOf(!this.f47548e.isVideoTab()), l, Integer.valueOf(this.k));
    }

    public void D(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f47549f = bVar;
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
            this.f47551h.a(null);
        }
    }
}
