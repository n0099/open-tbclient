package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.aea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p2b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements aea.f {
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

        @Override // com.baidu.tieba.aea.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new cd5(2, 12, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements aea.f {
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

        @Override // com.baidu.tieba.aea.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new cd5(2, 12, null));
            }
        }
    }

    public static o0b a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new o0b(tbPageContext);
        }
        return (o0b) invokeL.objValue;
    }

    public static q0b b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new q0b(tbPageContext);
        }
        return (q0b) invokeL.objValue;
    }

    public static s0b d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new s0b(tbPageContext);
        }
        return (s0b) invokeL.objValue;
    }

    public static t0b e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new t0b(tbPageContext);
        }
        return (t0b) invokeL.objValue;
    }

    public static u0b f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new u0b(tbPageContext);
        }
        return (u0b) invokeL.objValue;
    }

    public static v0b g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new v0b(tbPageContext);
        }
        return (v0b) invokeL.objValue;
    }

    public static x0b i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new x0b(tbPageContext);
        }
        return (x0b) invokeL.objValue;
    }

    public static y0b j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new y0b(tbPageContext);
        }
        return (y0b) invokeL.objValue;
    }

    public static z0b k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new z0b(tbPageContext);
        }
        return (z0b) invokeL.objValue;
    }

    public static a1b l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new a1b(tbPageContext);
        }
        return (a1b) invokeL.objValue;
    }

    public static d1b o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new d1b(tbPageContext);
        }
        return (d1b) invokeL.objValue;
    }

    public static e1b p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new e1b(tbPageContext);
        }
        return (e1b) invokeL.objValue;
    }

    public static f1b q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new f1b(tbPageContext);
        }
        return (f1b) invokeL.objValue;
    }

    public static g1b r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new g1b(tbPageContext);
        }
        return (g1b) invokeL.objValue;
    }

    public static r0b c(@NonNull TbPageContext<?> tbPageContext, @NonNull i1b i1bVar, @NonNull EditorTools editorTools, @NonNull b0b b0bVar, @NonNull t2b t2bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, i1bVar, editorTools, b0bVar, t2bVar)) == null) {
            r0b r0bVar = new r0b(tbPageContext, b0bVar, t2bVar);
            r0bVar.U(i1bVar);
            r0bVar.c0(new a(editorTools));
            return r0bVar;
        }
        return (r0b) invokeLLLLL.objValue;
    }

    public static w0b h(@NonNull TbPageContext<?> tbPageContext, @NonNull x2b x2bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, x2bVar)) == null) {
            return new w0b(tbPageContext, x2bVar);
        }
        return (w0b) invokeLL.objValue;
    }

    public static b1b m(@NonNull TbPageContext<?> tbPageContext, @NonNull i1b i1bVar, @NonNull EditorTools editorTools, @NonNull x2b x2bVar, @NonNull b0b b0bVar, @NonNull t2b t2bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, i1bVar, editorTools, x2bVar, b0bVar, t2bVar})) == null) {
            b1b b1bVar = new b1b(tbPageContext, x2bVar, b0bVar, t2bVar);
            b1bVar.W(i1bVar);
            b1bVar.Y(new b(editorTools));
            return b1bVar;
        }
        return (b1b) invokeCommon.objValue;
    }

    public static c1b n(@NonNull TbPageContext<?> tbPageContext, @NonNull i1b i1bVar, @NonNull b0b b0bVar, @NonNull t2b t2bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, i1bVar, b0bVar, t2bVar)) == null) {
            c1b c1bVar = new c1b(tbPageContext, b0bVar, t2bVar);
            c1bVar.M(i1bVar);
            return c1bVar;
        }
        return (c1b) invokeLLLL.objValue;
    }
}
