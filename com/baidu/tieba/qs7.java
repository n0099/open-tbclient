package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class qs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ls7 a;
    public String b;
    public VideoAggregationModel c;
    public boolean d;
    public VideoAggregationModel.c e;

    /* loaded from: classes8.dex */
    public class a implements VideoAggregationModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs7 a;

        public a(qs7 qs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs7Var;
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.a.a == null) {
                return;
            }
            this.a.a.hideLoadingView();
            this.a.a.s(str);
            this.a.a.d();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<os7> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.a.a == null) {
                return;
            }
            this.a.a.hideLoadingView();
            this.a.d = z2;
            this.a.a.D1(list, z, z2);
        }
    }

    public qs7(TbPageContext tbPageContext, ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ls7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.e = aVar;
        this.a = ls7Var;
        this.c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (videoAggregationModel = this.c) != null) {
            videoAggregationModel.setFrom(str);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
            VideoAggregationModel videoAggregationModel = this.c;
            if (videoAggregationModel != null) {
                videoAggregationModel.T(str);
            }
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (videoAggregationModel = this.c) != null) {
            videoAggregationModel.U(str);
        }
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (videoAggregationModel = this.c) != null) {
            videoAggregationModel.V(str);
        }
    }

    public void c() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (videoAggregationModel = this.c) != null) {
            videoAggregationModel.cancelLoadData();
        }
    }

    public void d() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (videoAggregationModel = this.c) != null && this.d) {
            videoAggregationModel.loadData();
        }
    }

    public void e() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (videoAggregationModel = this.c) != null) {
            videoAggregationModel.S();
        }
    }
}
