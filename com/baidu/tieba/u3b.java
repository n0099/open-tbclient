package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.lfa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements lfa.f {
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

        @Override // com.baidu.tieba.lfa.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new zh5(2, 12, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements lfa.f {
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

        @Override // com.baidu.tieba.lfa.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new zh5(2, 12, null));
            }
        }
    }

    public static t1b a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new t1b(tbPageContext);
        }
        return (t1b) invokeL.objValue;
    }

    public static v1b b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new v1b(tbPageContext);
        }
        return (v1b) invokeL.objValue;
    }

    public static x1b d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new x1b(tbPageContext);
        }
        return (x1b) invokeL.objValue;
    }

    public static y1b e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new y1b(tbPageContext);
        }
        return (y1b) invokeL.objValue;
    }

    public static z1b f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new z1b(tbPageContext);
        }
        return (z1b) invokeL.objValue;
    }

    public static a2b g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new a2b(tbPageContext);
        }
        return (a2b) invokeL.objValue;
    }

    public static c2b i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new c2b(tbPageContext);
        }
        return (c2b) invokeL.objValue;
    }

    public static d2b j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new d2b(tbPageContext);
        }
        return (d2b) invokeL.objValue;
    }

    public static e2b k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new e2b(tbPageContext);
        }
        return (e2b) invokeL.objValue;
    }

    public static f2b l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new f2b(tbPageContext);
        }
        return (f2b) invokeL.objValue;
    }

    public static i2b o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new i2b(tbPageContext);
        }
        return (i2b) invokeL.objValue;
    }

    public static j2b p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new j2b(tbPageContext);
        }
        return (j2b) invokeL.objValue;
    }

    public static k2b q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new k2b(tbPageContext);
        }
        return (k2b) invokeL.objValue;
    }

    public static l2b r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new l2b(tbPageContext);
        }
        return (l2b) invokeL.objValue;
    }

    public static w1b c(@NonNull TbPageContext<?> tbPageContext, @NonNull n2b n2bVar, @NonNull EditorTools editorTools, @NonNull g1b g1bVar, @NonNull y3b y3bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, n2bVar, editorTools, g1bVar, y3bVar)) == null) {
            w1b w1bVar = new w1b(tbPageContext, g1bVar, y3bVar);
            w1bVar.U(n2bVar);
            w1bVar.b0(new a(editorTools));
            return w1bVar;
        }
        return (w1b) invokeLLLLL.objValue;
    }

    public static b2b h(@NonNull TbPageContext<?> tbPageContext, @NonNull c4b c4bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, c4bVar)) == null) {
            return new b2b(tbPageContext, c4bVar);
        }
        return (b2b) invokeLL.objValue;
    }

    public static g2b m(@NonNull TbPageContext<?> tbPageContext, @NonNull n2b n2bVar, @NonNull EditorTools editorTools, @NonNull c4b c4bVar, @NonNull g1b g1bVar, @NonNull y3b y3bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, n2bVar, editorTools, c4bVar, g1bVar, y3bVar})) == null) {
            g2b g2bVar = new g2b(tbPageContext, c4bVar, g1bVar, y3bVar);
            g2bVar.W(n2bVar);
            g2bVar.Y(new b(editorTools));
            return g2bVar;
        }
        return (g2b) invokeCommon.objValue;
    }

    public static h2b n(@NonNull TbPageContext<?> tbPageContext, @NonNull n2b n2bVar, @NonNull g1b g1bVar, @NonNull y3b y3bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, n2bVar, g1bVar, y3bVar)) == null) {
            h2b h2bVar = new h2b(tbPageContext, g1bVar, y3bVar);
            h2bVar.M(n2bVar);
            return h2bVar;
        }
        return (h2b) invokeLLLL.objValue;
    }
}
