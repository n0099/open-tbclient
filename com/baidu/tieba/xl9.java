package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.v19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements v19.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public a(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // com.baidu.tieba.v19.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new lb5(2, 12, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements v19.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public b(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // com.baidu.tieba.v19.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new lb5(2, 12, null));
            }
        }
    }

    public static wj9 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new wj9(tbPageContext);
        }
        return (wj9) invokeL.objValue;
    }

    public static yj9 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new yj9(tbPageContext);
        }
        return (yj9) invokeL.objValue;
    }

    public static ak9 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new ak9(tbPageContext);
        }
        return (ak9) invokeL.objValue;
    }

    public static bk9 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new bk9(tbPageContext);
        }
        return (bk9) invokeL.objValue;
    }

    public static ck9 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new ck9(tbPageContext);
        }
        return (ck9) invokeL.objValue;
    }

    public static dk9 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new dk9(tbPageContext);
        }
        return (dk9) invokeL.objValue;
    }

    public static fk9 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new fk9(tbPageContext);
        }
        return (fk9) invokeL.objValue;
    }

    public static gk9 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new gk9(tbPageContext);
        }
        return (gk9) invokeL.objValue;
    }

    public static hk9 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new hk9(tbPageContext);
        }
        return (hk9) invokeL.objValue;
    }

    public static ik9 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new ik9(tbPageContext);
        }
        return (ik9) invokeL.objValue;
    }

    public static lk9 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new lk9(tbPageContext);
        }
        return (lk9) invokeL.objValue;
    }

    public static mk9 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new mk9(tbPageContext);
        }
        return (mk9) invokeL.objValue;
    }

    public static nk9 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new nk9(tbPageContext);
        }
        return (nk9) invokeL.objValue;
    }

    public static ok9 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new ok9(tbPageContext);
        }
        return (ok9) invokeL.objValue;
    }

    public static zj9 c(@NonNull TbPageContext<?> tbPageContext, @NonNull qk9 qk9Var, @NonNull EditorTools editorTools, @NonNull jj9 jj9Var, @NonNull bm9 bm9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, qk9Var, editorTools, jj9Var, bm9Var)) == null) {
            zj9 zj9Var = new zj9(tbPageContext, jj9Var, bm9Var);
            zj9Var.X(qk9Var);
            zj9Var.e0(new a(editorTools));
            return zj9Var;
        }
        return (zj9) invokeLLLLL.objValue;
    }

    public static ek9 h(@NonNull TbPageContext<?> tbPageContext, @NonNull fm9 fm9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, fm9Var)) == null) {
            return new ek9(tbPageContext, fm9Var);
        }
        return (ek9) invokeLL.objValue;
    }

    public static jk9 m(@NonNull TbPageContext<?> tbPageContext, @NonNull qk9 qk9Var, @NonNull EditorTools editorTools, @NonNull fm9 fm9Var, @NonNull jj9 jj9Var, @NonNull bm9 bm9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, qk9Var, editorTools, fm9Var, jj9Var, bm9Var})) == null) {
            jk9 jk9Var = new jk9(tbPageContext, fm9Var, jj9Var, bm9Var);
            jk9Var.a0(qk9Var);
            jk9Var.c0(new b(editorTools));
            return jk9Var;
        }
        return (jk9) invokeCommon.objValue;
    }

    public static kk9 n(@NonNull TbPageContext<?> tbPageContext, @NonNull qk9 qk9Var, @NonNull jj9 jj9Var, @NonNull bm9 bm9Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, qk9Var, jj9Var, bm9Var)) == null) {
            kk9 kk9Var = new kk9(tbPageContext, jj9Var, bm9Var);
            kk9Var.M(qk9Var);
            return kk9Var;
        }
        return (kk9) invokeLLLL.objValue;
    }
}
