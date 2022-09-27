package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.vm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements vm8.f {
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

        @Override // com.baidu.tieba.vm8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new h55(2, 12, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements vm8.f {
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

        @Override // com.baidu.tieba.vm8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new h55(2, 12, null));
            }
        }
    }

    public static w39 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) ? new w39(tbPageContext) : (w39) invokeL.objValue;
    }

    public static y39 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) ? new y39(tbPageContext) : (y39) invokeL.objValue;
    }

    public static z39 c(@NonNull TbPageContext<?> tbPageContext, @NonNull o49 o49Var, @NonNull EditorTools editorTools, @NonNull m39 m39Var, @NonNull t59 t59Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, o49Var, editorTools, m39Var, t59Var)) == null) {
            z39 z39Var = new z39(tbPageContext, m39Var, t59Var);
            z39Var.R(o49Var);
            z39Var.W(new a(editorTools));
            return z39Var;
        }
        return (z39) invokeLLLLL.objValue;
    }

    public static a49 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) ? new a49(tbPageContext) : (a49) invokeL.objValue;
    }

    public static b49 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) ? new b49(tbPageContext) : (b49) invokeL.objValue;
    }

    public static c49 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) ? new c49(tbPageContext) : (c49) invokeL.objValue;
    }

    public static d49 g(@NonNull TbPageContext<?> tbPageContext, @NonNull x59 x59Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, tbPageContext, x59Var)) == null) ? new d49(tbPageContext, x59Var) : (d49) invokeLL.objValue;
    }

    public static e49 h(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, tbPageContext)) == null) ? new e49(tbPageContext) : (e49) invokeL.objValue;
    }

    public static f49 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) ? new f49(tbPageContext) : (f49) invokeL.objValue;
    }

    public static g49 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) ? new g49(tbPageContext) : (g49) invokeL.objValue;
    }

    public static h49 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) ? new h49(tbPageContext) : (h49) invokeL.objValue;
    }

    public static i49 l(@NonNull TbPageContext<?> tbPageContext, @NonNull o49 o49Var, @NonNull EditorTools editorTools, @NonNull x59 x59Var, @NonNull m39 m39Var, @NonNull t59 t59Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{tbPageContext, o49Var, editorTools, x59Var, m39Var, t59Var})) == null) {
            i49 i49Var = new i49(tbPageContext, x59Var, m39Var, t59Var);
            i49Var.T(o49Var);
            i49Var.V(new b(editorTools));
            return i49Var;
        }
        return (i49) invokeCommon.objValue;
    }

    public static j49 m(@NonNull TbPageContext<?> tbPageContext, @NonNull o49 o49Var, @NonNull m39 m39Var, @NonNull t59 t59Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, o49Var, m39Var, t59Var)) == null) {
            j49 j49Var = new j49(tbPageContext, m39Var, t59Var);
            j49Var.K(o49Var);
            return j49Var;
        }
        return (j49) invokeLLLL.objValue;
    }

    public static k49 n(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tbPageContext)) == null) ? new k49(tbPageContext) : (k49) invokeL.objValue;
    }

    public static l49 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) ? new l49(tbPageContext) : (l49) invokeL.objValue;
    }

    public static m49 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) ? new m49(tbPageContext) : (m49) invokeL.objValue;
    }
}
