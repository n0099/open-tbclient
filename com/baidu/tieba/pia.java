package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.px9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements px9.f {
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

        @Override // com.baidu.tieba.px9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new sh5(2, 12, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements px9.f {
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

        @Override // com.baidu.tieba.px9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new sh5(2, 12, null));
            }
        }
    }

    public static oga a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new oga(tbPageContext);
        }
        return (oga) invokeL.objValue;
    }

    public static qga b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new qga(tbPageContext);
        }
        return (qga) invokeL.objValue;
    }

    public static sga d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new sga(tbPageContext);
        }
        return (sga) invokeL.objValue;
    }

    public static tga e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new tga(tbPageContext);
        }
        return (tga) invokeL.objValue;
    }

    public static uga f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new uga(tbPageContext);
        }
        return (uga) invokeL.objValue;
    }

    public static vga g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new vga(tbPageContext);
        }
        return (vga) invokeL.objValue;
    }

    public static xga i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new xga(tbPageContext);
        }
        return (xga) invokeL.objValue;
    }

    public static yga j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new yga(tbPageContext);
        }
        return (yga) invokeL.objValue;
    }

    public static zga k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new zga(tbPageContext);
        }
        return (zga) invokeL.objValue;
    }

    public static aha l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new aha(tbPageContext);
        }
        return (aha) invokeL.objValue;
    }

    public static dha o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new dha(tbPageContext);
        }
        return (dha) invokeL.objValue;
    }

    public static eha p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new eha(tbPageContext);
        }
        return (eha) invokeL.objValue;
    }

    public static fha q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new fha(tbPageContext);
        }
        return (fha) invokeL.objValue;
    }

    public static gha r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new gha(tbPageContext);
        }
        return (gha) invokeL.objValue;
    }

    public static rga c(@NonNull TbPageContext<?> tbPageContext, @NonNull iha ihaVar, @NonNull EditorTools editorTools, @NonNull bga bgaVar, @NonNull tia tiaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, ihaVar, editorTools, bgaVar, tiaVar)) == null) {
            rga rgaVar = new rga(tbPageContext, bgaVar, tiaVar);
            rgaVar.U(ihaVar);
            rgaVar.b0(new a(editorTools));
            return rgaVar;
        }
        return (rga) invokeLLLLL.objValue;
    }

    public static wga h(@NonNull TbPageContext<?> tbPageContext, @NonNull xia xiaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, xiaVar)) == null) {
            return new wga(tbPageContext, xiaVar);
        }
        return (wga) invokeLL.objValue;
    }

    public static bha m(@NonNull TbPageContext<?> tbPageContext, @NonNull iha ihaVar, @NonNull EditorTools editorTools, @NonNull xia xiaVar, @NonNull bga bgaVar, @NonNull tia tiaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, ihaVar, editorTools, xiaVar, bgaVar, tiaVar})) == null) {
            bha bhaVar = new bha(tbPageContext, xiaVar, bgaVar, tiaVar);
            bhaVar.W(ihaVar);
            bhaVar.Y(new b(editorTools));
            return bhaVar;
        }
        return (bha) invokeCommon.objValue;
    }

    public static cha n(@NonNull TbPageContext<?> tbPageContext, @NonNull iha ihaVar, @NonNull bga bgaVar, @NonNull tia tiaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, ihaVar, bgaVar, tiaVar)) == null) {
            cha chaVar = new cha(tbPageContext, bgaVar, tiaVar);
            chaVar.M(ihaVar);
            return chaVar;
        }
        return (cha) invokeLLLL.objValue;
    }
}
