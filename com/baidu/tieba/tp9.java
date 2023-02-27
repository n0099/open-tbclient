package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.h59;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements h59.f {
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

        @Override // com.baidu.tieba.h59.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new yc5(2, 12, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements h59.f {
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

        @Override // com.baidu.tieba.h59.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new yc5(2, 12, null));
            }
        }
    }

    public static sn9 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new sn9(tbPageContext);
        }
        return (sn9) invokeL.objValue;
    }

    public static un9 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new un9(tbPageContext);
        }
        return (un9) invokeL.objValue;
    }

    public static wn9 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new wn9(tbPageContext);
        }
        return (wn9) invokeL.objValue;
    }

    public static xn9 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new xn9(tbPageContext);
        }
        return (xn9) invokeL.objValue;
    }

    public static yn9 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new yn9(tbPageContext);
        }
        return (yn9) invokeL.objValue;
    }

    public static zn9 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new zn9(tbPageContext);
        }
        return (zn9) invokeL.objValue;
    }

    public static bo9 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new bo9(tbPageContext);
        }
        return (bo9) invokeL.objValue;
    }

    public static co9 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new co9(tbPageContext);
        }
        return (co9) invokeL.objValue;
    }

    public static do9 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new do9(tbPageContext);
        }
        return (do9) invokeL.objValue;
    }

    public static eo9 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new eo9(tbPageContext);
        }
        return (eo9) invokeL.objValue;
    }

    public static ho9 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new ho9(tbPageContext);
        }
        return (ho9) invokeL.objValue;
    }

    public static io9 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new io9(tbPageContext);
        }
        return (io9) invokeL.objValue;
    }

    public static jo9 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new jo9(tbPageContext);
        }
        return (jo9) invokeL.objValue;
    }

    public static ko9 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new ko9(tbPageContext);
        }
        return (ko9) invokeL.objValue;
    }

    public static vn9 c(@NonNull TbPageContext<?> tbPageContext, @NonNull mo9 mo9Var, @NonNull EditorTools editorTools, @NonNull fn9 fn9Var, @NonNull xp9 xp9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, mo9Var, editorTools, fn9Var, xp9Var)) == null) {
            vn9 vn9Var = new vn9(tbPageContext, fn9Var, xp9Var);
            vn9Var.X(mo9Var);
            vn9Var.e0(new a(editorTools));
            return vn9Var;
        }
        return (vn9) invokeLLLLL.objValue;
    }

    public static ao9 h(@NonNull TbPageContext<?> tbPageContext, @NonNull bq9 bq9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, bq9Var)) == null) {
            return new ao9(tbPageContext, bq9Var);
        }
        return (ao9) invokeLL.objValue;
    }

    public static fo9 m(@NonNull TbPageContext<?> tbPageContext, @NonNull mo9 mo9Var, @NonNull EditorTools editorTools, @NonNull bq9 bq9Var, @NonNull fn9 fn9Var, @NonNull xp9 xp9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, mo9Var, editorTools, bq9Var, fn9Var, xp9Var})) == null) {
            fo9 fo9Var = new fo9(tbPageContext, bq9Var, fn9Var, xp9Var);
            fo9Var.a0(mo9Var);
            fo9Var.c0(new b(editorTools));
            return fo9Var;
        }
        return (fo9) invokeCommon.objValue;
    }

    public static go9 n(@NonNull TbPageContext<?> tbPageContext, @NonNull mo9 mo9Var, @NonNull fn9 fn9Var, @NonNull xp9 xp9Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, mo9Var, fn9Var, xp9Var)) == null) {
            go9 go9Var = new go9(tbPageContext, fn9Var, xp9Var);
            go9Var.M(mo9Var);
            return go9Var;
        }
        return (go9) invokeLLLL.objValue;
    }
}
