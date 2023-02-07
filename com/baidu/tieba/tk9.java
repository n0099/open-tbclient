package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.r09;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements r09.f {
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

        @Override // com.baidu.tieba.r09.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new lb5(2, 12, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements r09.f {
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

        @Override // com.baidu.tieba.r09.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new lb5(2, 12, null));
            }
        }
    }

    public static si9 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new si9(tbPageContext);
        }
        return (si9) invokeL.objValue;
    }

    public static ui9 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new ui9(tbPageContext);
        }
        return (ui9) invokeL.objValue;
    }

    public static wi9 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new wi9(tbPageContext);
        }
        return (wi9) invokeL.objValue;
    }

    public static xi9 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new xi9(tbPageContext);
        }
        return (xi9) invokeL.objValue;
    }

    public static yi9 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new yi9(tbPageContext);
        }
        return (yi9) invokeL.objValue;
    }

    public static zi9 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new zi9(tbPageContext);
        }
        return (zi9) invokeL.objValue;
    }

    public static bj9 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new bj9(tbPageContext);
        }
        return (bj9) invokeL.objValue;
    }

    public static cj9 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new cj9(tbPageContext);
        }
        return (cj9) invokeL.objValue;
    }

    public static dj9 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new dj9(tbPageContext);
        }
        return (dj9) invokeL.objValue;
    }

    public static ej9 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new ej9(tbPageContext);
        }
        return (ej9) invokeL.objValue;
    }

    public static hj9 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new hj9(tbPageContext);
        }
        return (hj9) invokeL.objValue;
    }

    public static ij9 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new ij9(tbPageContext);
        }
        return (ij9) invokeL.objValue;
    }

    public static jj9 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new jj9(tbPageContext);
        }
        return (jj9) invokeL.objValue;
    }

    public static kj9 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new kj9(tbPageContext);
        }
        return (kj9) invokeL.objValue;
    }

    public static vi9 c(@NonNull TbPageContext<?> tbPageContext, @NonNull mj9 mj9Var, @NonNull EditorTools editorTools, @NonNull fi9 fi9Var, @NonNull xk9 xk9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, mj9Var, editorTools, fi9Var, xk9Var)) == null) {
            vi9 vi9Var = new vi9(tbPageContext, fi9Var, xk9Var);
            vi9Var.X(mj9Var);
            vi9Var.e0(new a(editorTools));
            return vi9Var;
        }
        return (vi9) invokeLLLLL.objValue;
    }

    public static aj9 h(@NonNull TbPageContext<?> tbPageContext, @NonNull bl9 bl9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, bl9Var)) == null) {
            return new aj9(tbPageContext, bl9Var);
        }
        return (aj9) invokeLL.objValue;
    }

    public static fj9 m(@NonNull TbPageContext<?> tbPageContext, @NonNull mj9 mj9Var, @NonNull EditorTools editorTools, @NonNull bl9 bl9Var, @NonNull fi9 fi9Var, @NonNull xk9 xk9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, mj9Var, editorTools, bl9Var, fi9Var, xk9Var})) == null) {
            fj9 fj9Var = new fj9(tbPageContext, bl9Var, fi9Var, xk9Var);
            fj9Var.a0(mj9Var);
            fj9Var.c0(new b(editorTools));
            return fj9Var;
        }
        return (fj9) invokeCommon.objValue;
    }

    public static gj9 n(@NonNull TbPageContext<?> tbPageContext, @NonNull mj9 mj9Var, @NonNull fi9 fi9Var, @NonNull xk9 xk9Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, mj9Var, fi9Var, xk9Var)) == null) {
            gj9 gj9Var = new gj9(tbPageContext, fi9Var, xk9Var);
            gj9Var.M(mj9Var);
            return gj9Var;
        }
        return (gj9) invokeLLLL.objValue;
    }
}
