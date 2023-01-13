package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.tw8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements tw8.f {
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

        @Override // com.baidu.tieba.tw8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new z65(2, 12, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements tw8.f {
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

        @Override // com.baidu.tieba.tw8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new z65(2, 12, null));
            }
        }
    }

    public static se9 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new se9(tbPageContext);
        }
        return (se9) invokeL.objValue;
    }

    public static ue9 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new ue9(tbPageContext);
        }
        return (ue9) invokeL.objValue;
    }

    public static we9 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new we9(tbPageContext);
        }
        return (we9) invokeL.objValue;
    }

    public static xe9 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new xe9(tbPageContext);
        }
        return (xe9) invokeL.objValue;
    }

    public static ye9 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new ye9(tbPageContext);
        }
        return (ye9) invokeL.objValue;
    }

    public static ze9 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new ze9(tbPageContext);
        }
        return (ze9) invokeL.objValue;
    }

    public static bf9 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new bf9(tbPageContext);
        }
        return (bf9) invokeL.objValue;
    }

    public static cf9 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new cf9(tbPageContext);
        }
        return (cf9) invokeL.objValue;
    }

    public static df9 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new df9(tbPageContext);
        }
        return (df9) invokeL.objValue;
    }

    public static ef9 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new ef9(tbPageContext);
        }
        return (ef9) invokeL.objValue;
    }

    public static hf9 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new hf9(tbPageContext);
        }
        return (hf9) invokeL.objValue;
    }

    public static if9 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new if9(tbPageContext);
        }
        return (if9) invokeL.objValue;
    }

    public static jf9 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new jf9(tbPageContext);
        }
        return (jf9) invokeL.objValue;
    }

    public static kf9 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new kf9(tbPageContext);
        }
        return (kf9) invokeL.objValue;
    }

    public static ve9 c(@NonNull TbPageContext<?> tbPageContext, @NonNull mf9 mf9Var, @NonNull EditorTools editorTools, @NonNull fe9 fe9Var, @NonNull xg9 xg9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, mf9Var, editorTools, fe9Var, xg9Var)) == null) {
            ve9 ve9Var = new ve9(tbPageContext, fe9Var, xg9Var);
            ve9Var.X(mf9Var);
            ve9Var.e0(new a(editorTools));
            return ve9Var;
        }
        return (ve9) invokeLLLLL.objValue;
    }

    public static af9 h(@NonNull TbPageContext<?> tbPageContext, @NonNull bh9 bh9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, bh9Var)) == null) {
            return new af9(tbPageContext, bh9Var);
        }
        return (af9) invokeLL.objValue;
    }

    public static ff9 m(@NonNull TbPageContext<?> tbPageContext, @NonNull mf9 mf9Var, @NonNull EditorTools editorTools, @NonNull bh9 bh9Var, @NonNull fe9 fe9Var, @NonNull xg9 xg9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, mf9Var, editorTools, bh9Var, fe9Var, xg9Var})) == null) {
            ff9 ff9Var = new ff9(tbPageContext, bh9Var, fe9Var, xg9Var);
            ff9Var.a0(mf9Var);
            ff9Var.c0(new b(editorTools));
            return ff9Var;
        }
        return (ff9) invokeCommon.objValue;
    }

    public static gf9 n(@NonNull TbPageContext<?> tbPageContext, @NonNull mf9 mf9Var, @NonNull fe9 fe9Var, @NonNull xg9 xg9Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, mf9Var, fe9Var, xg9Var)) == null) {
            gf9 gf9Var = new gf9(tbPageContext, fe9Var, xg9Var);
            gf9Var.M(mf9Var);
            return gf9Var;
        }
        return (gf9) invokeLLLL.objValue;
    }
}
