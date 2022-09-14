package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.k95;
import com.baidu.tieba.newdetail.HotTopicDetailModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class lm5 implements te1<k95> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b implements k95, HotTopicDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HotTopicDetailModel b;
        @Nullable
        public k95.a c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.k95
        public k95 a(@NonNull TbPageContext tbPageContext, long j, @NonNull String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), str})) == null) {
                HotTopicDetailModel hotTopicDetailModel = new HotTopicDetailModel(tbPageContext);
                this.b = hotTopicDetailModel;
                hotTopicDetailModel.O(j, str);
                this.b.N(this);
                return this;
            }
            return (k95) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.k95
        public void b(int i, ms4 ms4Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), ms4Var, Long.valueOf(j)}) == null) {
                this.b.B(i, ms4Var, j);
            }
        }

        @Override // com.baidu.tieba.k95
        public void c(@Nullable k95.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.c = aVar;
            }
        }

        @Override // com.baidu.tieba.newdetail.HotTopicDetailModel.d
        public void q(int i, @Nullable h67 h67Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, h67Var) == null) || this.c == null) {
                return;
            }
            if (h67Var != null) {
                ArrayList arrayList = new ArrayList();
                for (c26 c26Var : h67Var.a) {
                    if (c26Var instanceof c26) {
                        ThreadData threadData = c26Var.getThreadData();
                        if (!TextUtils.equals(threadData.getTid(), "0")) {
                            arrayList.add(threadData);
                        }
                    }
                }
                this.c.b(arrayList, h67Var.h());
            }
            this.c.a();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public lm5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.te1
    /* renamed from: a */
    public k95 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(null) : (k95) invokeV.objValue;
    }
}
