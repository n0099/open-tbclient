package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.lo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements lo8.f {
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

        @Override // com.baidu.tieba.lo8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new e65(2, 12, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements lo8.f {
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

        @Override // com.baidu.tieba.lo8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new e65(2, 12, null));
            }
        }
    }

    public static o59 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new o59(tbPageContext);
        }
        return (o59) invokeL.objValue;
    }

    public static q59 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new q59(tbPageContext);
        }
        return (q59) invokeL.objValue;
    }

    public static s59 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new s59(tbPageContext);
        }
        return (s59) invokeL.objValue;
    }

    public static t59 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new t59(tbPageContext);
        }
        return (t59) invokeL.objValue;
    }

    public static u59 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new u59(tbPageContext);
        }
        return (u59) invokeL.objValue;
    }

    public static v59 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new v59(tbPageContext);
        }
        return (v59) invokeL.objValue;
    }

    public static x59 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new x59(tbPageContext);
        }
        return (x59) invokeL.objValue;
    }

    public static y59 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new y59(tbPageContext);
        }
        return (y59) invokeL.objValue;
    }

    public static z59 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new z59(tbPageContext);
        }
        return (z59) invokeL.objValue;
    }

    public static a69 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new a69(tbPageContext);
        }
        return (a69) invokeL.objValue;
    }

    public static d69 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new d69(tbPageContext);
        }
        return (d69) invokeL.objValue;
    }

    public static e69 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new e69(tbPageContext);
        }
        return (e69) invokeL.objValue;
    }

    public static f69 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new f69(tbPageContext);
        }
        return (f69) invokeL.objValue;
    }

    public static g69 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new g69(tbPageContext);
        }
        return (g69) invokeL.objValue;
    }

    public static r59 c(@NonNull TbPageContext<?> tbPageContext, @NonNull i69 i69Var, @NonNull EditorTools editorTools, @NonNull b59 b59Var, @NonNull t79 t79Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, i69Var, editorTools, b59Var, t79Var)) == null) {
            r59 r59Var = new r59(tbPageContext, b59Var, t79Var);
            r59Var.T(i69Var);
            r59Var.Z(new a(editorTools));
            return r59Var;
        }
        return (r59) invokeLLLLL.objValue;
    }

    public static w59 h(@NonNull TbPageContext<?> tbPageContext, @NonNull x79 x79Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, x79Var)) == null) {
            return new w59(tbPageContext, x79Var);
        }
        return (w59) invokeLL.objValue;
    }

    public static b69 m(@NonNull TbPageContext<?> tbPageContext, @NonNull i69 i69Var, @NonNull EditorTools editorTools, @NonNull x79 x79Var, @NonNull b59 b59Var, @NonNull t79 t79Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, i69Var, editorTools, x79Var, b59Var, t79Var})) == null) {
            b69 b69Var = new b69(tbPageContext, x79Var, b59Var, t79Var);
            b69Var.V(i69Var);
            b69Var.X(new b(editorTools));
            return b69Var;
        }
        return (b69) invokeCommon.objValue;
    }

    public static c69 n(@NonNull TbPageContext<?> tbPageContext, @NonNull i69 i69Var, @NonNull b59 b59Var, @NonNull t79 t79Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, i69Var, b59Var, t79Var)) == null) {
            c69 c69Var = new c69(tbPageContext, b59Var, t79Var);
            c69Var.M(i69Var);
            return c69Var;
        }
        return (c69) invokeLLLL.objValue;
    }
}
