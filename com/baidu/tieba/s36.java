package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.jp5;
import com.baidu.tieba.newdetail.HotTopicDetailModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class s36 implements cl1<jp5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class b implements jp5, HotTopicDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HotTopicDetailModel b;
        @Nullable
        public jp5.a c;

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

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.baidu.tieba.jp5
        public void c(@Nullable jp5.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.c = aVar;
            }
        }

        @Override // com.baidu.tieba.jp5
        public jp5 a(@NonNull TbPageContext tbPageContext, long j, @NonNull String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), str})) == null) {
                HotTopicDetailModel hotTopicDetailModel = new HotTopicDetailModel(tbPageContext);
                this.b = hotTopicDetailModel;
                hotTopicDetailModel.b0(j, str);
                this.b.a0(this);
                return this;
            }
            return (jp5) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.jp5
        public void b(int i, e35 e35Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), e35Var, Long.valueOf(j)}) == null) {
                this.b.O(i, e35Var, j);
            }
        }

        @Override // com.baidu.tieba.newdetail.HotTopicDetailModel.d
        public void n(int i, @Nullable jb8 jb8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048579, this, i, jb8Var) == null) && this.c != null) {
                if (jb8Var != null) {
                    ArrayList arrayList = new ArrayList();
                    for (up6 up6Var : jb8Var.a) {
                        if (up6Var instanceof up6) {
                            ThreadData threadData = up6Var.getThreadData();
                            if (!TextUtils.equals(threadData.getTid(), "0")) {
                                arrayList.add(threadData);
                            }
                        }
                    }
                    this.c.b(arrayList, jb8Var.e());
                }
                this.c.a();
            }
        }
    }

    public s36() {
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
    @Override // com.baidu.tieba.cl1
    /* renamed from: a */
    public jp5 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new b(null);
        }
        return (jp5) invokeV.objValue;
    }
}
