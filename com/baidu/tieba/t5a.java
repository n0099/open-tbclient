package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.dl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class t5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements dl9.f {
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

        @Override // com.baidu.tieba.dl9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new pc5(2, 12, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements dl9.f {
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

        @Override // com.baidu.tieba.dl9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new pc5(2, 12, null));
            }
        }
    }

    public static s3a a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new s3a(tbPageContext);
        }
        return (s3a) invokeL.objValue;
    }

    public static u3a b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new u3a(tbPageContext);
        }
        return (u3a) invokeL.objValue;
    }

    public static w3a d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new w3a(tbPageContext);
        }
        return (w3a) invokeL.objValue;
    }

    public static x3a e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new x3a(tbPageContext);
        }
        return (x3a) invokeL.objValue;
    }

    public static y3a f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new y3a(tbPageContext);
        }
        return (y3a) invokeL.objValue;
    }

    public static z3a g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new z3a(tbPageContext);
        }
        return (z3a) invokeL.objValue;
    }

    public static b4a i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new b4a(tbPageContext);
        }
        return (b4a) invokeL.objValue;
    }

    public static c4a j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new c4a(tbPageContext);
        }
        return (c4a) invokeL.objValue;
    }

    public static d4a k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new d4a(tbPageContext);
        }
        return (d4a) invokeL.objValue;
    }

    public static e4a l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new e4a(tbPageContext);
        }
        return (e4a) invokeL.objValue;
    }

    public static h4a o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new h4a(tbPageContext);
        }
        return (h4a) invokeL.objValue;
    }

    public static i4a p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new i4a(tbPageContext);
        }
        return (i4a) invokeL.objValue;
    }

    public static j4a q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new j4a(tbPageContext);
        }
        return (j4a) invokeL.objValue;
    }

    public static k4a r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new k4a(tbPageContext);
        }
        return (k4a) invokeL.objValue;
    }

    public static v3a c(@NonNull TbPageContext<?> tbPageContext, @NonNull m4a m4aVar, @NonNull EditorTools editorTools, @NonNull f3a f3aVar, @NonNull x5a x5aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, m4aVar, editorTools, f3aVar, x5aVar)) == null) {
            v3a v3aVar = new v3a(tbPageContext, f3aVar, x5aVar);
            v3aVar.X(m4aVar);
            v3aVar.e0(new a(editorTools));
            return v3aVar;
        }
        return (v3a) invokeLLLLL.objValue;
    }

    public static a4a h(@NonNull TbPageContext<?> tbPageContext, @NonNull b6a b6aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, b6aVar)) == null) {
            return new a4a(tbPageContext, b6aVar);
        }
        return (a4a) invokeLL.objValue;
    }

    public static f4a m(@NonNull TbPageContext<?> tbPageContext, @NonNull m4a m4aVar, @NonNull EditorTools editorTools, @NonNull b6a b6aVar, @NonNull f3a f3aVar, @NonNull x5a x5aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, m4aVar, editorTools, b6aVar, f3aVar, x5aVar})) == null) {
            f4a f4aVar = new f4a(tbPageContext, b6aVar, f3aVar, x5aVar);
            f4aVar.a0(m4aVar);
            f4aVar.c0(new b(editorTools));
            return f4aVar;
        }
        return (f4a) invokeCommon.objValue;
    }

    public static g4a n(@NonNull TbPageContext<?> tbPageContext, @NonNull m4a m4aVar, @NonNull f3a f3aVar, @NonNull x5a x5aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, m4aVar, f3aVar, x5aVar)) == null) {
            g4a g4aVar = new g4a(tbPageContext, f3aVar, x5aVar);
            g4aVar.M(m4aVar);
            return g4aVar;
        }
        return (g4a) invokeLLLL.objValue;
    }
}
