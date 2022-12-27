package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.xr8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements xr8.f {
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

        @Override // com.baidu.tieba.xr8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new m65(2, 12, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements xr8.f {
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

        @Override // com.baidu.tieba.xr8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new m65(2, 12, null));
            }
        }
    }

    public static k99 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new k99(tbPageContext);
        }
        return (k99) invokeL.objValue;
    }

    public static m99 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new m99(tbPageContext);
        }
        return (m99) invokeL.objValue;
    }

    public static o99 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new o99(tbPageContext);
        }
        return (o99) invokeL.objValue;
    }

    public static p99 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new p99(tbPageContext);
        }
        return (p99) invokeL.objValue;
    }

    public static q99 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new q99(tbPageContext);
        }
        return (q99) invokeL.objValue;
    }

    public static r99 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new r99(tbPageContext);
        }
        return (r99) invokeL.objValue;
    }

    public static t99 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new t99(tbPageContext);
        }
        return (t99) invokeL.objValue;
    }

    public static u99 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new u99(tbPageContext);
        }
        return (u99) invokeL.objValue;
    }

    public static v99 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new v99(tbPageContext);
        }
        return (v99) invokeL.objValue;
    }

    public static w99 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new w99(tbPageContext);
        }
        return (w99) invokeL.objValue;
    }

    public static z99 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new z99(tbPageContext);
        }
        return (z99) invokeL.objValue;
    }

    public static aa9 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new aa9(tbPageContext);
        }
        return (aa9) invokeL.objValue;
    }

    public static ba9 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new ba9(tbPageContext);
        }
        return (ba9) invokeL.objValue;
    }

    public static ca9 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new ca9(tbPageContext);
        }
        return (ca9) invokeL.objValue;
    }

    public static n99 c(@NonNull TbPageContext<?> tbPageContext, @NonNull ea9 ea9Var, @NonNull EditorTools editorTools, @NonNull x89 x89Var, @NonNull pb9 pb9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, ea9Var, editorTools, x89Var, pb9Var)) == null) {
            n99 n99Var = new n99(tbPageContext, x89Var, pb9Var);
            n99Var.T(ea9Var);
            n99Var.Z(new a(editorTools));
            return n99Var;
        }
        return (n99) invokeLLLLL.objValue;
    }

    public static s99 h(@NonNull TbPageContext<?> tbPageContext, @NonNull tb9 tb9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, tb9Var)) == null) {
            return new s99(tbPageContext, tb9Var);
        }
        return (s99) invokeLL.objValue;
    }

    public static x99 m(@NonNull TbPageContext<?> tbPageContext, @NonNull ea9 ea9Var, @NonNull EditorTools editorTools, @NonNull tb9 tb9Var, @NonNull x89 x89Var, @NonNull pb9 pb9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, ea9Var, editorTools, tb9Var, x89Var, pb9Var})) == null) {
            x99 x99Var = new x99(tbPageContext, tb9Var, x89Var, pb9Var);
            x99Var.W(ea9Var);
            x99Var.Y(new b(editorTools));
            return x99Var;
        }
        return (x99) invokeCommon.objValue;
    }

    public static y99 n(@NonNull TbPageContext<?> tbPageContext, @NonNull ea9 ea9Var, @NonNull x89 x89Var, @NonNull pb9 pb9Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, ea9Var, x89Var, pb9Var)) == null) {
            y99 y99Var = new y99(tbPageContext, x89Var, pb9Var);
            y99Var.M(ea9Var);
            return y99Var;
        }
        return (y99) invokeLLLL.objValue;
    }
}
