package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.ux9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements ux9.f {
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

        @Override // com.baidu.tieba.ux9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new uh5(2, 12, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements ux9.f {
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

        @Override // com.baidu.tieba.ux9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new uh5(2, 12, null));
            }
        }
    }

    public static tga a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new tga(tbPageContext);
        }
        return (tga) invokeL.objValue;
    }

    public static vga b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new vga(tbPageContext);
        }
        return (vga) invokeL.objValue;
    }

    public static xga d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new xga(tbPageContext);
        }
        return (xga) invokeL.objValue;
    }

    public static yga e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new yga(tbPageContext);
        }
        return (yga) invokeL.objValue;
    }

    public static zga f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new zga(tbPageContext);
        }
        return (zga) invokeL.objValue;
    }

    public static aha g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new aha(tbPageContext);
        }
        return (aha) invokeL.objValue;
    }

    public static cha i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new cha(tbPageContext);
        }
        return (cha) invokeL.objValue;
    }

    public static dha j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new dha(tbPageContext);
        }
        return (dha) invokeL.objValue;
    }

    public static eha k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new eha(tbPageContext);
        }
        return (eha) invokeL.objValue;
    }

    public static fha l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new fha(tbPageContext);
        }
        return (fha) invokeL.objValue;
    }

    public static iha o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new iha(tbPageContext);
        }
        return (iha) invokeL.objValue;
    }

    public static jha p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new jha(tbPageContext);
        }
        return (jha) invokeL.objValue;
    }

    public static kha q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new kha(tbPageContext);
        }
        return (kha) invokeL.objValue;
    }

    public static lha r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new lha(tbPageContext);
        }
        return (lha) invokeL.objValue;
    }

    public static wga c(@NonNull TbPageContext<?> tbPageContext, @NonNull nha nhaVar, @NonNull EditorTools editorTools, @NonNull gga ggaVar, @NonNull yia yiaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, nhaVar, editorTools, ggaVar, yiaVar)) == null) {
            wga wgaVar = new wga(tbPageContext, ggaVar, yiaVar);
            wgaVar.U(nhaVar);
            wgaVar.b0(new a(editorTools));
            return wgaVar;
        }
        return (wga) invokeLLLLL.objValue;
    }

    public static bha h(@NonNull TbPageContext<?> tbPageContext, @NonNull cja cjaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, cjaVar)) == null) {
            return new bha(tbPageContext, cjaVar);
        }
        return (bha) invokeLL.objValue;
    }

    public static gha m(@NonNull TbPageContext<?> tbPageContext, @NonNull nha nhaVar, @NonNull EditorTools editorTools, @NonNull cja cjaVar, @NonNull gga ggaVar, @NonNull yia yiaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, nhaVar, editorTools, cjaVar, ggaVar, yiaVar})) == null) {
            gha ghaVar = new gha(tbPageContext, cjaVar, ggaVar, yiaVar);
            ghaVar.W(nhaVar);
            ghaVar.Y(new b(editorTools));
            return ghaVar;
        }
        return (gha) invokeCommon.objValue;
    }

    public static hha n(@NonNull TbPageContext<?> tbPageContext, @NonNull nha nhaVar, @NonNull gga ggaVar, @NonNull yia yiaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, nhaVar, ggaVar, yiaVar)) == null) {
            hha hhaVar = new hha(tbPageContext, ggaVar, yiaVar);
            hhaVar.M(nhaVar);
            return hhaVar;
        }
        return (hha) invokeLLLL.objValue;
    }
}
