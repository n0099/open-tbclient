package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.ap9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class x9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements ap9.f {
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

        @Override // com.baidu.tieba.ap9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new jd5(2, 12, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements ap9.f {
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

        @Override // com.baidu.tieba.ap9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new jd5(2, 12, null));
            }
        }
    }

    public static w7a a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new w7a(tbPageContext);
        }
        return (w7a) invokeL.objValue;
    }

    public static y7a b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new y7a(tbPageContext);
        }
        return (y7a) invokeL.objValue;
    }

    public static a8a d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new a8a(tbPageContext);
        }
        return (a8a) invokeL.objValue;
    }

    public static b8a e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new b8a(tbPageContext);
        }
        return (b8a) invokeL.objValue;
    }

    public static c8a f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new c8a(tbPageContext);
        }
        return (c8a) invokeL.objValue;
    }

    public static d8a g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new d8a(tbPageContext);
        }
        return (d8a) invokeL.objValue;
    }

    public static f8a i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new f8a(tbPageContext);
        }
        return (f8a) invokeL.objValue;
    }

    public static g8a j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new g8a(tbPageContext);
        }
        return (g8a) invokeL.objValue;
    }

    public static h8a k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new h8a(tbPageContext);
        }
        return (h8a) invokeL.objValue;
    }

    public static i8a l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new i8a(tbPageContext);
        }
        return (i8a) invokeL.objValue;
    }

    public static l8a o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new l8a(tbPageContext);
        }
        return (l8a) invokeL.objValue;
    }

    public static m8a p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new m8a(tbPageContext);
        }
        return (m8a) invokeL.objValue;
    }

    public static n8a q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new n8a(tbPageContext);
        }
        return (n8a) invokeL.objValue;
    }

    public static o8a r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new o8a(tbPageContext);
        }
        return (o8a) invokeL.objValue;
    }

    public static z7a c(@NonNull TbPageContext<?> tbPageContext, @NonNull q8a q8aVar, @NonNull EditorTools editorTools, @NonNull j7a j7aVar, @NonNull baa baaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, q8aVar, editorTools, j7aVar, baaVar)) == null) {
            z7a z7aVar = new z7a(tbPageContext, j7aVar, baaVar);
            z7aVar.X(q8aVar);
            z7aVar.e0(new a(editorTools));
            return z7aVar;
        }
        return (z7a) invokeLLLLL.objValue;
    }

    public static e8a h(@NonNull TbPageContext<?> tbPageContext, @NonNull faa faaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, faaVar)) == null) {
            return new e8a(tbPageContext, faaVar);
        }
        return (e8a) invokeLL.objValue;
    }

    public static j8a m(@NonNull TbPageContext<?> tbPageContext, @NonNull q8a q8aVar, @NonNull EditorTools editorTools, @NonNull faa faaVar, @NonNull j7a j7aVar, @NonNull baa baaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, q8aVar, editorTools, faaVar, j7aVar, baaVar})) == null) {
            j8a j8aVar = new j8a(tbPageContext, faaVar, j7aVar, baaVar);
            j8aVar.a0(q8aVar);
            j8aVar.c0(new b(editorTools));
            return j8aVar;
        }
        return (j8a) invokeCommon.objValue;
    }

    public static k8a n(@NonNull TbPageContext<?> tbPageContext, @NonNull q8a q8aVar, @NonNull j7a j7aVar, @NonNull baa baaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, q8aVar, j7aVar, baaVar)) == null) {
            k8a k8aVar = new k8a(tbPageContext, j7aVar, baaVar);
            k8aVar.M(q8aVar);
            return k8aVar;
        }
        return (k8a) invokeLLLL.objValue;
    }
}
