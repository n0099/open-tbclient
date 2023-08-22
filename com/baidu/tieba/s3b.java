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
public class s3b {
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

    public static r1b a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new r1b(tbPageContext);
        }
        return (r1b) invokeL.objValue;
    }

    public static t1b b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new t1b(tbPageContext);
        }
        return (t1b) invokeL.objValue;
    }

    public static v1b d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new v1b(tbPageContext);
        }
        return (v1b) invokeL.objValue;
    }

    public static w1b e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new w1b(tbPageContext);
        }
        return (w1b) invokeL.objValue;
    }

    public static x1b f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new x1b(tbPageContext);
        }
        return (x1b) invokeL.objValue;
    }

    public static y1b g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new y1b(tbPageContext);
        }
        return (y1b) invokeL.objValue;
    }

    public static a2b i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new a2b(tbPageContext);
        }
        return (a2b) invokeL.objValue;
    }

    public static b2b j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new b2b(tbPageContext);
        }
        return (b2b) invokeL.objValue;
    }

    public static c2b k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new c2b(tbPageContext);
        }
        return (c2b) invokeL.objValue;
    }

    public static d2b l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new d2b(tbPageContext);
        }
        return (d2b) invokeL.objValue;
    }

    public static g2b o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new g2b(tbPageContext);
        }
        return (g2b) invokeL.objValue;
    }

    public static h2b p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new h2b(tbPageContext);
        }
        return (h2b) invokeL.objValue;
    }

    public static i2b q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new i2b(tbPageContext);
        }
        return (i2b) invokeL.objValue;
    }

    public static j2b r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new j2b(tbPageContext);
        }
        return (j2b) invokeL.objValue;
    }

    public static u1b c(@NonNull TbPageContext<?> tbPageContext, @NonNull l2b l2bVar, @NonNull EditorTools editorTools, @NonNull e1b e1bVar, @NonNull w3b w3bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, l2bVar, editorTools, e1bVar, w3bVar)) == null) {
            u1b u1bVar = new u1b(tbPageContext, e1bVar, w3bVar);
            u1bVar.U(l2bVar);
            u1bVar.b0(new a(editorTools));
            return u1bVar;
        }
        return (u1b) invokeLLLLL.objValue;
    }

    public static z1b h(@NonNull TbPageContext<?> tbPageContext, @NonNull a4b a4bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, a4bVar)) == null) {
            return new z1b(tbPageContext, a4bVar);
        }
        return (z1b) invokeLL.objValue;
    }

    public static e2b m(@NonNull TbPageContext<?> tbPageContext, @NonNull l2b l2bVar, @NonNull EditorTools editorTools, @NonNull a4b a4bVar, @NonNull e1b e1bVar, @NonNull w3b w3bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, l2bVar, editorTools, a4bVar, e1bVar, w3bVar})) == null) {
            e2b e2bVar = new e2b(tbPageContext, a4bVar, e1bVar, w3bVar);
            e2bVar.W(l2bVar);
            e2bVar.Y(new b(editorTools));
            return e2bVar;
        }
        return (e2b) invokeCommon.objValue;
    }

    public static f2b n(@NonNull TbPageContext<?> tbPageContext, @NonNull l2b l2bVar, @NonNull e1b e1bVar, @NonNull w3b w3bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, l2bVar, e1bVar, w3bVar)) == null) {
            f2b f2bVar = new f2b(tbPageContext, e1bVar, w3bVar);
            f2bVar.M(l2bVar);
            return f2bVar;
        }
        return (f2b) invokeLLLL.objValue;
    }
}
