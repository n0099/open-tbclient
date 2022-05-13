package com.baidu.tieba.videoplay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.repackage.aq4;
import com.repackage.b9;
import com.repackage.o55;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class VideoHotTopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public VideoHotTopicParams a;
    @Nullable
    public b b;
    @NonNull
    public o55 c;
    @NonNull
    public List<Map<String, Object>> d;
    public int e;
    public boolean f;

    /* loaded from: classes4.dex */
    public class a implements o55.a {
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

        @Override // com.repackage.o55.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.f = false;
            }
        }

        @Override // com.repackage.o55.a
        public void b(@NonNull List<ThreadData> list, @Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map) == null) || this.b.b == null || list.isEmpty()) {
                return;
            }
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

    /* loaded from: classes4.dex */
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
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = (o55) ServiceManager.getService(o55.a);
        this.d = new ArrayList();
        this.f = false;
        this.a = videoHotTopicParams;
        this.c.a(tbPageContext, videoHotTopicParams.getTopicId(), videoHotTopicParams.getTopicName());
        this.c.c(new a(this, videoHotTopicParams));
    }

    @NonNull
    public List<Map<String, Object>> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public void D(@NonNull Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) || this.f) {
            return;
        }
        this.f = true;
        this.e = this.a.getCurrentPn() + 1;
        aq4 aq4Var = new aq4();
        aq4Var.k(this.e);
        this.c.b(this.a.getSortType(), aq4Var, l.longValue());
    }

    public void E(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.b = bVar;
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
