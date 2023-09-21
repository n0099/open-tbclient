package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.kja;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements kja.f {
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

        @Override // com.baidu.tieba.kja.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new wi5(2, 12, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements kja.f {
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

        @Override // com.baidu.tieba.kja.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new wi5(2, 12, null));
            }
        }
    }

    public static t5b a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new t5b(tbPageContext);
        }
        return (t5b) invokeL.objValue;
    }

    public static v5b b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new v5b(tbPageContext);
        }
        return (v5b) invokeL.objValue;
    }

    public static x5b d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new x5b(tbPageContext);
        }
        return (x5b) invokeL.objValue;
    }

    public static y5b e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new y5b(tbPageContext);
        }
        return (y5b) invokeL.objValue;
    }

    public static z5b f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new z5b(tbPageContext);
        }
        return (z5b) invokeL.objValue;
    }

    public static a6b g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new a6b(tbPageContext);
        }
        return (a6b) invokeL.objValue;
    }

    public static c6b i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new c6b(tbPageContext);
        }
        return (c6b) invokeL.objValue;
    }

    public static d6b j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new d6b(tbPageContext);
        }
        return (d6b) invokeL.objValue;
    }

    public static e6b k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new e6b(tbPageContext);
        }
        return (e6b) invokeL.objValue;
    }

    public static f6b l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new f6b(tbPageContext);
        }
        return (f6b) invokeL.objValue;
    }

    public static i6b o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new i6b(tbPageContext);
        }
        return (i6b) invokeL.objValue;
    }

    public static j6b p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new j6b(tbPageContext);
        }
        return (j6b) invokeL.objValue;
    }

    public static k6b q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new k6b(tbPageContext);
        }
        return (k6b) invokeL.objValue;
    }

    public static l6b r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new l6b(tbPageContext);
        }
        return (l6b) invokeL.objValue;
    }

    public static w5b c(@NonNull TbPageContext<?> tbPageContext, @NonNull n6b n6bVar, @NonNull EditorTools editorTools, @NonNull g5b g5bVar, @NonNull y7b y7bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, n6bVar, editorTools, g5bVar, y7bVar)) == null) {
            w5b w5bVar = new w5b(tbPageContext, g5bVar, y7bVar);
            w5bVar.U(n6bVar);
            w5bVar.c0(new a(editorTools));
            return w5bVar;
        }
        return (w5b) invokeLLLLL.objValue;
    }

    public static b6b h(@NonNull TbPageContext<?> tbPageContext, @NonNull c8b c8bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, c8bVar)) == null) {
            return new b6b(tbPageContext, c8bVar);
        }
        return (b6b) invokeLL.objValue;
    }

    public static g6b m(@NonNull TbPageContext<?> tbPageContext, @NonNull n6b n6bVar, @NonNull EditorTools editorTools, @NonNull c8b c8bVar, @NonNull g5b g5bVar, @NonNull y7b y7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, n6bVar, editorTools, c8bVar, g5bVar, y7bVar})) == null) {
            g6b g6bVar = new g6b(tbPageContext, c8bVar, g5bVar, y7bVar);
            g6bVar.W(n6bVar);
            g6bVar.Y(new b(editorTools));
            return g6bVar;
        }
        return (g6b) invokeCommon.objValue;
    }

    public static h6b n(@NonNull TbPageContext<?> tbPageContext, @NonNull n6b n6bVar, @NonNull g5b g5bVar, @NonNull y7b y7bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, n6bVar, g5bVar, y7bVar)) == null) {
            h6b h6bVar = new h6b(tbPageContext, g5bVar, y7bVar);
            h6bVar.M(n6bVar);
            return h6bVar;
        }
        return (h6b) invokeLLLL.objValue;
    }
}
