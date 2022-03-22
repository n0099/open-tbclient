package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.a.f;
import c.a.o0.i0.f.b;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
    public VideoRecommentPlayActivityConfig.PersonalPageParams a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f36749b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.i0.f.a f36750c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.i0.f.b f36751d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public UserItemData f36752e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public List<Map<String, Object>> f36753f;

    /* renamed from: g  reason: collision with root package name */
    public int f36754g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36755h;

    /* loaded from: classes6.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoRecommentPlayActivityConfig.PersonalPageParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPersonalModel f36756b;

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
            this.f36756b = videoPersonalModel;
            this.a = personalPageParams;
        }

        @Override // c.a.o0.i0.f.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36756b.f36755h = false;
            }
        }

        @Override // c.a.o0.i0.f.b.a
        public void b(@NonNull List<ThreadData> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.f36756b.f36749b == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ThreadData threadData : list) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData(threadData);
                if (this.f36756b.f36752e != null) {
                    videoItemData.author_info = this.f36756b.f36752e;
                }
                arrayList.add(videoItemData);
            }
            if (map != null) {
                this.f36756b.f36753f.add(map);
            }
            this.a.setCurrentPn(this.f36756b.f36754g);
            this.f36756b.f36749b.a(arrayList);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36750c = (c.a.o0.i0.f.a) c.a.o0.i0.b.c(c.a.o0.i0.f.a.f10336b);
        this.f36753f = new ArrayList();
        this.f36755h = false;
        this.a = personalPageParams;
        c.a.o0.i0.f.b a2 = this.f36750c.a(tbPageContext);
        this.f36751d = a2;
        a2.a(new a(this, personalPageParams));
    }

    @NonNull
    public List<Map<String, Object>> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36753f : (List) invokeV.objValue;
    }

    public void E(@NonNull Long l, @NonNull UserItemData userItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, userItemData) == null) || this.f36755h) {
            return;
        }
        this.f36752e = userItemData;
        this.f36754g = this.a.getCurrentPn() + 1;
        this.f36755h = true;
        this.f36751d.b(this.a.getPersonalPageUid(), null, Integer.valueOf(this.a.getWorkTabId()), 40, 0, Integer.valueOf(!this.a.isVideoTab()), l, Integer.valueOf(this.f36754g));
    }

    public void F(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f36749b = bVar;
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
            this.f36751d.a(null);
        }
    }
}
