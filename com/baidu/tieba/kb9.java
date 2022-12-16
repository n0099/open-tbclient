package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.wr8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class kb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements wr8.f {
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

        @Override // com.baidu.tieba.wr8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new m65(2, 12, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements wr8.f {
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

        @Override // com.baidu.tieba.wr8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new m65(2, 12, null));
            }
        }
    }

    public static j99 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new j99(tbPageContext);
        }
        return (j99) invokeL.objValue;
    }

    public static l99 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new l99(tbPageContext);
        }
        return (l99) invokeL.objValue;
    }

    public static n99 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new n99(tbPageContext);
        }
        return (n99) invokeL.objValue;
    }

    public static o99 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new o99(tbPageContext);
        }
        return (o99) invokeL.objValue;
    }

    public static p99 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new p99(tbPageContext);
        }
        return (p99) invokeL.objValue;
    }

    public static q99 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new q99(tbPageContext);
        }
        return (q99) invokeL.objValue;
    }

    public static s99 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new s99(tbPageContext);
        }
        return (s99) invokeL.objValue;
    }

    public static t99 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new t99(tbPageContext);
        }
        return (t99) invokeL.objValue;
    }

    public static u99 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new u99(tbPageContext);
        }
        return (u99) invokeL.objValue;
    }

    public static v99 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new v99(tbPageContext);
        }
        return (v99) invokeL.objValue;
    }

    public static y99 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new y99(tbPageContext);
        }
        return (y99) invokeL.objValue;
    }

    public static z99 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new z99(tbPageContext);
        }
        return (z99) invokeL.objValue;
    }

    public static aa9 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new aa9(tbPageContext);
        }
        return (aa9) invokeL.objValue;
    }

    public static ba9 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new ba9(tbPageContext);
        }
        return (ba9) invokeL.objValue;
    }

    public static m99 c(@NonNull TbPageContext<?> tbPageContext, @NonNull da9 da9Var, @NonNull EditorTools editorTools, @NonNull w89 w89Var, @NonNull ob9 ob9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, da9Var, editorTools, w89Var, ob9Var)) == null) {
            m99 m99Var = new m99(tbPageContext, w89Var, ob9Var);
            m99Var.T(da9Var);
            m99Var.Z(new a(editorTools));
            return m99Var;
        }
        return (m99) invokeLLLLL.objValue;
    }

    public static r99 h(@NonNull TbPageContext<?> tbPageContext, @NonNull sb9 sb9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, sb9Var)) == null) {
            return new r99(tbPageContext, sb9Var);
        }
        return (r99) invokeLL.objValue;
    }

    public static w99 m(@NonNull TbPageContext<?> tbPageContext, @NonNull da9 da9Var, @NonNull EditorTools editorTools, @NonNull sb9 sb9Var, @NonNull w89 w89Var, @NonNull ob9 ob9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, da9Var, editorTools, sb9Var, w89Var, ob9Var})) == null) {
            w99 w99Var = new w99(tbPageContext, sb9Var, w89Var, ob9Var);
            w99Var.W(da9Var);
            w99Var.Y(new b(editorTools));
            return w99Var;
        }
        return (w99) invokeCommon.objValue;
    }

    public static x99 n(@NonNull TbPageContext<?> tbPageContext, @NonNull da9 da9Var, @NonNull w89 w89Var, @NonNull ob9 ob9Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, da9Var, w89Var, ob9Var)) == null) {
            x99 x99Var = new x99(tbPageContext, w89Var, ob9Var);
            x99Var.M(da9Var);
            return x99Var;
        }
        return (x99) invokeLLLL.objValue;
    }
}
